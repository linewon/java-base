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
		stu.setAge(18);
		stu.setName("y");
		stuList.add(stu);
		// 由于list里存的是引用，对stu的set操作也会影响到list里的stu。
		System.out.println(stuList.toString());
		
		// list -> jsonArray
		JSONArray jsonArr1 = (JSONArray) JSON.toJSON(stuList);
		// jsonArray -> jsonString
		System.out.println(jsonArr1.toJSONString());
		// jsonString -> jsonArray
		JSONArray jsonArray = JSON.parseArray(jsonArr1.toJSONString()); 
		// jsonArrray -> list
		List<Student> listFromJson = jsonArray.toJavaList(Student.class);
		System.out.println(listFromJson);
	}

}
