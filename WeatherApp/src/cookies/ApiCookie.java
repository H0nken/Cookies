package cookies;



public class ApiCookie {
	
	public static String getApiCookie(String city, String clouds, String speed) {
		
		String fixClouds = clouds.replaceAll(" ", ":");
		String fixSpeed = speed.replaceAll(" ", ":");
		
		
		return city+"."+fixClouds+"."+fixSpeed;
		
	}
	
	public static String cleanCookie(String cookieStr) {
		
		String fixedCookie = cookieStr;
		
			String first = fixedCookie.replaceAll(";", " ");
			String second = first.replaceAll("\\.", ", ");
			return second+"\t";
	}

}
