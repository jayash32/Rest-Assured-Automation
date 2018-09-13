package userRegistrationController;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.reporters.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETUser {
	@Test
	public void GetTest() {
				
		RestAssured.baseURI = "http://54.89.141.97:8080/vimp-services/v1/api/users";
		RequestSpecification httpRequest = RestAssured.given()
		.header("language","en_US")
		.header("os_name","IOS")
		.header("os_version","10.0")
		.header("app_version","1.0")
		.header("app_key","632C94CE-ACCF-4312-99FD-473C5642182F-1517468570921")
		.header("app_secret","8010DDE7-0D73-43C8-B3DB-338CBE425A87-1517468570921")
		.header("access_token","qS6d3f808f3f-ff3a-4e30-828c-5b183e74b6841525339127526pUYz") //correct token
		//.header("access_token","qz45110cac66-c392-4a7a-b984-585e2a03286a1524052755686yI2E") //wrong token
		.header("version","v1")
		;


		Response response = httpRequest.request(Method.GET, "/current");


		String responseBody = response.getBody().asString();
		System.out.println("Response Body is => " + responseBody);
	
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	
		System.out.println("Response Code is => " + statusCode);
		}


}
