package line.generics;

public class MyGeneric<T> {

	private T obj;
	
	public MyGeneric(T obj) {
		this.obj = obj;
	}
	
	public void setObjT(T t) {
		this.obj = t;
	}
	public T getObjT() {
		return obj;
	}
	
	public String getTName() {
		return obj.getClass().getName();
	}
}
