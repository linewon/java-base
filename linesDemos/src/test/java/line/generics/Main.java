package line.generics;

import line.inheritance.simple.Father;
import line.inheritance.simple.Person;
import line.inheritance.simple.Son;

public class Main {

	public static void main(String[] args) {
		// GenericsTest();
		// GenericsPairTest();
//		listGenericsPairTest();
		myListTest();
	}

	public static void genericsTest() {

		MyGeneric<Son> son = new MyGeneric<>(new Son("Jim"));
		System.out.println(son.getTName());

		MyGeneric<Father> father = new MyGeneric<Father>((Father) son.getObjT());
		System.out.println(father.getTName());

		MyGeneric<Father> father2 = new MyGeneric<Father>(new Father("Tom"));
		System.out.println(father2.getTName());
	}

	public static void genericsPairTest() {

		MyGenericPair<String, Person> pair = new MyGenericPair<>();
		Person son = new Son("Jim");
		pair.setKey(((Son) son).getName());
		pair.setVal(son);
		pair.printPair();

		Person father = new Father("Tom");
		pair.setKey(((Father) father).getName());
		pair.setVal(father);
		pair.printPair();
	}
	
	public static void myListTest() {
		MyList list = new MyLinkedList<>();
		list.insert("XXX");
		list.insert(100);
		
		String string = (String)list.get(0);
		System.out.println(string);
		
		Integer i = (Integer)list.get(1);
		System.out.println(i);
	}

	public static void listGenericsPairTest() {
		MyList<MyGenericPair<String, Integer>> pairLsit = new MyLinkedList<>();

		for (int i = 0; i < 10; i++) {
			MyGenericPair<String, Integer> pair = new MyGenericPair<>();
			pair.setKey(String.valueOf(i));
			pair.setVal(new Integer(i));

			pairLsit.insert(pair);
		}

		for (int i = 0; i < 10; i++) {
			MyGenericPair<String, Integer> pair = pairLsit.get(i);
			System.out.println(pair.getKey() + " : " + pair.getVal());
		}
	}
}
