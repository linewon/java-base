package line.inheritance.simple;

public class Son extends Father implements Person{
	private String name;

	public Son(String name) {
		super("my son's name is " + name);
		this.name = name;
	}

	public void introduce() {
		System.out.println("Son name is :  " + name);
	}
	
	public void recite() {
		System.out.println(name + " is reciting!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "this is " + name;
	}
}
