package com.planning.college.sqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;

/**
 * Created by KUIKUI on 2018-05-21.
 *
 * 数据篇：File
 * MODE_PRIVATE
 *      为默认操作模式，代表文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖源文件的内容。
 * MODE_APPEND
 *      模式会检查文件是否存在，存在就往文件追加内容，否则就创建新文件。
 * MODE_WORLD_READABLE和MODE_WORLD_WRITEABLE
 *      用来控制其他应用是否有权限读写该文件
 *  MODE_WORLD_READABLE
 *      表示当前文件可以被其他应用读取
 *  MODE_WORLD_WRITEABLE
*       表示当前文件可以被其他应用写入
 */

public class FileDemo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //创建文件
        File file = this.getFilesDir();//当前目录是当前应用程序默认的数据存储目录
        Log.i("info",file.toString());

        File file2 = this.getCacheDir();//默认的缓存文件存放位置，可以把一些不重要的文件在此处创建使用
        //如果手机的内存不足的时候，系统会自动去删除app的cache目录的数据
        Log.i("info",file2.toString());

        File file3 = this.getDir("imooc", MODE_PRIVATE);
        Log.i("info",file3.toString());
        /*
            可以得到外部的存储位置，该位置的数据跟内部的使用是一样的
            如果APP卸载了，这里面的数据也会自动清除掉
         */
        File file4 = this.getExternalCacheDir();
        Log.i("info",file4.toString());
        /*
            如果说开发者不遵守以上的规则，不把数据放入data/data/<包名>等
            卸载之后，数据将不会被清除掉，将会造成数据垃圾。
            所以，不建议开发者自定义目录
         */

    }



    public void test1(){


    }
}
