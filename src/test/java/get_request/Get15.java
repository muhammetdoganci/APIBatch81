package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
           {
                    "firstname": "Guoqiang",
                    "lastname": "Morante Briones",
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
    public void get15(){
        // set the url
        spec.pathParams("first","booking","second",22);

        // set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        //BookingDatesPojo classindaki BookingDatesPojo Constructor methodundan bookingDatesPojo objesi olusturup inner map ic map yazdık
        BookingPojo expectedData = new BookingPojo("Guoqiang","Morante Briones",111,true,bookingDatesPojo,"Breakfast");
        //expected datamizi olusturmak icin BookingPojo classindaki BookingPojo Constructor ina parametreleri ekleyip bekledigimiz data bilgilerini yazdik

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // do assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);
/*
        // Soft Assertion yontemi ile
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Firsname uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastname uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Totalprice uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Depositpaid uyusmadi");
        softAssert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds(),"Additionalneeds uyusmadi");

        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),expectedData.getBookingdates().getCheckin(),"Checkin uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),expectedData.getBookingdates().getCheckout(),"Checkout uyusmadi");
        softAssert.assertAll();

 */

        // Hard Assertion yontemi ile
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());




    }

}
