package get_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1- Postman, manual API testleri için kullandik,
    2- Otomasyon testleri icin de Rest Assured Library kullanacagiz.
    3- Otomasyon tetslerimizi yaaprken asagidaki adimlari izliyoruz;
        a- Gereksinimleri anlamak,
        b- Test Case yaziyoruz
            i- Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da
            kisiler hakim olmayabilir ama Gherkin ile yazilan testeri anlamak da zorluk cekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given : On kosullar,
            - When  : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then  : Istek yaptiktan sonra (request gonderdikten sonra) dogrulama
            - And   : Coklu islemlerde kullanacagiz.

        c- Test kodlarimiz yazmaya baslayacagiz

            i-  Set the URL,
            ii- Set the expected Data (beklenen datanin olusturulması, Post,Put,Patch)
            iii- Type code to request (talep gondermek icin kod yazimi)
            iv- Do Assertion (dogrulama yapmak)
     */
    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */
    @Test
    public void get01(){
        //i-  Set the URL,
        String url = "https://restful-booker.herokuapp.com/booking/101";

        //ii- Set the expected Data (beklenen datanin olusturulması, Post,Put,Patch)
        //Bizden post, put ya da patch istemedigi icin bu case de kullanmayacagiz

        //iii- Type code to request (talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();
        //iv- Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdıralım
        System.out.println("Status Code : " + response.getStatusCode());

        //Content type konsola yazdıralım
        System.out.println("Content Type : " + response.getContentType());

        //Status Line konsola yazdıralım
        System.out.println("Status Line : " + response.statusLine());

        //Header konsola yazdıralım
        System.out.println("Header: " + response.getHeader("Server"));

        //Headers konsola yazdıralım
        System.out.println("Headers : " + response.getHeaders());

        //Time konsola yazdıralım
        System.out.println("Time : " + response.getTime());

    }

}
