package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTekrar {
/*
    {
        "meta": null,
            "data": {
                "name": "Navin Talwar",
                "email": "navin_talwar@mclaughlin.name",
                "gender": email"male",
                "status": "inactive"
    }

 */

    public Map<String,String> tableDataBody(String name, String email, String gender, String status){
        Map<String,String> tableBody = new HashMap<>();
        tableBody.put("name",name);
        tableBody.put("email",email);
        tableBody.put("gender",gender);
        tableBody.put("status",status);

        return tableBody;
    }

    public Map<String,Object> expectedTable (Object meta, Map<String,String> data){
        Map<String,Object> expectedDataTable = new HashMap<>();
        expectedDataTable.put("meta", meta);
        expectedDataTable.put("data", data);

        return expectedDataTable;

    }


}
