package line.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	}

	private static String readFile(String path) {
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

			fileReader.close();
			result = new String(byteArray);
			System.out.println("first result : " + result);
			
			result = new String(result.getBytes(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}

	}
}
