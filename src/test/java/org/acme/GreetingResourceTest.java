package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testCache() {
        given()
          .when().get("/test-cache/method1")
          .then()
             .statusCode(200)
             .body(is("1"));
        given()
                .when().get("/test-cache/method1")
                .then()
                .statusCode(200)
                .body(is("1"));
        given()
                .when().get("/test-cache/method2")
                .then()
                .statusCode(200)
                .body(is("1"));
        given()
                .when().get("/test-cache/method2")
                .then()
                .statusCode(200)
                .body(is("1"));
        given()
                .when().delete("/test-cache")
                .then()
                .statusCode(204);
        given()
                .when().get("/test-cache/method1")
                .then()
                .statusCode(200)
                .body(is("2"));
        given()
                .when().get("/test-cache/method2")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

}