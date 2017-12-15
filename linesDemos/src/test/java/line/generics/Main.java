package line.generics;

import line.inheritance.simple.Father;
import line.inheritance.simple.Person;
import line.inheritance.simple.Son;

public class Main {

	public static void main(String[] args) {
		// GenericsTest();
		// GenericsPairTest();
		ListGenericsPairTest();
	}

	public static void GenericsTest() {

		Generics<Son> son = new Generics<Son>(new Son("Jim"));
		System.out.println(son.objName());

		Generics<Father> father = new Generics<Father>((Father) son.getObjT());
		System.out.println(father.objName());

		Generics<Father> father2 = new Generics<Father>(new Father("Tom"));
		System.out.println(father2.objName());
	}

	public static void GenericsPairTest() {

		GenericsPair<String, Person> pair = new GenericsPair<>();
		Person son = new Son("Jim");
		pair.setKey(((Son) son).getName());
		pair.setVal(son);
		pair.printPair();

		Person father = new Father("Tom");
		pair.setKey(((Father) father).getName());
		pair.setVal(father);
		pair.printPair();
	}

	public static void ListGenericsPairTest() {
		MyList<GenericsPair<String, Integer>> pairLsit = new MyLinkedList<>();

		for (int i = 0; i < 10; i++) {
			GenericsPair<String, Integer> pair = new GenericsPair<>();
			pair.setKey(String.valueOf(i));
			pair.setVal(new Integer(i));

			pairLsit.insert(pair);
		}

		for (int i = 0; i < 10; i++) {
			GenericsPair<String, Integer> pair = pairLsit.get(i);
			System.out.println(pair.getKey() + " : " + pair.getVal());
		}
	}
}
