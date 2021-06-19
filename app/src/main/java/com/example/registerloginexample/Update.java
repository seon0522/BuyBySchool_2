package com.example.registerloginexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.registerloginexample.databinding.ActivityUpdateBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class Update extends AppCompatActivity {
    private ActivityUpdateBinding binding;

    String Title;  //제목
    String Writer;  //저자
    int Price;  //가격
    int PostNum;  //게시글 고유 번호
    String userID;
    String Content;
    String testMemo = "test입니다.";

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        Writer = intent.getStringExtra("Writer");
        Price = intent.getIntExtra("Price", -1);
        PostNum = intent.getIntExtra("POSTNUM", -1);
        Content = intent.getStringExtra("Content");
        userID = intent.getStringExtra("userID");  //post에서 받아온 사용자 값

        //        post에서 넘어온 값
//        Log.i("Update", Title);  //제목
//        Log.i("Update", Writer);  //저자
//        Log.i("Update", "가격 " + Price);  //가격
//        Log.i("Update", "포스트 " + PostNum);  //고유 게시글 번호
//        Log.i("Update", "사용자아이디 " + USERID);

        binding.bookText.setText(Title);
        binding.priceText.setText(String.valueOf(Price));
        binding.authorText.setText(Writer);
        binding.memo.setText(Content);

        System.out.println( "userid ================" + userID);
        System.out.println("post =============" + PostNum);


        binding.updateBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String bookName = binding.bookText.getText().toString();
                String authorName = binding.authorText.getText().toString();
                int priceSetting = Integer.parseInt(binding.priceText.getText().toString());
                String detailMemo = binding.memo.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println("jsonbject ==============================" + jsonObject);
                            boolean success = jsonObject.getBoolean("success");
                            System.out.println("게시물 업데이트" + response);
                            Toast.makeText(getApplicationContext(), "게시물을 수정합니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                            intent.putExtra("userID", userID);
                            startActivity(intent);

                        }catch (JSONException e ){
                            e.printStackTrace();
                        }

                    }
                };


                UpdateRequest updateRequest = new UpdateRequest(userID, PostNum ,bookName, authorName, detailMemo, priceSetting, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Update.this);
                queue.add(updateRequest);

            }
        });

        binding.deleteUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = binding.bookText.getText().toString();
                String authorName = binding.authorText.getText().toString();
                int priceSetting = Integer.parseInt(binding.priceText.getText().toString());
                String detailMemo = binding.memo.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Toast.makeText(getApplicationContext(), "게시물을 삭제합니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                            intent.putExtra("userID", userID);
                            startActivity(intent);

                        }catch (JSONException e ){
                            e.printStackTrace();
                        }


                    }
                };

                UpdateRequest updateRequest = new UpdateRequest(userID, PostNum ,bookName, authorName, detailMemo, priceSetting, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Update.this);
                queue.add(updateRequest);

            }
        });


    }

}
