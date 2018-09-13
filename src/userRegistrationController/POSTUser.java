package userRegistrationController;
import org.testng.annotations.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

import userRegistrationController.payload;
import userRegistrationController.resources;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class POSTUser {
	
	
	Properties prop = new Properties();
	 
	 @BeforeTest
	 public void getdata() throws IOException	 
	 {	 
	  FileInputStream file=new FileInputStream("C:\\Users\\VenD\\eclipse-workspace\\AutomationAPI\\src\\userRegistrationController\\env.prop");
	     prop.load(file);	     
	 }

	
	@Test
	public void PostTest()
	{
		
		RestAssured.baseURI=prop.getProperty("HOST");  
		System.out.println(RestAssured.baseURI);
		Response res = given().
				  header("version","public").
				  header("language",prop.getProperty("language")). 
				  header("app_key",prop.getProperty("app_key")). 
				  header("app_secret",prop.getProperty("app_secret")). 
				  header("app_version",prop.getProperty("app_version")). 
				  header("os_version",prop.getProperty("os_version")). 
				  header("os_name",prop.getProperty("os_name")). 
				  contentType(ContentType.JSON).
				  body(payload.payloads()).
				  when().
				  post(resources.res()). 
				  then().assertThat().statusCode(201)
				  .and()
				  .contentType(ContentType.JSON)
				 .body("success",equalTo(true))
				  .body("message",equalTo("Operation Successful"))
				  .extract().response();
				
		String responsestring = res.asString();
		 System.out.print(responsestring);
		 System.out.print("\n");
}
}