package userRegistrationController;

public class resources {
	
	public static String res()
	{
		String pathPost = "/public/api/users/registration";
		return pathPost;
	};

	public static String patch()
	{
		String patchLicense = "/v1/api/users/current/license";
		return patchLicense;
	};
	
	public static String put()
	{
		String putUser = "/v1/api/users/current";
		return putUser;
	};
	
	public static String autPut()
	{
		String autPutUser = "/public/api/users/login";
		return autPutUser;
	};
	
	public static String getUser() 
	{
		String fetchUser = "/v1/api/users/current";
		return fetchUser;
	}
}
