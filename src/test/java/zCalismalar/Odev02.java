package zCalismalar;

import base_url.ReqresBaseUrl;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.Map;

public class Odev02 extends ReqresBaseUrl {
    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/
    @Test
    public void odev02() {
        // set the url
        spec.pathParam("first","users");

        // set the epected data
        GoRestTestData goRestTestData = new GoRestTestData();
       // Map<String,Object> dataKeyMap = goRestTestData.dataKeyMap("morpheus","");


}


}
