package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity {

ArrayList<ListViewItem> listViewItems;

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

        this.InitializeListViewItem();

        ListView slistView = (ListView)findViewById(R.id.listView);
        final ListViewAdapter myAdapter = new ListViewAdapter(this, listViewItems);

        slistView.setAdapter(myAdapter);

        slistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(),myAdapter.getItem(position).getTitle(),Toast.LENGTH_LONG).show();
            }
        });





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

    private void InitializeListViewItem() {
        listViewItems = new ArrayList<ListViewItem>();

        listViewItems.add(new ListViewItem(R.drawable.splash, "제목1", "내용1"));
        listViewItems.add(new ListViewItem(R.drawable.splash, "제목2", "내용2"));
        listViewItems.add(new ListViewItem(R.drawable.splash, "제목3", "내용3"));
    }
}