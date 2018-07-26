package com.planning.college.sqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by KUIKUI on 2018-05-21.
 */

public class FileDemo2 extends Activity implements View.OnClickListener{



    private EditText edt;
    private Button btn;
    private TextView contentValue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_demo1);

        edt = findViewById(R.id.editText1);
        btn = findViewById(R.id.write);
        contentValue = findViewById(R.id.text_view);

        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        String content = edt.getText().toString();
        writeFiles(content);

        contentValue.setText(readFiles());


    }


    /**
     * 保存文件内容
     * @param content
     */
    public void writeFiles(String content) {



      //  Log.i("info","1:"+file.getAbsolutePath()+",2:"+file.getPath());
        try{
        //默认保存到/data/data/<包名>/files/
        FileOutputStream fos = openFileOutput("b.txt", MODE_PRIVATE);



        if(content != null){

            byte[] bytes = content.getBytes();
            fos.write(bytes);
            fos.flush();

        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 从文件中读取内容
     * @return
     */
    public String readFiles(){
        String content = "";
        try {
            FileInputStream fis = openFileInput("b.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffers = new byte[1024];
            int len = 0;
            while((len = fis.read(buffers)) != -1){
                baos.write(buffers,0,len);
            }

            content = baos.toString();
            fis.close();
            baos.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return content;
    }

}
