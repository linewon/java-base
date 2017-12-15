package line.generics;

/**
 * 接口方法的注释直接参照接口
 */
public class MyLinkedList<E> implements MyList<E> {
	
	// 内部类的作用域应该如何定义？
	private class Node<E> {
		public E item; // 内部类成员变量的作用域该如何定义？
		public Node<E> next;
//		public Node<E> pre;
		
		public Node(E e) { // 内部类构造函数的作用域应该如何定义？
			item = e; // next会自动赋为null
		}
	}
	
	// 头指针
	private Node<E> head;
	// 尾指针
	private Node<E> rear;
	// 列表大小
	private int size;
	
	/**
	 * 获取链表的第一个元素
	 */
	public E head() {
		if (size == 0)
			return null;
		return head.item; // 带有头结点，所以是head.next
	}

	@Override
	public void insert(E e) {
		Node<E> node = new Node<>(e);
		if (head == null) { // 链表为空的时候
			head = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}

	@Override
	public E get(int index) {
		if (size <= index) { // 判断下标是否超过链表长度(链表的下标从0开始)
			return null;
		}
		Node<E> cur = head;
		for (int i = 0; i < index; i++) { // 因为链表下标从0开始，所以这里用<而不是<=
			cur = cur.next;
		}
		return cur.item;
	}

	@Override
	public void insert(int index, E e) {
		
	}

	@Override
	public void delete(int index) {
		
	}

	@Override
	public void update(int index, E e) {
		
	}

	@Override
	public int indexOf(E e) {
		return 0;
	}
	
	@Override
	public boolean contain(E e) {
		return indexOf(e) != -1;
	}
}
