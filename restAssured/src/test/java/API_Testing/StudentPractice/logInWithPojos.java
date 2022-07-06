package API_Testing.StudentPractice;

import Pojos.logInPojos;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class logInWithPojos {

    @Test
    public void logInWithPojosData(){
        logInPojos data = new logInPojos();
        data.setPassWord("Kitty@12345");
        data.setUserName("krowles2021@gmail.com");

        RestAssured.baseURI = "http://api.octoperf.com";
        String path = "/public/users/login";

        RestAssured.given()
                .queryParam("username", data.getUserName())
                .queryParam("password", data.getPassWord())
                .when()
                .post(path)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .log().all();

    }
}
