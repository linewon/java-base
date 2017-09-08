package line.json.sfjson;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import line.entity.Student;

public class JsonDemo {
	public static void main(String[] args) {

		Student stu = new Student("line", 17, "110");
		
		// jsonobject
		JSONObject json = JSONObject.fromObject(stu);
		System.out.println(json.toString());
		
		Student stuFromJson = (Student) json.toBean(json, Student.class);
		System.out.println(JSONSerializer.toJSON(stuFromJson));
		
		
		// jsonarrayss
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(stu);
		stuFromJson.setName("y");
		stuFromJson.setAge(99);
		stuList.add(stuFromJson);
		JSONArray jsonArray = JSONArray.fromObject(stuList);
		System.out.println(jsonArray.toString());
		
		List<Student> stuListFromJson = JSONArray.toList(jsonArray, Student.class);
		System.out.println(stuListFromJson.toArray().toString());
	}

}
