package zCalismalar;

import base_url.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Tekrar06Jsonpath extends GoRestBaseUrl {
    /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like
    {
    "meta": null,
    "data": {
        "name": "Prof. Bala Pilla",
        "email": "pilla_prof_bala@zemlak.io",
        "gender": "female",
        "status": "active"
    }
}
*/
    @Test
    public void test06JP(){
        //Set the Url
        spec.pathParams("first","users", "second", 2986);

        //Set The Expected Data

        //Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();

        softAssert.assertEquals(jsonPath.getString("meta"), null);
        softAssert.assertEquals(jsonPath.getString("data.name"),"Prof. Bala Pilla" );
        softAssert.assertEquals(jsonPath.getString("data.email"),"pilla_prof_bala@zemlak.io" );
        softAssert.assertEquals(jsonPath.getString("data.gender"),"female" );
        softAssert.assertEquals(jsonPath.getString("data.status"),"active" );

        softAssert.assertEquals(response.statusCode(),200);

        softAssert.assertAll();

    }


}
