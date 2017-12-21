package line.inheritance.simple;

public class Son extends Father implements Person{
	// Son个体的名字
	private String name;
	// Son的构造方法中，通过super()调用Father父类的构造方法
	public Son(String name) {
		super("my son's name is " + name);
		this.name = name;
	}
	// Son中实现Person接口的introduce方法
	public void introduce() {
		System.out.println("Son name is :  " + name);
	}
	// Son个体的使命是study()
	public void study() {
		System.out.println(name + " is studying!");
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "this is " + name;
	}
}
