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

import org.json.JSONException;
import org.json.JSONObject;

public class Upload extends AppCompatActivity {
    Button uploadBtn;
    Button cancelBtn;

    EditText bookText;
    EditText authorText;
    EditText priceText;
    EditText memo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        bookText = (EditText) findViewById(R.id.bookText);
        authorText = (EditText) findViewById(R.id.authorText);
        priceText = (EditText) findViewById(R.id.priceText);
        memo = (EditText) findViewById(R.id.memo);

        cancelBtn = (Button) findViewById(R.id.cancelUpload_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "등록을 취소합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                startActivity(intent);
            }
        });
        uploadBtn = (Button) findViewById(R.id.upload_btn);

//        업로드 버튼 -----------------------------------------------------

        uploadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String bookName = bookText.getText().toString();
                String authorName = authorText.getText().toString();
                int priceSetting = Integer.parseInt(priceText.getText().toString());
                String detailMemo = memo.getText().toString();
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

                UploadRequest uploadRequest = new UploadRequest(bookName, authorName, detailMemo, priceSetting, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Upload.this);
                queue.add(uploadRequest);
            }
        });
    }
}
