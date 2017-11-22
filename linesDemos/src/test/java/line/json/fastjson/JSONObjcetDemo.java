package line.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import line.entity.Student;

public class JSONObjcetDemo {

	/**
	 * jsonobject 和 javabean 互相转换
	 */
	public static void main(String[] args) {

		try {

			Student stu = new Student("line", 17, "110");
			
			// javaBean -> jsonObject
			JSONObject jsonObj1 = (JSONObject)JSON.toJSON(stu);
			// jsonObject -> jsonString
			System.out.println(jsonObj1.toJSONString());
			// jsonString -> jsonObject
			JSONObject jsonObj = JSON.parseObject(jsonObj1.toJSONString());
			// jsonObject -> javaBean
			Student stuFromJson = jsonObj.toJavaObject(Student.class);
			System.out.println(stuFromJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
