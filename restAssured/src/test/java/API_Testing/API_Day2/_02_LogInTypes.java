package API_Testing.API_Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class _02_LogInTypes {
    /*
    Log in with Full URL with query params
    and verify status code and Content-type is equal to JSON
     */
    @Test
    public void testUsingQueryParms(){
        RestAssured.given()
                .when()
                .post("https://api.octoperf.com/public/users/login?password=Kitty@12345&username=krowles2021@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType(ContentType.JSON);
    }
    @Test
    public void LogInWithMap(){
        RestAssured.baseURI="https://api.octoperf.com";
        String path = "/public/users/login";
        // WRITE A MAP
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "krowles2021@gmail.com");
        map.put("password", "Kitty@12345");

        RestAssured.given()
                .queryParams(map)
                .when()
                .post(path)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .assertThat()
                .statusCode(200);
    }
    // Using query Param
    @Test
    public void LogInWithQueryParam(){
        RestAssured.baseURI="https://api.octoperf.com";
        String path = "/public/users/login";

        RestAssured.given()
                .queryParam("username","krowles2021@gmail.com")
                .queryParam("password","Kitty@12345")
                .when()
                .post(path)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .assertThat()
                .statusCode(200);
    }


}
