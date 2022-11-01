package zCalismalar;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.GoRestTekrar;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Tekrar06 extends GoRestBaseUrl {
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
        "name": "Navin Talwar",
        "email": "navin_talwar@mclaughlin.name",
        "gender": "male",
        "status": "inactive"
    }
}
*/
    @Test
    public void get10t(){
        //set the url
        spec.pathParams("first","users","second",2986);

        //set the expected data
        GoRestTekrar ojb2 = new GoRestTekrar();
        Map<String,String> tableBody = ojb2.tableDataBody("Navin Talwar","navin_talwar@mclaughlin.name","male","inactive");
        Map<String,Object> expectedDataTable = ojb2.expectedTable(null, tableBody);
        System.out.println("expectedDataTable = " + expectedDataTable);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // do assertion
        Map<String, Object> actualDataTable = response.as(HashMap.class);
        System.out.println("actualDataTable = " + actualDataTable);

        assertEquals(expectedDataTable.get("meta"), actualDataTable.get("meta"));
        assertEquals(expectedDataTable.get("name"),((Map)actualDataTable.get("data")).get("name"));
        assertEquals(expectedDataTable.get("email"),((Map)actualDataTable.get("data")).get("email"));
        assertEquals(expectedDataTable.get("gender"),((Map)actualDataTable.get("data")).get("gender"));
        assertEquals(expectedDataTable.get("status"),((Map)actualDataTable.get("data")).get("status"));


    }




}
