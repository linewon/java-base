package line.callback;

public class Li {
	/**
	 * 同样实现单例模式
	 */
	private Li() {}
	private static class SingleHolder {
		private static final Li INSTANCE = new Li();
	}
	public static final Li getInstance() {
		return SingleHolder.INSTANCE;
	}
	private static boolean lock = true;
	
	/**
	 * 机上synchronized互斥锁后，单例对象的这个方法，在同一时刻只能被同一个线程所执行
	 * @param callBack
	 * @param text
	 */
	public synchronized void textWang(CallBack callBack, String text) {
		
		try {
			System.out.println("li was watching movie.");
			// 看了一场电影。
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		callBack.text(text);
		System.out.println("li has text wang !");
	}
	
	@Override
	public int hashCode() {
		while (lock) {
			lock = false;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		lock = true;
		return super.hashCode();
	}
}
