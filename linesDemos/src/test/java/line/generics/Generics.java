package line.generics;

public class Generics<T> {

	private T obj;
	
	public Generics(T obj) {
		this.obj = obj;
	}
	
	public void setObjT(T t) {
		this.obj = t;
	}
	public T getObjT() {
		return obj;
	}
	
	public String objName() {
		return obj.getClass().getName();
	}
}
