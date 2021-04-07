package model;

public class weatherBean {
	
	private String cityStr;
	private String countryStr;
	private String cloudsStr;
	private String speedStr;

	public weatherBean(String cityStr, String countryStr) {
		this.cityStr=cityStr;
		this.countryStr=countryStr;
		
	}

	
	public String getCityStr() { 
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}
	
	public String getcloudsStr() {
		return cloudsStr;
	}
	
	public String getspeedStr() {
		return speedStr;
	}


	public void setCloudsStr(String xMLClouds) {
		this.cloudsStr=xMLClouds;
		
	}
	
	public void setSpeedStr(String xMLSpeed) {
		this.speedStr=xMLSpeed;
		
	}
	
	

	
	
	

}
