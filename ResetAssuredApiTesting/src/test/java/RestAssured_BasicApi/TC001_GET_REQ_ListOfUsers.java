package RestAssured_BasicApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_GET_REQ_ListOfUsers 
{
	Response response; 
	@Test(priority=1)
	void getAllUserData()
	{
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification httprequest=RestAssured.given();
		
		response=httprequest.request(Method.GET,"/users?page=2");
	}
	
	@Test(priority=2)
	void getbody()
	{
		String bodytext=response.getBody().asString();
		System.out.println("Response Body text : "+bodytext);
		Assert.assertEquals(bodytext.contains("Michael"), true);
	}
	
	@Test(priority=3)
	void getstatuscode()
	{
		int statuscode=response.getStatusCode();
		System.out.println("Status code is : "+statuscode);
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test(priority=4)
	void getstatusline()
	{
		String statusline=response.getStatusLine();
		System.out.println("Status code is : "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	
	@Test(priority=5)
	void gettime()
	{
		long time=response.getTime();
		System.out.println("Response time is : "+time);
		if(time>5000)
		{
			System.out.println("Response delayed");
		}
		
		Assert.assertTrue(time<5000);
	}
	
	@Test(priority=6)
	void getContentType()
	{
		String contenttype=response.header("Content-Type");
		System.out.println("Status code is : "+contenttype);
		Assert.assertEquals(contenttype, "application/json; charset=utf-8");
	}
	
	@Test(priority=7)
	void getContentEncoding()
	{
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("Status code is : "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}

	@Test(priority=8)
	void getServer()
	{
		String server=response.header("Server");
		System.out.println("Status code is : "+server);
		Assert.assertEquals(server, "cloudflare");
	}

}
