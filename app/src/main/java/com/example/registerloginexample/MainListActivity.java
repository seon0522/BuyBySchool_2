package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;

    private Button upload_Btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

        upload_Btn = findViewById(R.id.upload_Btn);

        // 등록버튼을 클릭 시 수행
        upload_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("asdasdsdasd");
                Intent intent = new Intent(MainListActivity.this, Upload.class);
                startActivity(intent);
            }
        });

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

        adapter = new ListViewAdapter();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //총 게시글의 수 - list_num
        int list_num = 5;
        for (int i = 0; i < list_num; i++){
            adapter.addItem("제목" + i, R.drawable.splash , "내용"+i);

            adapter.notifyDataSetChanged();
        }




//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

        // *************이것때문에 버튼 클릭이 안된거임**********
//        setContentView(R.layout.activity_mainlist);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

    }
}