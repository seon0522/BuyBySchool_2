package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registerloginexample.databinding.ActivityMainlistBinding;
import com.example.registerloginexample.databinding.ActivityPostBinding;

public class post extends AppCompatActivity {

    //    private ActivityMainlistBinding binding;
    private ActivityPostBinding binding;

    String Title;  //제목
    String Content;  //저자
    int Price;  //가격
    int PostNum; //게시글 고유 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        Content = intent.getStringExtra("Content");
        Price = intent.getIntExtra("Price", -1);
        PostNum = intent.getIntExtra("POSTNUM",-1);

        Log.i("postAct","가격" + Price);
        Log.i("postAct","포스트 " + PostNum);

        binding.bookText.setText(Title);
        binding.authorText.setText(Content);
        binding.pricePost.setText(""+Price);


        binding.postChangeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "포스트를 수정합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Update.class);
                intent.putExtra("Title", Title);
                intent.putExtra("Content", Content);
                intent.putExtra("Price", Price);
                intent.putExtra("POSTNUM",PostNum);
                startActivity(intent);
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "뒤로갑니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainListActivity.class);
                startActivity(intent);
            }
        });

    }

}