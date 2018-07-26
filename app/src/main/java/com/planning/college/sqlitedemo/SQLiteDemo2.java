package com.planning.college.sqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by KUIKUI on 2018-05-21.
 */

public class SQLiteDemo2 extends Activity{

    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("stu.db",MODE_PRIVATE,null);

      // createTable();
      //  insertData();
        updateData();
        selectData();


    }

    private void createTable(){
        db.execSQL("create table if not exists stutb(" +
                "_id integer primary key autoincrement," +
                "name text not null," +
                "sex text not null)");//主键的名字一定要以下划线开头
    }


    private void insertData(){
        ContentValues values = new ContentValues();

        values.put("name","张三");
        values.put("sex","女");
        long rowId = db.insert("stutb",null,values);


        values.clear();
        values.put("name","张三丰");
        values.put("sex","女");
        db.insert("stutb",null,values);

        values.clear();
        values.put("name","张三封");
        values.put("sex","女");
        db.insert("stutb",null,values);
    }

    private void updateData(){
        ContentValues values = new ContentValues();
        values.put("sex","男");
        db.update("stutb",values,"_id>?",new String[]{"2"});

    }


    private void selectData(){
        Cursor c = db.query("stutb",null,"_id> ?",new String[]{"0"},null,null,"name");
        if(c!=null){
            String[] columns = c.getColumnNames();


            while (c.moveToNext()){
                for(String columnName: columns){
                    Log.i("info",c.getString(c.getColumnIndex(columnName)));
                }
            }

            c.close();
        }


    }


}
