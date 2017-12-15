package line.inheritance.simple;

public class Father implements Person {

	private String name;

	public Father(String name) {
		this.name = name;
	}

	public void introduce() {
		System.out.println("Father name is :  " + name);
	}
	
	public void farm() {
		System.out.println(name + " can farm!");
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
