package API_Testing.StudentPractice;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class api_Activities {

    // Testing URI = https://fakerestapi.azurewebsites.net/api/v1/

    // Task 1: Using Rest Assured validate the status code for endpoint /Activities GET
    @Test
    public void verifyStatusCodeActivities(){
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .statusCode(200);
    }
    // Task 2: Using Rest Assured Validate Content-Type  is application/json; charset=utf-8; v=1.0
    // for endpoint /Activities
    @Test
    public void verifyActivitiesContentTypeOption2(){
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .assertThat().header("Content-Type", "application/json; charset=utf-8; v=1.0");
    }

    // Task 1: Using Rest Assured validate the status code for endpoint /Activities/12
    @Test
    public void verifyStatusCodeAuthors(){
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                .then()
                .statusCode(200);
    }
    // Task 2: Using Rest Assured Content-Type  is application/json; charset=utf-8; v=1.0
    // for endpoint /Activities/10
    @Test
    public void verifyContentTypeOption2Authors(){
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/10")
                .then()
                .statusCode(200);
    }
}
