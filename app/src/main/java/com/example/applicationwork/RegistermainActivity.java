package com.example.applicationwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.applicationwork.DB.UserService;

public class RegistermainActivity extends AppCompatActivity {
    ImageView back;
    EditText userAccount;
    EditText userPassword;
    Button Register;
    RadioButton Radio;
    EditText nicheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registermain);
        //获得id
        back=findViewById(R.id.back);
        Register=findViewById(R.id.Register);
        userAccount=findViewById(R.id.userAccount);
        userPassword=findViewById(R.id.userPassword);
        nicheng=findViewById(R.id.userAccount1);
        Radio =findViewById(R.id.zc_R1);

        //返回登录界面功能
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegistermainActivity.this, MainloginActivity.class);
                startActivity(i);
                finish();
            }
        });

        //实现注册功能
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userAccount.getText().toString().trim();
                String pass=userPassword.getText().toString().trim();
                String ni=nicheng.getText().toString().trim();


                Log.i("TAG",name+"_"+pass+"_"+ni+"_");
                UserService userService=new UserService(RegistermainActivity.this);
                User1 user = new User1();
                user.setUsername(name);
                user.setPassword(pass);
                user.setNicheng(ni);
                userService.register(user);
               if (TextUtils.isEmpty(name) && TextUtils.isEmpty(pass)){
                   Toast.makeText(RegistermainActivity.this, "账号 密码 不能为空", Toast.LENGTH_LONG).show();
               }else if(Radio.isChecked()){
                   Toast.makeText(RegistermainActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                   Intent intent =new Intent();
                   intent.setClass(RegistermainActivity.this,MainloginActivity.class);
                   startActivity(intent);
                   finish();
                   return;

               }else {
                   Toast.makeText(RegistermainActivity.this, "请选择同意协议", Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}