package RestAssured_BasicApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC006_POST_Add_Customer 
{
  
	@SuppressWarnings("unchecked")
	@Test
	void add_customer()
    {
    	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
    	RequestSpecification httprequest=RestAssured.given();
    	
    	JSONObject jsonobject=new JSONObject();
    	
    	jsonobject.put("name","VAALHA1");
    	jsonobject.put("salary","45210");
    	jsonobject.put("age","34");
    	
    	
    	httprequest.header("Content-type","application/json");
    	
    	httprequest.body(jsonobject.toJSONString());
    	
    	Response response=httprequest.request(Method.POST,"/create");
    	
    	String resbody=response.getBody().asString();
    	System.out.println("Response body is :"+resbody);
    	Assert.assertEquals(resbody.contains("VAALHA"), true);
    	
        Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    	
    	
    }
	
}
