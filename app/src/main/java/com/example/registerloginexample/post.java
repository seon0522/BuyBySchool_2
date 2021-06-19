package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.registerloginexample.databinding.ActivityPostBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class post extends AppCompatActivity {

    //    private ActivityMainlistBinding binding;
    private ActivityPostBinding binding;

    String Title;  //제목
    String writer;  //저자
    String Content;  //소개글
    int Price;  //가격
    int PostNum; //게시글 고유 번호
    String USERID;  //현재 로그인 한 사용자의 아이디

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        writer = intent.getStringExtra("Writer");
        Price = intent.getIntExtra("Price", -1);
        PostNum = intent.getIntExtra("POSTNUM", -1);
        Content = intent.getStringExtra("Content");
        USERID = intent.getStringExtra("USERID");

//        Log.i("postAct","가격" + Price);
//        Log.i("postAct","포스트 " + PostNum);
//        Log.i("postAct","writer" + writer);

        binding.bookText.setText(Title);
        binding.authorText.setText(writer);
        binding.pricePost.setText("" + Price);
        binding.contentPost.setText(Content);


//        binding.postChangeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//                            Toast.makeText(getApplicationContext(), "게시물을 등록합니다", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
//                            startActivity(intent);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                };

//                postRequest postRequest = new postRequest(PostNum, USERID, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(post.this);
//                queue.add(postRequest);
//
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, address, null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                try {
//                                    JSONArray jsonData = response.getJSONArray("response");
//                                    for (int i = 0; i < jsonData.length(); i++) {
//                                        String Content = jsonData.getJSONObject(i).getString("CONTENT");
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                    }
//                });

//                Toast.makeText(getApplicationContext(), "포스트를 수정합니다", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), Update.class);
//                intent.putExtra("Title", Title);
//                intent.putExtra("Writer", writer);
//                intent.putExtra("Price", Price);
//                intent.putExtra("POSTNUM", PostNum);
//                intent.putExtra("USERID", USERID);

//                startActivity(intent);
//            }
//        });

//        binding.backBtn.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "뒤로갑니다", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
//                startActivity(intent);
//            }
//        });

    }

}