package News;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApiCallNews {
	public static void main(String [] args) {
		DefaultHttpClient httpClient=new DefaultHttpClient();
		
		HttpGet getRequest = new HttpGet("https://newsapi.org/v2/top-headlines?country=gr&apiKey=a1e64a0e859643e8ad486aff6a948c3f"); 
		
		/**getRequest.addHeader("accept","");**/
		
		try {
			HttpResponse response = httpClient.execute(getRequest);
			
			NewsDetails news=null;
			ObjectMapper mapper=new ObjectMapper();
			
			news=mapper.readValue(response.getEntity().getContent(), NewsDetails.class);
			System.out.println(news);
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
