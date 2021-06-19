package com.example.registerloginexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.registerloginexample.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 회원가입 버튼을 클릭 시 수행
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("가입하신 이메일,비밀번호를 잊으신 분은 \ntest@naver.com 로 문의주세요 !");
                builder.setPositiveButton("확인",null);
                builder.create().show();
            }
        });


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = binding.etId.getText().toString();
                String userPass = binding.etPass.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // TODO : 인코딩 문제때문에 한글 DB인 경우 로그인 불가
                            System.out.println("hongchul" + response);
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 로그인에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();

//                                  대영(로그인화면) > 효선(메인화면) 연결하기 전 코드
//                              Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                Intent intent = new Intent(LoginActivity.this, MainListActivity.class);


                                System.out.println("login userID ++++++++++++++++++++++++++++++++++++++++++++++=" + userID);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPass", userPass);
                                startActivity(intent);
                            } else { // 로그인에 실패한 경우

                                if(userID.equals("")&&userPass.equals("")){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("아이디를 입력하세요!");
                                    builder.setPositiveButton("확인",null);
                                    builder.create().show();
                                } else if(userPass.equals("")) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("비밀번호를 입력하세요!");
                                    builder.setPositiveButton("확인", null);
                                    builder.create().show();
                                    return;
                                }else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("아이디/비밀번호 가 일치하지 않습니다 \n다시 시도해 주세요!");
                                    builder.setPositiveButton("확인", null);
                                    builder.create().show();
                                    return;
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });


    }
}
