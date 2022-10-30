package zCalismalar;

import base_url.AutoBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class Ornek03 extends AutoBaseUrl {
    /*
 Given
     https://automationexercise.com/api/productsList
 When
     User sends a GET Request to the url
 Then
     HTTP Status Code should be 200
 And
     Content Type should be "text/html; charset=utf-8"
 And
     Status Line should be HTTP/1.1 200 OK
 And
      There must be 12 Women, 9 Men, 13 Kids usertype in products
   */

    @Test
    public void ornek03(){

        //Set the Url
        spec.pathParams("first","api","second","productsList");
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //Set The Expected Data
        //Send The Request and Get The Response

        JsonPath jsonPath = response.jsonPath();
        //jsonPath.prettyPrint();

        List<String> women = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> men = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> kids = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");

        // do asserton
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.contentType(),"text/html; charset=utf-8");
        softAssert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
        softAssert.assertEquals(women.size(),12);
        softAssert.assertEquals(men.size(),9);
        softAssert.assertEquals(kids.size(),13);

        softAssert.assertAll();



    }
}
