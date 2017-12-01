package line.algo.recursion;

import java.util.Scanner;

/**
 * 裴波那切数列，用循环模拟递归，同时采用空间换时间的方法。
 * 
 * 输入有待改进，嘿嘿
 * @author line
 *
 */
public class Steps {

	private static Integer[] tmp = null;
	private static int save = -1;
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		int n = 0;
		do {
			n = scan.nextInt();
			if (n < 0)
				throw new Exception("input cannot less than 0");
			save = n / 2 + 1;
			init2();
			System.out.println(steps(n));
			tmp = null;
		} while (n != 9999);
		scan.close();
	}
	
	public static void init(Integer[] integers, int len) {
		integers = new Integer[len];
		while (--len > 0)
			integers[len] = new Integer(-1);
	}
	
	public static void init2() {
		tmp = new Integer[save];
		for (int i = 0; i < save; i++)
			tmp[i] = new Integer(-1);
	}
	
	public static int steps(int s) {
		
		if (s < 0 || save < 0)
			throw new IllegalArgumentException("step or save cannot less than 0!");
		if (s <= 2)
			return s;
		if (s < save) {
			if (tmp[s - 1] < 0)
				tmp[s - 1] = steps(s - 1);
			if (tmp[s - 2] < 0)
				tmp[s - 2] = steps(s - 2);
			
			return tmp[s - 1] + tmp[s - 2];
		}
		return steps(s - 2) + steps(s - 1);
	}
}
