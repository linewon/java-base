package line.lang.thread;

import java.util.Random;

/**
 * 10长火车票（共享资源），3个售票员（多线程）
 * 
 * 本例中，由于并发数较少，且int变量不怎么需要加锁，再加上只是一个简单的demo
 * 就没有用到锁的操作
 * 
 * 爬虫队列就相当于是火车票，每一个将要爬取的网页url就是一张火车票，售票员就是网页的处理逻辑
 * @author line
 */
public class ThreadDemo extends Thread {

	private int tickets = 10;
	private Random random = new Random();

	public void run() {
		try {
			while (true) {
				// 在这个地方加锁
				int sec = random.nextInt(10) * 1000;
				System.out.println(Thread.currentThread().getName() + " sleep for " + sec);
				Thread.sleep(sec);
				if (this.tickets <= 0) {
					System.out.println(Thread.currentThread().getName() + " over");
					break;
				}
				System.out.println(Thread.currentThread().getName() + " has sold ticket : " + this.tickets);
				System.out.println();
				this.tickets--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Runnable demo = new ThreadDemo();
		
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(demo, "thread-" + (i+1));
			thread.start();
		}
	}

}
