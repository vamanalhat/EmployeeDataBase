package RestAssured_BasicApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_AddUserData 
{

	Response response;
	
	@SuppressWarnings("unchecked")
	@Test(priority=1)
	void userAdd()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject params=new JSONObject();
		params.put("name","rahulkul");
		params.put("job","QATEST");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(params.toJSONString());
		
		response=httpRequest.request(Method.POST,"");
		
	}
	
	
	@Test
	void getUserData() 
	{
		String userbody=response.getBody().asString();
		System.out.println("User Body is :"+userbody);
		Assert.assertEquals(userbody.contains("rahulkul"), true);
	}
	
	
	
	
}
