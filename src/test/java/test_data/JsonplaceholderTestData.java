package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonplaceholderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId, String title, Boolean completed){

        Map<String,Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("userId",userId);
        expectedDataMap.put("title","title");
        expectedDataMap.put("completed",completed);

        return expectedDataMap;

    }


}
