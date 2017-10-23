package line.servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 看来只能传图片或者英文文本，其中如果包含中文的话，
 * 文件名和文件内容里面都会有乱码。
 * 在outputStream里设置一下编码格式应该就可以了
 * 
 * String.getBytes() 的过程一定会去查对应的码表！
 */
public class FileDownloadDemo extends HttpServlet {
	private static final long serialVersionUID = 11111L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "C:\\Users\\line\\Desktop\\1.jpg";
		OutputStream os = response.getOutputStream();
		
		// 由于在后面设置了文件下载的servlet，这里的os.write也会写到文件里，导致文件（图片）打不开了。
		// 看看别人文件下载是怎么弄的。
		os.write(path.getBytes());
		
		fileDownload(response, path);
	}
	
	private void fileDownload(HttpServletResponse response, String path) {
		
		String fileName = path.substring(path.lastIndexOf("\\") + 1);
		
		response.setHeader("content-disposition", "attachment;filename="+fileName);
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("file not exist!");
			return;
		}
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			
			int len = -1;
			byte[] buffer = new byte[4096];
			OutputStream out = response.getOutputStream();
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
