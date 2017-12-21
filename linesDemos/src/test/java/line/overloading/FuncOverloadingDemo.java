package line.overloading;

/**
 * The method func(String) is ambiguous for the type FuncOverloadingDemo
 * @author line
 *
 */
public class FuncOverloadingDemo {
	
	public static void main(String[] args) {
		func(null);
	}

	public static void func(String a) {
		System.out.println("String");
	}
	
//	public static void func(Integer a) {
//		System.out.println("Integer");
//	}
}
