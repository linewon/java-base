package line.claz;

import line.entity.Student;
import line.entity.Teacher;


/**
 * 两个变量，拥有相同的属性名称。
 * 在什么样的条件下可以相互转换？
 * 
 * spring.
 * 
 * @author line
 *
 */
public class ClassTest {
	public static void main(String[] args) {

		Student stu = new Student("line", 17, "110");
		
		System.out.println("student : " + stu);
		
		Object object = stu;
		try {

			Teacher tch = (Teacher) object;
			System.out.println("teacher : " + tch);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("there's no fucking way!");
		}
		

	}

}
