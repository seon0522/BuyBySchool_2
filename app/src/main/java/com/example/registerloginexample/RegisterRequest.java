package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "http://meanzoo.dothome.co.kr/Register.php";
    // 여기고침
    private Map<String, String> map;




    public RegisterRequest(String userID, String userPassword, String userDe, int userNumber, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword", userPassword);
        map.put("userDe", userDe);
        map.put("userNumber", userNumber + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}