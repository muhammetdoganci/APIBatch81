package post_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Ignore;
import org.junit.Test;
import pojos.DuumyRestApiDataPojo;
import pojos.DuumyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Post06 extends DummyRestApiBaseUrl {
    /*
    Given
       URL: https://dummy.restapiexample.com/api/v1/create


                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/create
    And    {
            "employee_name": "Tom Hanks",
            "employee_salary": 111111,
            "employee_age": 23,
            "profile_image": "Perfect image",
            "id": 4891
          }
     When
        User sends POST request
     Then
        Status code is 200
     And
        Response body should be like the following
        {
            "status": "success",
            "data": {
                "employee_name": "Tom Hanks",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image",
                "id": 4891
            },
            "message": "Successfully! Record has been added."
        }
     */
    @Test
    public void post06(){
        //Set the url
        spec.pathParam("first","create");

        // Set the expected data
        DuumyRestApiDataPojo expectedData = new DuumyRestApiDataPojo("Tom Hanks",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);

        // Send the  Post Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        // Do Assertion
        DuumyRestApiResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DuumyRestApiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getEmployeename(),actualData.getData().getEmployeename());
        assertEquals(expectedData.getEmployeesalary(),actualData.getData().getEmployeesalary());
        assertEquals(expectedData.getEmployeeage(),actualData.getData().getEmployeeage());
        assertEquals(expectedData.getProfileimagee(),actualData.getData().getProfileimagee());


    }
}
