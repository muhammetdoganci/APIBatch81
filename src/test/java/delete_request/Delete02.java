package delete_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeletePojo;
import utils.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {
    /*

     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"
       */
    /*
     Given
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     When
     HTTP Request Method: DELETE Request
     Then
         i) Status code is 200
         ii) "status" is "success"
         iii) "data" is "2"
         iv) "message" is "Successfully! Record has been deleted"
       */
    @Test
    public void delete2(){
        spec.pathParams("first","delete","second",2);
        DummyRestApiDeletePojo expectedData = new DummyRestApiDeletePojo("success","2","Successfully! Record has been deleted");
        Response response = given().spec(spec).delete("/{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        ObjectMapperUtils actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeletePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());


    }
}
