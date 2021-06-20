package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class postCommentRequest extends StringRequest {

    final static private String URL = "http://meanzoo.dothome.co.kr/Contentinsert.php";
    // 여기 고침
    private Map<String, String> map;


    public postCommentRequest(String post ,int PostNum, String userID, String text , Response.Listener<String> listener) {
        super(Method.POST,
                URL,
                listener,
                null);

        map = new HashMap<>();
        map.put("mode", post);
        System.out.println(post);
        map.put("COMMENT",text);
        map.put("POSTNUM", PostNum + "");

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
