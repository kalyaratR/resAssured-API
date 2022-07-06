package API_Testing.StudentPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class apiReadFromJsonBody {
    @Test
    public void readFromJson(){
        //TODO How can you read from a file using Java
        //Answer: File is reading from the Json Body
        File requestBody = new File("src/resources/requestBody.json");

        Response response = RestAssured.given()
                .headers("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }
    //TODO Task 1: Create a json file Authors -> Send a Post request
    // Validate Status code, content-type and all the fields from the request body
    @Test
    public void AuthorsPostTask1 (){
        File requestBody = new File("src/resources/requestBody.json");

        Response response = RestAssured.given()
                .headers("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

    }
    //TODO Task 2: Create a json file Books -> Send a Post request
    // Validate Status code, content-type and all the fields from the request body
    @Test
    public void BookPostTask2(){
        File requestBody = new File("src/resources/requestBody.json");

        Response response = RestAssured.given()
                .headers("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

}
