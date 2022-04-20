package Cucumber.Rest;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddplacePOJO;
import pojo.Locations;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Serialize {
	
	
	
	public static void main(String args[]) {
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AddplacePOJO ad= new AddplacePOJO();
		Locations l= new Locations();
		l.setLat(20.6);
		l.setLng(30.6);
		ad.setAccuracy(50);
		ad.setAddress("Prasan Niwas");
		ad.setLanguage("English");
		ad.setLocation(l);
		ad.setName("Vijay Yadav");
		ad.setPhone_number("8689946239");
		ad.setWebsite("ww.gmail.om");
		List<String> list= new ArrayList<>();
		list.add("shoe park");
		list.add("shop");
		ad.setTypes(list);
		
		
		RequestSpecification requ= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		RequestSpecification response=given().spec(requ)
		.body(ad);
		
		ResponseSpecification respospec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		String res=response.when()
		.post("/maps/api/place/add/json")
		.then().spec(respospec).extract().asString();
		
		
		
		
		System.out.println(res);
		JsonPath js  = new JsonPath(res);
		
		
		
		
	}

}
