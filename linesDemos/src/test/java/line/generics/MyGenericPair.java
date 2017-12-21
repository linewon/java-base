package line.generics;

import lombok.Getter;
import lombok.Setter;

public class MyGenericPair<K, V> {

	@Getter
	@Setter
	private K key;
	
	@Getter
	@Setter
	private V val;
	
	public void printPair() {
		System.out.println("--------- info of key ---------");
		System.out.println("class info ： " + key.getClass().getName());
		System.out.println("key value ： " + key.toString());
		System.out.println("--------- info of val ---------");
		System.out.println("class info ： " + val.getClass().getName());
		System.out.println("val value ： " + val.toString());
		System.out.println();
	}
}
