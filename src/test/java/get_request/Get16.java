package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */
    /*
    Given
    URL: https://dummy.restapiexample.com/api/v1/employees

    When
    User sends get request

    Then
         i) Status code is 200
    And
         ii) There are 24 employees
    And
         iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
         iv) The greatest age is 66
    And
          v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
         vi) Total salary of all employees is 6,644,770

     */
    @Test
    public void get16(){
        spec.pathParam("first","employees");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        response.then().assertThat().body("data", hasSize(24),
                            "data.employee_name", Matchers.hasItems("Tiger Nixon","Garrett Winters"));

        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("sorted Ages = " + ages);
        System.out.println(ages.get(ages.size()-1));
        assertEquals(66,(int)ages.get(ages.size()-1));

        //v) The name of the lowest age is "Tatyana Fitzpatrick"// en küçük yaş
        String lowestAgeEmployee = response.jsonPath().getString("data.findAll{it.employee_age == "+ages.get(0)+"}.employee_name");
        System.out.println("lowestAgeEmployee = " + lowestAgeEmployee);

        assertEquals("[Tatyana Fitzpatrick]",lowestAgeEmployee);

        //vi) Total salary of all employees is 6,644,770
        List<Integer> salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //1. yol
        int sum = 0;
        for (int w:salaries) {
            sum +=w;
        }
        System.out.println("sum = " + sum);

        assertEquals(6644770,sum);

        //2. yol

        int sum2 = salaries.stream().reduce(0,Integer::sum);
        System.out.println("sum2 = " + sum2);

        // 3. yol
        int sum3 = salaries.stream().reduce(0, Math::addExact);
        System.out.println("sum3 = " + sum3);
        assertEquals(6644770, sum3);

    }
}
