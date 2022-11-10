package test_data;

import java.util.HashMap;
import java.util.Map;

public class RegResinTestData {
    /*
    {
                "name": "morpheus",
                "job": "leader",
                "id": "496",
                "createdAt": "2022-10-04T15:18:56.372Z"
              }
     */
    public Map<String,Object> dataKeyMap(String name, String job){

        Map<String,Object> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("job", job);

        return dataKeyMap;

    }
}
