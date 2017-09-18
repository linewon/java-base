package line.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileOp {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		scanner.close();
		System.out.println(path);
		
		System.out.println(readFile(path));
		System.out.println(inputFile(path));
	}

	@SuppressWarnings("finally")
	private static String readFile(String path) {
		System.out.println("by Reader -------------");
		String result = "FIEL DOESN'T EXIST!";
		try {
			File inputFile = new File(path);
			if (!inputFile.exists())
				return result;

			System.out.println("file length : " + inputFile.length());
			Reader fileReader = new FileReader(inputFile);
			char[] byteArray = new char[(int) inputFile.length()];

			int size = fileReader.read(byteArray);
			System.out.println("char[]  size : " + size);

			result = new String(byteArray);
			System.out.println("first result :\n" + result);

			fileReader.close();
			result = new String(result.getBytes(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}
	/**
	 * windows下 notepad 默认ansi字符集保存
	 * notepad++ 默认utf-8无BOM字符集保存
	 * 而编写的方法只制定了UTF-8无BOM字符集。。。
	 * 太局限了。
	 * @param path
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String inputFile(String path) {
		System.out.println("\n\nby InputStream -------------");
		String result = "FIEL DOESN'T EXIST!";
		try {
			File inputFile = new File(path);
			if (!inputFile.exists())
				return result;

			System.out.println("file length : " + inputFile.length());
			InputStream fileInputStream = new FileInputStream(inputFile);
			byte[] byteArray = new byte[(int) inputFile.length()];

			int size = fileInputStream.read(byteArray);
			System.out.println("byte[]  size : " + size);

			result = new String(byteArray, "UTF-8");
			System.out.println("first result :\n" + result);

			fileInputStream.close();
			result = new String(result.getBytes(), "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}
}
