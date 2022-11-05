package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonplaceholderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId, String title, Boolean completed){

        Map<String,Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("userId", userId);
        expectedDataMap.put("title", title);
        expectedDataMap.put("completed", completed);

        return expectedDataMap;

    }

    public String expectedDataInString(int userId, String title, boolean completed){//dinamik expected data methodu
                                                                                //Json datayı String olarak return ediyor.
        String expectedData = "{\n" +
                "  \"userId\": "+userId+",\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"completed\": "+completed+"\n" +
                "  }";

        return expectedData;
    }

}
