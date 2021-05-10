package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

    private TextView tv_id, tv_pass;
    private Button button4;
//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

        button4 = findViewById(R.id.button4);

        // 등록버튼을 클릭 시 수행
        button4.setOnClickListener(new View.OnClickListener() {
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



        final ArrayList<String> list = new ArrayList<>();

        //총 게시글의 수 - list_num
        int list_num = 20;
        for (int i = 0; i < list_num; i++){
            list.add("item" + i);
        }

//        ArrayList 객체와 listView 객체 연결하기 위해서 arrayAdapter사용
//        1. arrayList 객체를 arrayapter에 연결
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list //데이터가 저장되어 있는 Arraylist
        );

        //2. listView 객체에 adapter 객체 연결결
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(adapter);




//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

        setContentView(R.layout.activity_mainlist);
        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");

        tv_id.setText(userID);
        tv_pass.setText(userPass);

//      ***********************************************
//      ***********************************************
//      ******************대영 코드 ********************
//      ***********************************************
//      ***********************************************

    }
}
