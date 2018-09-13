package userRegistrationController;

public class payload {
	
	public static String payloads()

	{
		String pl = "{\r\n" + 
				"  \"currentLocation\": \"Karachi\",\r\n" + 
				"  \"dateOfBirth\": \"20180614\",\r\n" + 
				"  \"deviceIdentifier\": \"DIP063\",\r\n" + 
				"  \"deviceModel\": \"DVM090\",\r\n" + 
				"  \"deviceToken\": \"DT9874\",\r\n" + 
				"  \"email\": \"new.ruthford21@dispostable.com\",\r\n" + 
				"  \"firstName\": \"new\",\r\n" + 
				"  \"lastName\": \"ruthford\",\r\n" + 
				"  \"license\": \"abc\",\r\n" + 
				"  \"manufacturer\": \"IOS\",\r\n" + 
				"  \"mobileNo\": \"208782147\",\r\n" + 
				"  \"osName\": \"IOS\",\r\n" + 
				"  \"osVersion\": \"10.0\",\r\n" + 
				"  \"password\": \"vimp\",\r\n" + 
				"  \"requestSource\": 1,\r\n" + 
				"  \"userName\": \"new.ruthford21@dispostable.com\"\r\n" + 
				"}"
				;
		return pl;
		
	};
	public static String putPayloads()
	{
		String putPl = "{\r\n" + 
				"  \"currentLocation\": \"Karachi\",\r\n" + 
				"  \"dateOfBirth\": \"20180512\",\r\n" + 
				"  \"email\": \"vimp.user@dispostable.com\",\r\n" + 
				"  \"firstName\": \"new\",\r\n" + 
				"  \"id\": 4,\r\n" + 
				"  \"lastName\": \"payload\",\r\n" + 
				"  \"mobileNo\": \"769752222\",\r\n" + 
				"  \"securityProfileId\": 3\r\n" + 
				"}";
		return putPl;
	};
 
}
