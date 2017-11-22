package line.lang.thread;

import java.util.Random;

/**
 * 10长火车票，3个售票员的故事
 * 
 * @author line
 */
public class RunableDemo implements Runnable {
	
	private int tickets = 10;
	private Random random = new Random();

	public void run() {
		try {
			while (true) {
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
		
		Runnable demo = new RunableDemo();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(demo, "thread-" + (i+1));
			thread.start();
		}
	}
}
