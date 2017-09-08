package line.json.fastjson;


import java.util.List;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import line.entity.Student;

public class JSONObjcetDemo {

	/**
	 * jsonobject 和 javabean 互相转换
	 */
	public static void main(String[] args) {

		try {

			Student stu = new Student("line", 17, "110");
			
			JSONObject jsonObj1 = (JSONObject)JSON.toJSON(stu);
			System.out.println(jsonObj1.toJSONString());
			
			Student stuFromJson = jsonObj1.toJavaObject(Student.class);
			System.out.println(stuFromJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
