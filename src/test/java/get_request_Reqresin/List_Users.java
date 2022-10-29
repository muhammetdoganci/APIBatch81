package get_request_Reqresin;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

public class List_Users extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users?page=2
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
        {
    "page": 2,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
        },
        {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
        {
            "id": 9,
            "email": "tobias.funke@reqres.in",
            "first_name": "Tobias",
            "last_name": "Funke",
            "avatar": "https://reqres.in/img/faces/9-image.jpg"
        },
        {
            "id": 10,
            "email": "byron.fields@reqres.in",
            "first_name": "Byron",
            "last_name": "Fields",
            "avatar": "https://reqres.in/img/faces/10-image.jpg"
        },
        {
            "id": 11,
            "email": "george.edwards@reqres.in",
            "first_name": "George",
            "last_name": "Edwards",
            "avatar": "https://reqres.in/img/faces/11-image.jpg"
        },
        {
            "id": 12,
            "email": "rachel.howell@reqres.in",
            "first_name": "Rachel",
            "last_name": "Howell",
            "avatar": "https://reqres.in/img/faces/12-image.jpg"
        }
    ],
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
     */

    @Test
    public void get01(){
        // 1. Set The Url
        spec.pathParams("first","api","second","users?page=2");

        // 2. Set The expected Data (put,post,patch)

        // (When) 3. Send The request And get The Response (talep gonder ve cevap al)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Do Assertion
        response.then().assertThat().statusCode(404).
                contentType(ContentType.JSON).
                body("page",equalTo(1),
                        "per_page",equalTo(6),
                        "total",equalTo(12),
                        "total_pages",equalTo(2),
                        "support.url",equalTo("https://reqres.in/#support-heading"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        JsonPath json = response.jsonPath();

        List<Integer> idler = json.getList("data.findAll{it.id}.id");
        List<String> emailler = json.getList("data.findAll{it.email}.email");
        List<String> firstNameler = json.getList("data.findAll{it.first_name}");
        List<String> lastNameler = json.getList("data.findAll{it.last_name}");
        List<String> avatarlar = json.getList("data.findAll{it.avatar}");

        System.out.println("idler : " + idler +"\n"+"emailler : "+ emailler +"\n"+"firstNameler : "+firstNameler +"\n"+
                            "lastNameler : " + lastNameler +"\n"+ "avatarlar : " + avatarlar);










    }




}
