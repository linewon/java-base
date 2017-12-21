package line.inheritance.simple;

public class Father implements Person {
	// Father个体的名字
	private String name;
	// 此处进通过构造函数来初始化姓名
	public Father(String name) {
		this.name = name;
	}
	// 实现Person接口的introduce方法
	public void introduce() {
		System.out.println("Father name is :  " + name);
	}
	// Father个体需要work()来养家
	public void work() {
		System.out.println(name + " works for family!");
	}
	// Java三大特性之：封装。其他个体不能随意修改别人的名字
	public String getName() {
		return name;
	}
	// Java三大特性之：多态。重写Object父类的toString()方法
	public String toString() {
		return "this is " + name;
	}
}
