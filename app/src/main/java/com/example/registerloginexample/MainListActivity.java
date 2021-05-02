package com.example.registerloginexample;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

        ListView listview = (ListView)findViewById(R.id.listView);

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
        listview.setAdapter(adapter);

    }


}
