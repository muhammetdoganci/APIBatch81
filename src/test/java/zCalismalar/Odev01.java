package zCalismalar;

import base_url.AutoBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Odev01 extends AutoBaseUrl {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/
    @Test
    public void odev01(){
        // Set the url
        spec.pathParams("first","api","second","brandsList");

        // Set the expected data

        // Send the request and get the response
        Response response = given().spec(spec).when().contentType(ContentType.JSON).get("/{first}/{second}");

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();

        // Do assertion

        response.then().statusCode(200).
                        contentType("text/html; charset=utf-8").
                        statusLine("HTTP/1.1 200 OK");

        List<String> hmMarka = jsonPath.getList("brands.findAll{it.brand=='H&M'}");
        System.out.println("hmMarka = " + hmMarka.size());

        List<String> poloMarka = jsonPath.getList("brands.findAll{it.brand=='Polo'}");
        System.out.println("hmMarka = " + poloMarka.size());


    }
}
