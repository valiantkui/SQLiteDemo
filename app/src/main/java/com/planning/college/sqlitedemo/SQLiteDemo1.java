package com.planning.college.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


/**
 * 默认每个程序都有自己的数据库，且是各自互相不干扰
 * 1.创建一个数据库  并且打开
 */
public class SQLiteDemo1 extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建一个数据库并且打开
        db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);

        //createTable();

        //insertData();
        selectData();

        closeDB();

    }


    private void createTable(){
        db.execSQL("create table if not exists usertb(" +
                "_id integer primary key autoincrement," +
                "name text not null," +
                "sex text not null)");//主键的名字一定要以下划线开头
    }

    private void insertData(){

        db.execSQL("insert into usertb(name,sex) values('张三','男')");

        db.execSQL("insert into usertb(name,sex) values('李四','男')");

        db.execSQL("insert into usertb(name,sex) values('小红','女')");
    }


    /**
     * 从表中查询数据
     */
    private void selectData(){
        Cursor c = db.rawQuery("select * from usertb",null);
        if(c!=null){
            while (c.moveToNext()){
                Log.i("info","_id:"+c.getString(c.getColumnIndex("_id")));
                Log.i("info","name:"+c.getString(c.getColumnIndex("name")));
                Log.i("info","sex:"+c.getString(c.getColumnIndex("sex")));

            }
            c.close();//当游标使用完之后必须释放
        }


    }


    /**
     * 关闭数据库连接，释放资源
     */
    private void closeDB(){


        db.close();
    }

}
