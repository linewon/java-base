package line.callback;

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
