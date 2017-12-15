package line.guava.cache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;


/**
 * 模拟用户访问网页
 * 3个进程在放网页，5个进程在读网页
 * ExecutorService.线程池进行管理
 * 
 * reference: http://blog.csdn.net/zhangjikuan/article/details/76408456
 * 
 * @author line
 *
 */
public class GuavaCacheDemo {
	// 生成随机数代表网页链接
	private static Random random = new Random();
	public static void main(String[] args) {
		// 构建cache实例
		// reason for final: http://blog.csdn.net/cshichao/article/details/9181387
		final Cache<String, WebSite> cache = CacheBuilder.newBuilder()
				.initialCapacity(10)	// 初始化容量
				.concurrencyLevel(5)	// 并发数
				.expireAfterWrite(10, TimeUnit.SECONDS)		// 访问后存活时间
				.expireAfterAccess(10, TimeUnit.SECONDS)	// 写入后存活时间
				.build();	
		
		// 线程池
		ExecutorService pool = Executors.newFixedThreadPool(8);
		// 制造者线程
		for (int i = 0; i < 3; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					String url = String.valueOf(random.nextInt(20));
					Date cur = new Date();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String content = df.format(cur); // 感觉这个比喻好不恰当...
					cache.put(url, new WebSite(url, content));
				}
			});
		}
		// 访问者线程
		for (int i = 0; i < 5; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					
				}
			});
		}
	}
}

class WebSite {
	private String url;
	private String visitTime; // 系统当前时间代表网页内容

	public WebSite(String url, String content) {
		this.url = url;
		this.visitTime = content;
	}
	
	public String getContent() {
		return visitTime;
	}
	public void setContent(String content) {
		this.visitTime = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
