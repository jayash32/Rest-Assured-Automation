package userRegistrationController;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import userRegistrationController.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PATCHlicense {
	Properties prop = new Properties();
	 
	 @BeforeTest
	 public void getdata() throws IOException	 
	 {	 
	  FileInputStream file=new FileInputStream("C:\\Users\\VenD\\eclipse-workspace\\AutomationAPI\\src\\userRegistrationController\\env.prop");
	     prop.load(file);	     
	 }
	
	@Test
	public void PatchTest()
	{
		
		RestAssured.baseURI=prop.getProperty("HOST");  
		System.out.println(RestAssured.baseURI);
		Response res = given().
				  header("access_token","qS6d3f808f3f-ff3a-4e30-828c-5b183e74b6841525339127526pUYz"). 
				  header("userId",prop.getProperty("userId")). 
				  header("license","patch").
				  contentType(ContentType.JSON).
				  when().
				  patch(resources.patch()). 
				  then().assertThat().statusCode(200). 
				  and()
				  .body("success",equalTo(true))
				  .body("message",equalTo("User License Added"))
				  .extract().response();
				
		String responsestring = res.asString();
		 System.out.print(responsestring);
		 System.out.print("\n");
	
	}

}
