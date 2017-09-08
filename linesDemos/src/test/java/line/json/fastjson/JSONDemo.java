package line.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import line.entity.Student;

public class JSONDemo {
	public static void main(String[] args) {

		Student stu = new Student("line", 17, "110");
		
		JSONObject stuJson = (JSONObject) JSON.toJSON(stu);
		System.out.println(stuJson.toJSONString());
		
		System.out.println();
		}
}
