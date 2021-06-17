package com.example.registerloginexample;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UploadRequest extends StringRequest {

    final static private String URL = "http://meanzoo.dothome.co.kr/0601SavePost.php";
    // 여기 고침
    private Map<String, String> map;


    public UploadRequest(String bookName, String authorName, String detailMemo, int priceSetting, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("bookName",bookName);
        map.put("authorName", authorName);
        map.put("detailMemo",detailMemo);
        map.put("priceSetting",priceSetting + "");
//        map.put("DATE","2021-02-02");

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
