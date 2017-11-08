package line.util.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 通过线程池以及blockingqueue模拟生产者-消费者模式
 * blockingqueue用来装洗好的盘子，(柜子)
 * 生产者将洗干净的盘子put到queue中，（洗碗工）
 * 消费者从queue中take洗干净的盘子。（厨子）
 * 用ExecutorService来生成并管理线程池cachedThreadPool
 * @author line
 *
 */
public class Main {

	/**
	 * 向线程池中提交2个生产者线程和4个消费者线程。
	 * 同时操作blockingqueue，进行put和take操作。
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> plateQueue = new LinkedBlockingQueue<String>(5);
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		int numCons = 4;
		int numProd = 2;
		for (int i = 0; i < numCons; i++) {
			executorService.submit(new Consumer(String.valueOf(i), plateQueue));
		}
		
		for (int i = 0; i < numProd; i++) {
			executorService.submit(new Producer(String.valueOf(i), plateQueue));
		}
	}
}

/**
 * 生产者，洗盘子
 * @author line
 *
 */
class Producer implements Runnable {

	private BlockingQueue<String> plateQueue = null;
	private String name = null;
	
	public Producer(String name, BlockingQueue<String> queue) {
		this.name = name;
		this. plateQueue = queue;
	}
	
	public void run() {
		try {
			while (true) {
				int sleep = (Integer.parseInt(this.name) + 1) * 1000;
				Thread.sleep(sleep);
				int size = plateQueue.size();
				System.out.println("pro-" + this.name + " current queue.size : " + size);
				plateQueue.put("washed a plate"); // 向blockingqueue中put刚洗好的盘子（String）
				size = plateQueue.size();
				System.out.println("producer " + this.name + " has washed a plate : " + size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 消费者，取盘子
 * @author line
 *
 */
class Consumer implements Runnable {

	private BlockingQueue<String> plateQueue = null;
	private String name = null;
	
	public Consumer(String name, BlockingQueue<String> queue) {
		this.name = name;
		this. plateQueue = queue;
	}
	public void run() {
		try {
			while (true) {
				int sleep = (Integer.parseInt(this.name) + 1) * 2000;
				Thread.sleep(sleep);
				int size = plateQueue.size();
				System.out.println("cons-" + this.name + " current queue.size : " + size);
				plateQueue.take(); // 从blockingqueue中take刚洗干净的盘子
				size = plateQueue.size();
				System.out.println("consumer " + this.name + " has taken a plate : " + size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
