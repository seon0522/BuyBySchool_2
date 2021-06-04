package com.example.registerloginexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registerloginexample.databinding.ActivityUpdateBinding;

public class Update extends AppCompatActivity {
    private ActivityUpdateBinding binding;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding.updateBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "게시물을 수정하였습니다", Toast.LENGTH_SHORT).show();
            }
        });

        binding.cancelUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "수정을 취소하였습니다", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
