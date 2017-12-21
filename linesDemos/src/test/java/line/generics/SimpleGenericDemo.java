package line.generics;

import java.util.ArrayList;
import java.util.List;

public class SimpleGenericDemo {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test1() {
		List list = new ArrayList();
		list.add("XXX");
		list.add(100);
		
		String str = (String)list.get(0);
		System.out.println(str);
		
		
		Integer i = (Integer)list.get(1);
		System.out.println(i);
		
		String s = (String)list.get(1);
		System.out.println(s);
	}
	
	public static void test2() {
		List<String> list = new ArrayList<>();
		list.add("QQQ");
//		list.add(100); // 编译不通过
		String str = list.get(0);
		System.out.println(str); // 打印 QQQ
//		List<Integer> list2 = list;
	}
}
