package line.json.fastjson;

import java.util.HashMap;
import java.util.Map;

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
	public static Map<String, String> jsonToMap(JSONObject json) {
		
		Map<String, String> map = new HashMap<String, String>();

		
		
		return map;
		
	}
}
