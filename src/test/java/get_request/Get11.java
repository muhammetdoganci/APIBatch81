package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Pres. Amarnath Dhawan", "Sujata Chaturvedi" and "Navin Panicker"
    And
        The female users are less than or equals to male users
 */
    @Test
    public void get11(){
        // 1.set the url
        spec.pathParam("first", "users");

        // 2. set the epected data (put, post, patch)

        // 3. set the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        // 4. do asseertion

       response.then().
               assertThat().
               statusCode(200).
               body("meta.pagination.limit", equalTo(10),
                       "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                       "data", hasSize(10),
                       "data.status", hasItem("active"),
                       "data.name", hasItems("Pres. Amarnath Dhawan", "Sujata Chaturvedi", "Navin Panicker"));

       // kadın ve erkek sayılarını karşılastıralım.
       // 1. yol:
       List<String> genders = response.jsonPath().getList("data.gender");
        System.out.println("genders = " + genders);

        int kadınSayısı = 0;
        for (String w:genders) {
            if (w.equalsIgnoreCase("female")) {
                kadınSayısı++;
            }
        }
        assertTrue(kadınSayısı<=genders.size()-kadınSayısı);

        // 2. yol kadın ve erkek sayılarını Groovy ile bulalım
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("femaleNames = " + femaleNames);

        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("maleNames = " + maleNames);

        assertTrue(femaleNames.size()<=maleNames.size());

    }


}
