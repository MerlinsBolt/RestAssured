package stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
import resources.TestDataBuilder;

public class stepDefination extends resources.Utilities{
	RequestSpecification response;
	ResponseSpecification respospec;
	Response res;
	TestDataBuilder td= new TestDataBuilder();
	@Given("Addplace Payload")
	public void addplace_payload() throws IOException {
	response=given().spec(requestSpecification())
	.body(td.addplacePayload());
				
	}
	@When("user calls {string} with http POST request")
	public void user_calls_with_http_post_request(String string) {
respospec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		 res=response.when()
		.post("/maps/api/place/add/json").then().spec(respospec).extract().response();
	}
	
	@Then("the api call get hit with status code {int}")
	public void the_api_call_get_hit_with_status_code(Integer int1) {
	    Assert.assertEquals(res.getStatusCode(), 200);		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		String response1=res.asString();
		JsonPath js= new JsonPath(response1);
		
		Assert.assertEquals(js.get(key).toString(), value);		
				
	}


	
	
	
}
