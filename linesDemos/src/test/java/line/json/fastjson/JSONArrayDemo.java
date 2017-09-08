package line.json.fastjson;

import java.util.ArrayList;
import java.util.List;

import line.entity.Student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class JSONArrayDemo {
	public static void main(String[] args) {
		
		Student stu = new Student("line", 17, "110");
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(stu);
		
		JSONArray jsonArr1 = (JSONArray) JSON.toJSON(stuList);
		System.out.println(jsonArr1.toJSONString());
		
		List<Student> listFromJson = jsonArr1.toJavaList(Student.class);
		System.out.println(listFromJson);
	}

}
