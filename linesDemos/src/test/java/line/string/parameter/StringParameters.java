package line.string.parameter;

public class StringParameters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abc";
		a(str);
		System.out.println("after a() : " + str);

	}

	public static void a(String str) {
		str = "123";
		System.out.println("inside a() : " + str);
	}
}
