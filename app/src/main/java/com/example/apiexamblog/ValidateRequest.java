package com.example.apiexamblog;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
//아이디 중복확인하는 클래스
public class ValidateRequest extends StringRequest {
    final static private String URL = "http://rladbsgus94.cafe24.com/UserValidate.php";
    private Map <String,String > parameters;

    public ValidateRequest(String userID,Response.Listener<String>listener) {
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
