package line.io.file;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class BufferInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	public static String readFile(String path) {
		String result = "FILE DOESN'T EXIST!";
		InputStream inStream = null;
		BufferedInputStream bffInStream = null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				bffInStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
