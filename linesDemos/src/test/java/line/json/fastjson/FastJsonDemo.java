package line.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import line.entity.Student;

public class FastJsonDemo {
	public static void main(String[] args) {

		Student stu = new Student("line", 17, "110");
		
		// javaBean -> json string
		String jsonString = JSON.toJSONString(stu);
		System.out.println(jsonString);
		// jsonString -> javaBean
		Student stu1 = JSON.parseObject(jsonString, Student.class);
		System.out.println(JSON.toJSONString(stu1));
		
		
		// jsonString -> jsonObject by JSON.parseObject()
		JSONObject stuJson = JSON.parseObject(jsonString);
		System.out.println(stuJson);
		// jsonObject -> jsonString by .toJSONString()
		System.out.println(stuJson.toJSONString());
		
		
		// javaBean -> jsonObject by JSONObject.toJSON
		JSONObject stuJsonObject = (JSONObject)JSONObject.toJSON(stu);
		System.out.println(stuJsonObject.toJSONString());
		// jsonObject -> javaBean by .toJavaBean()
		Student stuFromJson = stuJsonObject.toJavaObject(Student.class);
		System.out.println(stuFromJson);
		
	}

}
