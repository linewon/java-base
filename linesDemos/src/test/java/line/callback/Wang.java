package line.callback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wang implements CallBack {

	private String mood;
	
	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getMood() {
		return this.mood;
	}
	/**
	 * 通过静态内部类实现懒汉单例模式
	 */
	private Wang() {}
	private static class SingleHolder {
		private static final Wang INSTANCE = new Wang();
	}
	public static final Wang getInstance() {
		return SingleHolder.INSTANCE;
	}
	
	private static Li li = Li.getInstance(); 
	/**
	 * 告诉li让他有时间了回个短信
	 */
	public void tellLi() {
		new Thread(new Runnable() {
			public void run() {
				Date cur = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = df.format(cur);
				li.textWang(Wang.this, dateStr);
			}
		}).start();
		System.out.println("wang has told li !");
	}
	/**
	 * 集成了callback，当li给wang回电话时调用wang.call(text)
	 */
	public void text(String text) {
		System.out.println("wang recieved text : " + text);
	}

}
