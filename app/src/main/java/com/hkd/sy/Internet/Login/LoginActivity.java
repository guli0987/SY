package com.hkd.sy.Internet.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hkd.sy.MainActivity;
import com.hkd.sy.R;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //用户名
        usernameEditText = findViewById(R.id.username);
        //密码
        passwordEditText = findViewById(R.id.password);
        //登录或注册按钮
        loginButton =findViewById(R.id.btn_login);
        //进度条
        loadingProgressBar = findViewById(R.id.loading);
        //loginButton.setEnabled(true);
        loginButton.setOnClickListener(this);
    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch(msg.what) {
                case 0:
                    String result=(String)msg.obj;
                    //Toast.makeText(LoginActivity.this,result,Toast.LENGTH_LONG).show();
                    int LoginEnd= Integer.parseInt(result);
                    if(LoginEnd==0){
                        Toast.makeText(LoginActivity.this,"登录失败！",Toast.LENGTH_SHORT).show();
                    }else if(LoginEnd==1){
                        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("AccountName",usernameEditText.getText().toString().trim());
                        startActivity(intent);
                    }
                    break;
                case 1:
                    break;
                default:
                    //Toast.makeText(.this,"出现错误",Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;//原本false
        }
    });
    private void testLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取网址输入框内容
                //encodeURI(encodeURI($("#name").val()))
                String username=usernameEditText.getText().toString().trim();
                    //username= URLEncoder.encode(username,"UTF-8");
                String password=passwordEditText.getText().toString().trim();
                Message message=new Message();
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody SendRequest = new FormBody.Builder()
                            //.addHeader("content-type", "text/html;charset:utf-8")
                            .add("username",username)
                            .add("password",password)
                            .build();
                    //192.168.0.101:8080
                    //http://192.168.0.101:8080/SY/loginServlet
                    //www.wetes.cn/SY/loginServlet
                    Request request = new Request.Builder()
                            .url("http://192.168.0.101:8080/SY/loginServlet")
                            .addHeader("content-type", "text/html;charset:utf-8")
                            .post(SendRequest)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    // Log.d("MainActivity","responseData__________"+responseData);
                    //Message message=new Message();
                    message.what=0;
                    message.obj=responseData;
                } catch (IOException e) {
                    e.printStackTrace();
                    message.what=1;
                    // Log.d("MainActivity","responseData__________error");
                }finally {
                    handler.sendMessage(message);
                }

            }
        }).start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                loadingProgressBar.setVisibility(View.VISIBLE);
                testLogin();
                break;
        }
    }
}
