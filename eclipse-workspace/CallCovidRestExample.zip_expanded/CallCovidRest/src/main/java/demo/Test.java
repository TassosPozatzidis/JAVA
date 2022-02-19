package demo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.CovidCountry;
 

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demoGetRestAPI();
	}
	
	public static void demoGetRestAPI() {
		
		
		DefaultHttpClient httpClient=new DefaultHttpClient();
		
		try {
		HttpGet getRequest=new HttpGet("https://disease.sh/v3/covid-19/countries/Greece?yesterday=true&strict=true&allowNull=false");
		getRequest.addHeader("accept", "application/json");
		
		HttpResponse response=httpClient.execute(getRequest);
		
		CovidCountry c=null;
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		c=mapper.readValue(response.getEntity().getContent(), CovidCountry.class);
			System.out.println(c.toString());
		
		}
		catch(JsonMappingException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}

}
