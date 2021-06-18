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

    String Title;
    String Content;
    int Price;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        Content = intent.getStringExtra("Content");
        Price = intent.getIntExtra("Price", -1);

        Log.i("Update", Title);
        Log.i("Update", Content);
        Log.i("Update", "" + Price);

        binding.bookText.setHint(Title);
        binding.authorText.setHint(Content);
        binding.priceText.setHint("" + Price);

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
                            System.out.println("jsnobject입니다 잠이 오며 배가 고픕니다.." + jsonObject);
                            boolean success = jsonObject.getBoolean("success");
                            System.out.println("게시물 업데이트" + response);
                            Toast.makeText(getApplicationContext(), "게시물을 수정합니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                            startActivity(intent);

                        }catch (JSONException e ){
                            e.printStackTrace();
                        }

                    }
                };

                UpdateRequest updateRequest = new UpdateRequest(bookName, authorName, detailMemo, priceSetting, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Update.this);
                queue.add(updateRequest);

            }
        });

        binding.deleteUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "게시물을 삭제하였습니다", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
