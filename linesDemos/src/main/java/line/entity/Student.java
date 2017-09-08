package line.entity;

public class Student {

	private String name;
	private int age;
	private String telNum;
	
	
	public Student() {
		
	}
	public Student(String name, int age, String telNum) {
		this.name = name;
		this.age = age;
		this.telNum = telNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", telNum=" + telNum
				+ "]";
	}
}
