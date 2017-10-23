package line.entity;

public class Teacher {
	private String name;
	private int age;
	private String telNum;
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher() {
		
	}
	
	public Teacher(String name, int age, String telNum, Student stu) {
		super();
		this.name = name;
		this.age = age;
		this.telNum = telNum;
		this.student = stu;
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
		return "Teacher [name=" + name + ", age=" + age + ", telNum=" + telNum
				+ ", student=" + student + "]";
	}

	
}
