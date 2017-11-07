package line.callback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleTest {
	/**
	 * 这边理解没问题，也获得了单例对象，
	 * 只不过想要单例对象的方法同一个时刻只被一个线程调用，
	 * 还需要在方法上加上互斥锁。
	 * 如果方法涉及到共享变量的修改操作，也是一样的道理。
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		for (int i = 0; i < 10; i++) {
			// 10 threads
			Date cur = new Date();
			new Thread(new Runnable() {
				public void run() {
					Li li = Li.getInstance();
					System.out.print(li.hashCode());
					System.out.println("  by " + Thread.currentThread().getName());
				}
			}, df.format(cur)).start();
			
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
