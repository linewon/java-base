package line.callback;

/**
 * callback与多线程结合
 * @author line
 *
 */
public class Main {
	public static void main(String[] args) {
		Wang wang = Wang.getInstance();
		wang.tellLi();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wang.tellLi();
	}
}
