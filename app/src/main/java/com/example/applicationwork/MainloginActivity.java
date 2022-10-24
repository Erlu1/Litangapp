package com.example.applicationwork;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationwork.DB.UserService;


public class MainloginActivity extends AppCompatActivity {
    //获得xml中的组件
    EditText username,password;
    Button login;
    TextView zc_one;

    //两秒内点击两次返回键退出
    long exittime;
    public boolean onKeyDown(int keyCode, KeyEvent event){ //参数：按的键；按键事件
        //  判断事件触发
        if (keyCode == KeyEvent.KEYCODE_BACK){
            // 判断两次点击间隔时间
            if((System.currentTimeMillis()-exittime)>2000){
                Toast.makeText(MainloginActivity.this,"再次返回程序退出！", Toast.LENGTH_SHORT).show();
                exittime = System.currentTimeMillis(); // 设置第一次点击时间
            }else{
                //finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);

        //通过组件id创建组件对象
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        zc_one = findViewById(R.id.zc_one);

        //为登录按钮添加监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录功能
                String name=username.getText().toString();
                System.out.println(name);
                String pass=password.getText().toString();
                System.out.println(pass);
                Log.i("TAG",name+"_"+pass);
                UserService userService=new UserService(MainloginActivity.this);
                boolean flag=userService.login(name,pass);

                if(TextUtils.isEmpty(name) && TextUtils.isEmpty(pass)){
                    Toast.makeText(MainloginActivity.this, "账号 密码 不能为空", Toast.LENGTH_LONG).show();
                }else if (flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(MainloginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainloginActivity.this,MainmyActivity.class);
                    startActivity(intent);
                }else {
                    Log.i("TAG","登录失败");
                    Toast.makeText(MainloginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                }
               /* if (flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(MainloginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainloginActivity.this,MainmyActivity.class);
                    startActivity(intent);
                }else if (TextUtils.isEmpty(name) && TextUtils.isEmpty(pass)){
                    Toast.makeText(MainloginActivity.this, "账号 密码 不能为空", Toast.LENGTH_LONG).show();
                }else {
                    Log.i("TAG","登录失败");
                    Toast.makeText(MainloginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                }*/

            }
        });
        //为注册添加监听事件
        zc_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(MainloginActivity.this,RegistermainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
    /*protected void reg(View view){
        startActivity(new Intent(getApplicationContext(),RegistermainActivity.class));
    }
    /**
     * function: 登录
     * */
    /*public void login(View view){

        EditText EditTextAccount = findViewById(R.id.userAccount);
        EditText EditTextPassword = findViewById(R.id.userPassword);

        new Thread(){
            @Override
            public void run() {
                UserDao userDao = new UserDao();
                int msg = userDao.login(EditTextAccount.getText().toString(),EditTextPassword.getText().toString());
                hand1.sendEmptyMessage(msg);
            }
        }.start();

    }

    @SuppressLint("HandlerLeak")
    final Handler hand1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG).show();
            } else if (msg.what == 1) {
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
            } else if (msg.what == 2){
                Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_LONG).show();
            } else if (msg.what == 3){
                Toast.makeText(getApplicationContext(), "账号不存在", Toast.LENGTH_LONG).show();
            }
        }
    };*/
}