package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registerloginexample.databinding.ActivityPostBinding;

public class post extends AppCompatActivity {

    Button postChange_btn;
    Button back_btn;

//    private ActivityMainlistBinding binding;
    private ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");

        binding.bookText.setText(Title);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        postChange_btn = (Button) findViewById(R.id.postChange_btn);
        back_btn = (Button) findViewById(R.id.back_btn);

        postChange_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "포스트를 수정합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Update.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "뒤로갑니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                startActivity(intent);
            }
        });

    }

}
