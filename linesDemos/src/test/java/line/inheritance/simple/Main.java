package line.inheritance.simple;

public class Main {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void test1() {
		System.out.println("*****************TEST1*****************");
		Father tom = new Father("Tom");
		Son jim = new Son("Jim");
		// 调用Person接口的introduce方法来介绍自己
		tom.introduce();
		jim.introduce();
		// 调用tom和jim各自的方法
		tom.work();
		jim.study();
		jim.work(); // Son类继承了Father类，因此Son对象jim也有work方法
	}

	public static void test2() {
		System.out.println("*****************TEST2*****************");
		// 通过Person接口引用Father类和Son类的具体实现
		Person tom = new Father("Tom");
		Person jim = new Son("Jim");
		// 分别打印tom和jim实现类的类名。具体细节之后的篇幅再解释
		System.out.println("Person tom's class name :");
		System.out.println(tom.getClass().getName());
		System.out.println("Person jim's class name :");
		System.out.println(jim.getClass().getName());

		tom.introduce();
		jim.introduce();
		// 由于Person接口中没有方法的声明，编译时报错method undefined
//		tom.farm(); 
//		jim.recite();
//		jim.farm();
		// tom的具体实现类是Father类，因此强制转换tom对象后可以调用work()
		((Father)tom).work();
		((Son)jim).study(); // jim同理
		((Son)jim).work();
	}

	public static void test3() {
		System.out.println("*****************TEST3*****************");
		// 父类不能强制转换成子类，运行时报异常 cannot be cast to
//		Son s = (Son)new Father("Tom");
		Father tom = new Father("Tom");
		Father jim = new Son("Jim");

		/* 和test2中一样，通过Father引用Son的对象来调用Son类特有的study方法
		 * 编译时会提示method undefined
		 */
//		jim.study();
		// 通过强制转换，将Son类向上转换
		((Son)jim).study();
		jim.work();
		// 将jim强制转换为Son类型后，
		((Son)jim).work();
		((Son)jim).introduce();
		jim.introduce();
		((Person)jim).introduce();
		// 同理，将tom对象通过Persson接口引用，也能够调用Person接口中声明了的方法
		((Person)tom).introduce();
		// 而将tom向下转换，通过Son来引用，虽然编译能够通过，但运行时会抛出异常 cannot be cast
		((Son)tom).work();
	}
}