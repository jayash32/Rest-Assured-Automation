package userRegistrationController;
import org.testng.annotations.Test;

import userRegistrationController.resources;
import userRegistrationController.payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;


public class newExtraction {
	
	Properties prop = new Properties();
	 
	 @BeforeTest
	 public void getdata() throws IOException
	 
	 {
	  

	  FileInputStream file=new FileInputStream("C:\\Users\\VenD\\eclipse-workspace\\RestAssuredLearning\\src\\files\\env.prop");
	     prop.load(file);
	   
	     
	 }
	 
	 @Test
	 public void PutAndGet() 
	 {
		 RestAssured.baseURI=prop.getProperty("HOST");
		  System.out.println(RestAssured.baseURI);
		  Response res =given().
		  header("language",prop.getProperty("language")). 
		  header("app_key",prop.getProperty("app_key")). 
		  header("app_secret",prop.getProperty("app_secret")). 
		  header("app_version",prop.getProperty("app_version")). 
		  header("os_version",prop.getProperty("os_version")). 
		  header("os_name",prop.getProperty("os_name")). 
		  header("device_identifier","identify").
		  header("username","vimp.user@dispostable.com").
		  header("password","vimp").
		  //contentType(ContentType.JSON).
		 // body(payload.payloads()).
		  when().
		  put(resources.autPut()). 
		  then().assertThat().statusCode(200). 
		  extract().response();
		  
		  
		 String responsestring = res.asString();
		 System.out.print(responsestring);
		 JsonPath js=new JsonPath(responsestring);
		 String access_token =js.get("session.accessToken");
		 System.out.print("\nAccess Token: ");
		 System.out.print(access_token);
		 System.out.print("\n");

		 
		 given()
		 .header("access_token",access_token)
		 .header("version","v1")
		 .header("userId","current")

		 
		 .when().
			 get("/v1/api/users/current").
			 then().assertThat().statusCode(200)
			 .and()
			 .contentType(ContentType.JSON)
             .body("securityProfileId", equalTo(3))                       // correct securtityProfileId
             //.body("securityProfileId", equalTo(4))                     // wrong securtityProfileId -> browser output display

		     .body("email", equalTo("vimp.user@dispostable.com"));

		 

		 

		 } 
	 }


