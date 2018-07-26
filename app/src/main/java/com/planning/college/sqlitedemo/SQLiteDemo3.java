package com.planning.college.sqlitedemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by KUIKUI on 2018-05-21.
 */

public class SQLiteDemo3 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBOpenHelper helper = new DBOpenHelper(SQLiteDemo3.this,"stu.db",null,1);

      //  helper.getReadableDatabase();//获取一个只读的数据库 只能查询  不能写入 不能更新
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from stutb", null);
        if(c != null){
            String[] columns = c.getColumnNames();
            while(c.moveToNext()){
                for(String columnName:columns){
                    Log.i("info",columnName+":"+c.getString(c.getColumnIndex(columnName)));
                }
            }
            c.close();
        }

        db.close();
    }
}
