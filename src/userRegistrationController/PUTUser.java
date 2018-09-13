package userRegistrationController;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PUTUser {
	Properties prop = new Properties();
	 
	 @BeforeTest
	 public void getdata() throws IOException	 
	 {	 
	  FileInputStream file=new FileInputStream("C:\\Users\\VenD\\eclipse-workspace\\AutomationAPI\\src\\userRegistrationController\\env.prop");
	     prop.load(file);	     
	 }
	
	@Test
	public void PutTest()
	{
		
		RestAssured.baseURI=prop.getProperty("HOST");  
		System.out.println(RestAssured.baseURI);
		Response res = given().
				  header("version",prop.getProperty("version")). 
				  header("access_token","qS6d3f808f3f-ff3a-4e30-828c-5b183e74b6841525339127526pUYz").
				  header("userId",prop.getProperty("userId")). 
				
				  contentType(ContentType.JSON).
				  body(payload.putPayloads()).
				  when().
				  put(resources.put()). 
				  then().assertThat().statusCode(200)
				  .and()
				 .body("email",equalTo("vimp.user@dispostable.com"))
				 .body("securityProfileId",equalTo(3))
				 .extract().response();
				
		String responsestring = res.asString();
		 System.out.print(responsestring);
		 System.out.print("\n");
	}

}
