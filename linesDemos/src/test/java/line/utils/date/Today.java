package line.utils.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Today {
	public static void main(String[] args) {
		Date today = new Date();
		today.setDate(31);
		System.out.println(today.toString());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(today));
		today.setMonth(today.getMonth()+1);
		System.out.println(df.format(today));
		
		
		// 60天前
		System.out.println("--------------------------------------------------");
		today = new Date();
		today.setDate(today.getDate() - 60);
		System.out.println(df.format(today));
		System.out.println("details:\n");
		today = new Date();
		for (int i = 0; i < 60; i++) {
			today.setDate(today.getDate() - 1);
			System.out.println(df.format(today));
		}
	}

}
