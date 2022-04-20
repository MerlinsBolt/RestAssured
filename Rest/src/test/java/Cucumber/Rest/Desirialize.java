package Cucumber.Rest;

import io.restassured.path.json.JsonPath;
import pojo.Courses;
import pojo.GetCourse;
import pojo.api;
import pojo.webAutomation;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.parsing.Parser;

public class Desirialize {
	
	public static void main (String args[]) {

		
		String code = "4%2F0AX4XfWh4J_uIrJnltBQ6A-eY8_rKA7IfFwzwbVwolLr4Hq-mv8CClk76PtKq3IznYxXD4A";
	    
		// code keeps on changing and can be generated everytime using 
		 //https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
			String accessTokenResponse = given()
					.urlEncodingEnabled(false)
					.queryParams("code", code)
				.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type","authorization_code")
				.when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token")
				.asString();
			
			System.out.println(accessTokenResponse);
			JsonPath jp = new JsonPath(accessTokenResponse);
			String access_token = jp.getString("access_token");
			
			System.out.println(access_token);
				
				
				GetCourse response = given().queryParam("access_token", access_token)
				.expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				
				System.out.println(response.getLinkedIn());
				
		
		List<api> apinodeList=response.getCourses().getApiautomtion();
		for(int i=0; i<apinodeList.size();i++) {
			if(apinodeList.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				String courseprice=apinodeList.get(i).getPrice();
				System.out.println(apinodeList.get(i).getCourseTitle()+" has price of "+courseprice);		
			}
		}
		
		
		//getting the course title of webautomation project
		List<webAutomation> webnode=response.getCourses().getWebautomation();
		
		for(int i=0;i<webnode.size();i++) {
			String eachnode=webnode.get(i).getCourseTitle();
			System.out.println(eachnode);
		}
		
		
		
		
		
		
		
//		
	}
	

	

}
