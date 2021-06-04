package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;

    private Button upload_Btn;
    private String address = "http://meanzoo.dothome.co.kr/List.php";


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//      ******************대영 코드 ********************

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

//      ******************대영 코드 ********************


        adapter = new ListViewAdapter();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, address, null,
                new Response.Listener<JSONObject>() {
                    //              성공시 반환
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonData = response.getJSONArray("response");
                            for (int i = 0; i < jsonData.length(); i++) {

                                Log.i("data", response.toString());
                                String title = jsonData.getJSONObject(i).getString("TITLE");
                                int price = jsonData.getJSONObject(i).getInt("PRICE");
                                String writer = jsonData.getJSONObject(i).getString("WRITER");

                                adapter.addItem(title, R.drawable.splash3, price, writer);
                            }
//                            String id = response.getString("name");
//                            String recordDate = response.getString("email");
//                            JSONObject distance = response.getJSONObject("phone");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            //              실패시 반환
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);


//        for(int i = 0; i < 10; i++){
//            adapter.addItem("제목" + i, R.drawable.splash3, "내용" + i);
//        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(MainListActivity.this, post.class);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();
    }
}