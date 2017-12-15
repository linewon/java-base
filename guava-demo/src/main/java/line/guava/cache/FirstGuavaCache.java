package line.guava.cache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * my first guava cache demo: put & get
 * 
 * reference: http://blog.csdn.net/zhangjikuan/article/details/76408456
 * 
 * Q: difference between guava Cache and ConcurrentHashMap?
 * @author line
 *
 */
public class FirstGuavaCache {

	public static void main(String[] args) {
		Cache<Integer, Integer> cache = CacheBuilder.newBuilder()
				//设置cache的初始大小为10，要合理设置该值  
		        .initialCapacity(10)  
		        //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作  
		        .concurrencyLevel(5)  
		        //设置cache中的数据在写入之后的存活时间为10秒  
		        .expireAfterWrite(10, TimeUnit.SECONDS)  
		        //构建cache实例  
				.build();
		
		
		cache.put(1, 100);
	    for(int i=0 ;i<100 ;i++) {  
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
	        System.out.println(sdf.format(new Date())   
	                + "  key:1 ,value:"+cache.getIfPresent(1));  
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
	    }
	}
}
