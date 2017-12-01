package line.http.client.demo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientDemo {

	/**
	 * http client demo
	 * 
	 * author: linewon
	 */
	public static void main(String[] args) {

		HttpClientDemo demo = new HttpClientDemo();
		String result = demo.httpGet("http://localhost:8080/holy-spring/jsonParser/xmlString");
		System.out.println(result);
	}
	
	public String httpGet(String url){
		
		String resultStr = null;
		//1.获得一个httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//2.生成一个get请求
		HttpGet httpget = new HttpGet(url);
		//3.执行get请求并返回结果
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		    //4.处理结果
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				resultStr = EntityUtils.toString(entity);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
		    try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return resultStr;
    }

}
