package line.util.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<String> plateQueue = new LinkedBlockingQueue<String>();
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

class Producer implements Runnable {

	private BlockingQueue<String> plateQueue = null;
	private String name = null;
	
	public Producer(String name, BlockingQueue<String> queue) {
		this.name = name;
		this. plateQueue = queue;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				plateQueue.put("washed a plate");
				System.out.println("producer " + this.name + " has washed a plate");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	private BlockingQueue<String> plateQueue = null;
	private String name = null;
	
	public Consumer(String name, BlockingQueue<String> queue) {
		this.name = name;
		this. plateQueue = queue;
	}
	@Override
	public void run() {
		try {
			while (true) {
				plateQueue.take();
				System.out.println("consumer " + this.name + " has washed a plate");
				Thread.sleep(1500);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
