package get_request;

import base_url.RestfulBaseUrl;
import groovy.transform.stc.POJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingdatesPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Get12Pojo extends RestfulBaseUrl {
    /*
     Given
         https://restful-booker.herokuapp.com/booking/19
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
     {
    "firstname": "Guoqiang",
    "lastname": "Liu",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
  */
    @Test
    public void get01Pojo(){
        //set the url
        spec.pathParams("first", "booking", "second", 19);

        //set the expected data
        BookingdatesPojo bookingdatesPojo = new BookingdatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Guoqiang","Liu",111,true,bookingdatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        // 1. yol
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        // 2. yol ==> tavsiye edilen
        assertEquals(bookingdatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingdatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());


    }

}
