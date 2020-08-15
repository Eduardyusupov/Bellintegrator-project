package ru.usupov.bellintegrator.three;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTests {
	
	@Test
	public void checkingAvatarsSameOrNot() {
		List<String> avatars;
		String firstAvatar;
		Response response = given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.extract()
		.response();
		JsonPath jsonResponse = response.jsonPath();
		avatars = jsonResponse.get("data.avatar");
		firstAvatar = avatars.get(0);
		Assertions.assertTrue(avatars.stream().allMatch(x-> x == firstAvatar), "Аватары разные");	
	}
	
	
	
	@Test
	public void sortByYears() {
		List<Integer> years;
		Response response = given()	
				.when()
				.get("http://reqres.in/api/unknown")
				.then()
				.statusCode(200)
				.extract()
				.response();
			    JsonPath jsonResponse = response.jsonPath();
			    years = jsonResponse.getList("data.year");
			    Assertions.assertTrue(sortedByYearsOrNot(years), "Отсортировано не по годам");
		
	}
	
	@Test
	public void successfulLogin() {
		String token;
		Map<String, String> user = new HashMap<>();
		user.put("email", "eve.holt@reqres.in");
		user.put( "password", "cityslicka");
		Response response = given()	
				.contentType("application/json")
				.body(user)
				.when()
				.post("https://reqres.in/api/login")
				.then()
				.statusCode(200)
				.log()
				.all()
				.extract()
				.response();
			    JsonPath jsonResponse = response.jsonPath();
			    token = jsonResponse.get("token");
			    Assertions.assertEquals(token, "QpwL5tke4Pnpja7X4");
			    
	}
	
	@Test
	public void unsuccessfulLogin() {
		String error;
		Map<String, String> user = new HashMap<>();
		user.put("email", "sydney@fife");
		Response response = given()	
				.contentType("application/json")
				.body(user)
				.when()
				.post("https://reqres.in/api/login")
				.then()
				.statusCode(400)
				.log()
				.all()
				.extract()
				.response();
			    JsonPath jsonResponse = response.jsonPath();
			    error = jsonResponse.getString("error");
			    Assertions.assertEquals(error, "Missing password");
			    
			    
	}
	
	
	
	private boolean sortedByYearsOrNot(List<Integer> years) {
		for(int i = 0; i < years.size() - 2; i++) {
			if(years.get(i) < years.get(i + 1)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
		
	}

}
