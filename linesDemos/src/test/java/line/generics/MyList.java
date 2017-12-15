package line.generics;

public interface MyList<E> {
	/**
	 * 在尾部插入一个元素
	 */
	void insert(E e);
	/**
	 * 在指定index插入一个元素
	 */
	void insert(int index, E e);
	/**
	 * 删除指定的index元素
	 */
	void delete(int index);
	/**
	 * 更新指定的index元素
	 */
	void update(int index, E e);
	/**
	 * 获取指定的index元素
	 */
	E get(int index);
	/**
	 * 返回传入元素所在列表的下标，若不存在则返回-1
	 */
	int indexOf(E e);
	/**
	 * 判断列表中是否含有某个元素
	 */
	boolean contain(E e);
}
