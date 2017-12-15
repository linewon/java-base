package line.servlet.cache;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CacheDemo
 * 
 * try cache
 */
public class CacheDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "abcdefg";
		response.setDateHeader("expires", System.currentTimeMillis() + 24*3600*1000);
		OutputStream os = response.getOutputStream();
		os.write(str.getBytes());
		
		System.out.println("******************* end of cache demo *******************");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
