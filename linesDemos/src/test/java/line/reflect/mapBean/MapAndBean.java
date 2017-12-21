package line.reflect.mapBean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.impl.cookie.PublicSuffixDomainFilter;

import line.entity.reflect.ObjectBean;
import line.entity.reflect.StringsBean;

public class MapAndBean {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		StringsBean bean = new StringsBean("line", "18", "China");
		ObjectBean objBean = new ObjectBean("110", bean);

		Map<String, String> map = null;

		try {
			map = (Map<String, String>) parseMapToBean(bean);
//			map = (Map<String, String>) parseMapToBean(objBean);
		} catch (Exception e) {
			System.out.println("************** bean parse exception **************");
			e.printStackTrace();
		}

		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();

			System.out.println(key + " : " + val);
		}
	}

	public static Map<String, String> parseMapToBean(Object bean) throws Exception{
//		if (true)
//			throw new ClassCastException();
		Map<String, String> map = new HashMap<>();
		Field[] fields = bean.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			String key = f.getName();
			String val = (String)f.get(bean);
			map.put(key, val);
		}
		return map;
	}

}
