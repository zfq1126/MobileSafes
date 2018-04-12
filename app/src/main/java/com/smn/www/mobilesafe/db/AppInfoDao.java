package com.smn.www.mobilesafe.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-04-08.
 */

public class AppInfoDao {
    //对数据库进行增删查
    private AppInfoOpenHelper helper;
    //需要一个构造函数，新建一个数据库和表，后面的操作在此基础上进行
    public AppInfoDao(Context context){
        helper=new AppInfoOpenHelper(context);
    }
    //数据库中插入信息
    public void Insert(String packagename){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBConstent.PACKAGENAME,packagename);
        db.insert(DBConstent.TABLE_NAME,null,values);
        db.close();
    }
    //数据库中删除信息
    public  void delete(String packagename){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.delete(DBConstent.TABLE_NAME,DBConstent.PACKAGENAME + "=?",new String[]{packagename});
        db.close();
    }
    //查询全部记录
    public List<String> QueryAll(){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor = db.query(DBConstent.TABLE_NAME, new String[]{DBConstent.PACKAGENAME}, null, null, null, null, null);
        List<String> list = new ArrayList<>();
        while (cursor.moveToNext()){
            String packagename=cursor.getString(0);
            list.add(packagename);
        }
        db.close();
        return list;
    }
    //根据包名进行查询，查询某个记录是否在数据库的表中
    public  boolean QueryPackagename(String packagename){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor = db.query(DBConstent.TABLE_NAME, null, DBConstent.PACKAGENAME + "=?", new String[]{packagename}, null, null, null, null);
        boolean b=false;//设想不存在这个记录
        if (cursor!=null){
            while (cursor.moveToNext()){
                b=true;//查询的记录存在所以返回true
            }
        }
        return b;
    }
}
