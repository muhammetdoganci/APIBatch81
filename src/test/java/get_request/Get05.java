package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class Get05 extends JsonplaceholderBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
   Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
 */
    @Test
    public void get01(){
        //https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        // 1. Set The Url
        spec.pathParam("first","booking").queryParams("firstname","Guoqiang","lastname","Sevilla");

        // 2. Set The expected Data

        // 3. Send The request And get The Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        assertEquals(404,response.getStatusCode());
        assertFalse(response.asString().contains("bookingid"));
    }


}
