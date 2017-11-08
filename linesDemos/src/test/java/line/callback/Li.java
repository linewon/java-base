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
	public void textWang(CallBack callBack, String text) {
		
		try {
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
