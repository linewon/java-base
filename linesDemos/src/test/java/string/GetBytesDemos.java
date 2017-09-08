package string;


/**
 * 测试中文字符串的str.length(), getBytes[].length,
 * getBytes["utf-8"].length, getBytes["GBK"].length.
 * @author line
 *
 */
public class GetBytesDemos {

	public static void main(String args[]) {
		
		try {
			
			String testString = "这是中文和abcd";
			System.out.println("str.length : " + testString.length());
			System.out.println(testString);
			
			byte[] nomal = testString.getBytes();
			System.out.println(".getBytes[].length : " + nomal.length);
			System.out.println(nomal);
			
			byte[] isoStr = testString.getBytes("ISO-8859-1");
			System.out.println(".getBytes[\"ISO-8859-1\"].length : " + isoStr.length);
			System.out.println(isoStr);
			
			byte[] utf8 = testString.getBytes("utf-8");
			System.out.println(".getBytes[\"UTF-8\"].length : " + utf8.length);
			System.out.println(utf8);
			
			byte[] gbkStr = testString.getBytes("gbk");
			System.out.println(".getBytes[\"GBK\"].length : " + gbkStr.length);
			System.out.println(gbkStr);
			
			String utfCoder = new String(utf8, "utf-8");
			System.out.println(utfCoder.length());
			System.out.println(utfCoder);
			
			String gbkCoder0 = new String(gbkStr, "gbk");
			System.out.println(gbkCoder0.length());
			System.out.println(gbkCoder0);
			
			String gbkCoder = new String(gbkStr, "utf-8");
			System.out.println(gbkCoder.length());
			System.out.println(gbkCoder);
			
			String isoCoder = new String(isoStr, "utf-8");
			System.out.println(isoCoder.length());
			System.out.println(isoCoder);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
