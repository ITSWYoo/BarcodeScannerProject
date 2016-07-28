package com.example.yoo.barcodescannerproject.common;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_PATH = "/data/data/com.example.yoo.barcodescannerproject/databases/";
    private static final String DB_NAME = "moms.sqlite";
    private static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        setDB(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void setDB(Context mContext)
    {
        File folder = new File(DB_PATH);
        folder.mkdirs();
        File outfile = new File(DB_PATH+DB_NAME);

        try {
            File currentDB =new File(String.valueOf(Environment.getExternalStorageDirectory())+"/moms.sqlite");
            File backupDB = new File("/data/data/com.example.yoo.barcodescannerproject/databases/moms.sqlite");

            if (currentDB.exists()) {
                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
            else{
                AssetManager assetManager = mContext.getResources().getAssets();
                InputStream is = null;
                FileOutputStream fo = null;
                long filesize = 0;
                try {
                    is = assetManager.open(DB_NAME, AssetManager.ACCESS_BUFFER);
                    filesize = is.available();
                    if (outfile.length() <= 0) {
                        byte[] tempdata = new byte[(int) filesize];
                        is.read(tempdata);
                        is.close();
                        outfile.createNewFile();
                        fo = new FileOutputStream(outfile);
                        fo.write(tempdata);
                        fo.close();
                    } else {}
                } catch (IOException e) {}
            }
        } catch (Exception e) {
        }
        finally {
        }
    }
}