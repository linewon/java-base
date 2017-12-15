package line.inheritance.simple;

public class Main {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	public static void test1() {
		System.out.println("*****************TEST1*****************");
		Father f = new Father("Tom");
		Son s = new Son("Jim");
		
		f.introduce();
		s.introduce();
		
		((Father)s).introduce();
//		((Son)f).introduce(); // Father cannot be cast to Son
		
		s.recite();
		s.farm();
	}
	
	public static void test2() {
		System.out.println("*****************TEST2*****************");
		Person f = new Father("Tom");
		Person s = new Son("Jim");

		System.out.println("Person f's class name :");
		System.out.println(f.getClass().getName());
		System.out.println("Person s's class name :");
		System.out.println(s.getClass().getName());
		
		f.introduce();
		s.introduce();
		
//		f.farm(); // The method farm() is undefined for the type Person
//		s.recite();
//		s.farm();
		
		((Father)f).farm();
		((Son)s).recite();
		((Son)s).farm();
	}
	
	/**
	 * 
	 */
	public static void test3() {
		System.out.println("*****************TEST3*****************");
		Father f = new Father("Tom");
//		Son s = (Son)new Father("???"); // Father cannot be cast to Son
		Father s = new Son("Jim");
		
		System.out.println("Father son's class name :");
		System.out.println(s.getClass().getName());
		
		f.introduce();
		s.introduce();
		
		f.farm();
		s.farm();
		
		Son realSon = (Son)s;
		realSon.recite();
	}
}
