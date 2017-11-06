package line.utils.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(c.getTime().toString());
		c.add(Calendar.DAY_OF_MONTH, -60);
		String date1 = df.format(c.getTime());
		System.out.println(date1);
		
		c.add(Calendar.MONTH, 5);
		String date2 = df.format(c.getTime());
		System.out.println(date1);
		System.out.println(date2);
	}
}
