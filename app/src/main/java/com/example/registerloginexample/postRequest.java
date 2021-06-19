package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class postRequest extends StringRequest {

    final static private String URL = "http://meanzoo.dothome.co.kr/Post.php";
    // 여기 고침
    private Map<String, String> map;


    public postRequest(int PostNum, String USERID, Response.Listener<String> listener) {
        super(Method.POST,
                URL,
                listener,
                null);

        map = new HashMap<>();
        map.put("PostNum",PostNum + "");
        map.put("USERID", USERID);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
