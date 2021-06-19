package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.registerloginexample.databinding.ActivityUpdateBinding;
import com.example.registerloginexample.databinding.ActivityUploadBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class Upload extends AppCompatActivity {

    private ActivityUploadBinding binding;

    String USERID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        USERID = intent.getStringExtra("USERID");
        System.out.println(USERID + "==============================================");



        binding.cancelUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "등록을 취소합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                startActivity(intent);
            }
        });

//        업로드 버튼 -----------------------------------------------------

        binding.uploadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String bookName = binding.bookText.getText().toString();
                String authorName = binding.authorText.getText().toString();
                int priceSetting = Integer.parseInt(binding.priceText.getText().toString());
                String detailMemo = binding.memo.getText().toString();
                String DATA = "2021-05-21";

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println("jsnobject입니다@@@@@@@@@@@@@@@@" + jsonObject);
                            boolean success = jsonObject.getBoolean("success");
//                            if(success) {
                                System.out.println("게시물등록" + response);
                                Toast.makeText(getApplicationContext(), "게시물을 등록합니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                                startActivity(intent);
//                            }
//                            else{
//                                Toast.makeText(getApplicationContext(),"게시물 등록에 실패하였습니다.",Toast.LENGTH_SHORT).show();
//                                return;
//                            }

                        }catch (JSONException e ){
                            e.printStackTrace();
                        }

                    }
                };

                UploadRequest uploadRequest = new UploadRequest(USERID ,bookName, authorName, detailMemo, priceSetting, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Upload.this);
                queue.add(uploadRequest);
            }
        });
    }
}
