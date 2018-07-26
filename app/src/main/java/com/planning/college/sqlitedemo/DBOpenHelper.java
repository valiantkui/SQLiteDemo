package com.planning.college.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KUIKUI on 2018-05-21.
 *
 */

public class DBOpenHelper extends SQLiteOpenHelper {



    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    /**
     * 首次创建数据库的时候调用  一般可以把建库  建表的操作放到此处
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement," +
                " name text not null, " +
                " sex text not null)");

        db.execSQL("insert into stutb(name,sex)" +
                " values('张三','男')");
    }

    @Override
    /**
     * 当数据库的版本发生变化的时候会自动执行
     */
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
