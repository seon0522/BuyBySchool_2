package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.registerloginexample.databinding.ActivityMainlistBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {


    private ListViewAdapter adapter;

    private ArrayList<ListViewItem> list = new ArrayList<>();


    private String address = "http://meanzoo.dothome.co.kr/List.php";

    // id값 인텐트!
    Intent intent = getIntent();
    String userID = intent.getStringExtra("userID");


    private ActivityMainlistBinding binding;
    private TextView tv_id, tv_pass;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//      ******************대영 코드 ********************

        // 등록버튼을 클릭 시 수행
        binding.uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("asdasdsdasd");
                Intent intent = new Intent(MainListActivity.this, Upload.class);
                startActivity(intent);
            }
        });

//      ******************대영 코드 ********************


//        리스트에 연동될 어탭더
        adapter = new ListViewAdapter();

//        어댑터 연결
        binding.listView.setAdapter(adapter);

//        검생창에 검색어 입력시 이벤트 처리리
        binding.Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText = editable.toString();
//                에러가 나서 밑의 코드로 변경
//                좀 더 알아봐야 할 듯
//                try {
//                    if(filterText.length() > 0){
////                    입력값이 있을 경우
//                        binding.listView.setFilterText(filterText);
//                    }else {
////                    입력값이 없을 경우
//                        binding.listView.clearTextFilter();
//                    }
//                }catch (RuntimeException e){
//                    e.getMessage();
//                }
                ((ListViewAdapter)binding.listView.getAdapter()).getFilter().filter(filterText);
            }
        });

//        Json값 처리
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

                                adapter.addItem(title, R.drawable.splash2222, price, writer);
                            }

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


        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(MainListActivity.this, post.class);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();





    }


}