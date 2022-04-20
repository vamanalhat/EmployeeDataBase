package RestAssured_BasicApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.RestUtils;


public class TC002_POST_Add_Customer extends TestBase
{
    
	Response response;
	RequestSpecification httprequest;
	
	String empname=RestUtils.empName();
	String empSal=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	void add_customer()
    {
    	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
    	httprequest=RestAssured.given();
    	
    	JSONObject jsonobject=new JSONObject();
        jsonobject.put("name","empname");
    	jsonobject.put("salary","empSal");
    	jsonobject.put("age","empAge");
    	    	
    	httprequest.header("Content-type","application/json");    	
    	httprequest.body(jsonobject.toJSONString());    	
    	response=httprequest.request(Method.POST,"/create");  
    }
	
	@Test
	void getbody()
	{
    	String resbody=response.getBody().asString();
    	System.out.println("Response body is :"+resbody);
    	Assert.assertEquals(resbody.contains("Successfully! Record has been added."), true);    	
	}
	
	@Test
	void getstatuscode()
	{
    	int statuscode=response.getStatusCode();
    	System.out.println("Response body is :"+statuscode);
    	Assert.assertEquals(statuscode, 200);    	
	}
	
}
