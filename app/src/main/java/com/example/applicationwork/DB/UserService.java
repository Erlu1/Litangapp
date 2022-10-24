package com.example.applicationwork.DB;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applicationwork.User1;

public class UserService {
    private DatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }
    //登录功能
    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql1="select * from user1 where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql1, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    /*public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(username,password) values(?,?)";
        String sql1="insert into user1(userAccount) values(?)";
        Object obj[]={user.getUsername(),user.getPassword()};
        sdb.execSQL(sql, obj);
        return true;
    }*/

    //注册功能
    public boolean register(User1 user1){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql1="insert into user1(username,password,nicheng) values(?,?,?)";
        Object obj[]={user1.getUsername(),user1.getPassword(),user1.getNicheng()};
        sdb.execSQL(sql1,obj);
        return true;
    }
    //我的界面获得昵称
    public boolean nicheng(User1 user1){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql1="insert into user1(nicheng) values(?)";
        Object o[]={user1.getNicheng()};
        sdb.execSQL(sql1,o);
        return true;
    }

}
