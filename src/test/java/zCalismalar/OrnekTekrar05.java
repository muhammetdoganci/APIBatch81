package zCalismalar;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrnekTekrar05 extends ReqresBaseUrl {

    /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2

     */
    @Test
    public void test01(){
        //Given
        //https://reqres.in/api/unknown/
        //When
        //I send GET Request to the URL
        spec.pathParam("first","unknown");
        Response response = given().spec(spec).when().get("/{first}");

        //1)Status code is 200
        assertEquals(200,response.getStatusCode());

        //2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("data.pantone_value"));

        //3)Print all ids greater than 3 on the console
        List<Integer> idler = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("idler = " + idler);

        //Assert that there are 3 ids greater than 3
        assertEquals(3,idler.size());

        //4)Print all names whose ids are less than 3 on the console
        List<String> name = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("name = " + name);

        //Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,name.size());


    }

}
