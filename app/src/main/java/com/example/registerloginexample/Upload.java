package com.example.registerloginexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Upload extends AppCompatActivity {
    Button uploadBtn;
    Button cancelBtn;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        cancelBtn = (Button) findViewById(R.id.cancelUpload_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "등록을 취소합니다", Toast.LENGTH_SHORT).show();
            }
        });
        uploadBtn = (Button) findViewById(R.id.upload_btn);
        uploadBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "게시물을 등록합니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
