package line.algo.recursion;

import java.util.Scanner;

/**
 * 直接循环来计算裴波那切数列
 * HDOJ
 * WA
 * @author line
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		do {
			int s = scanner.nextInt();

			long front1 = 2;
			long front2 = 1;
			if (s < 3) {
				System.out.println(s);
				continue;
			}
			for (int i = 3; i < s; i++) {
				long cur = front1 + front2;
				front2 = front1;
				front1 = cur;
			}
			System.out.println(front1 + front2);
		} while (--n > 0);
		scanner.close();
	}
}
