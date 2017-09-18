package line.string.stringbuffer;


/**
 * javap -c ClazName
 * 
 * @author line
 *
 */
public class StringBufferDemo {
	
	public static void main(String[] args) {

		String str1 = "123";
		String str2 = "aaa";
		String str3 = "bbbbb";

		String str = str1 + str2 + str3;
		
		System.out.println(str);
		
		str1 += str2;
		str1 += str3;
		System.out.println(str1);
		
		StringBuffer sBuffer = new StringBuffer(str1);
		sBuffer.append(str2);
		sBuffer.append(str3);
		System.out.println(sBuffer);

	}

}
