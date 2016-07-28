package com.example.yoo.barcodescannerproject;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoo.barcodescannerproject.common.DBHelper;
import com.example.yoo.barcodescannerproject.common.DrawImageView;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.MyDBConstant;
import com.example.yoo.barcodescannerproject.common.UpdateData;
import com.example.yoo.barcodescannerproject.fragment.EquipmentInfoFragment;
import com.example.yoo.barcodescannerproject.fragment.LocationInfoFragment;
import com.example.yoo.barcodescannerproject.fragment.OaCheckFragment;
import com.example.yoo.barcodescannerproject.fragment.UserInfoFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SignActivity extends AppCompatActivity {

    DrawImageView signActivity_ImageView;
    Button signActivity_btn_sign , signActivity_btn_clear;
    CheckBox signActivity_checkBox;
    String sign_img_name;

    EditText signActivity_editText_name,signActivity_editText_id;

    Button signActivity_btn_update, signActivity_btn_export;
    public DBHelper dbHelper ;
    SQLiteDatabase db;
    String currentDateTimeString;
    MyDB sign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        dbHelper = new DBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        Intent intent = getIntent();
        sign = intent.getParcelableExtra("Sign");


//        Bundle b = new Bundle();
//        b= getArguments();
//        sign =b.getParcelable("Sign");

        if(UpdateData.EquipFragment == true)
            EquipmentInfoFragment.getInfo();
        if(UpdateData.UserInfoFragment == true)
            UserInfoFragment.getInfo();
        if(UpdateData.LocationFragment == true)
            LocationInfoFragment.getInfo();
        if(UpdateData.OaCheckFragment == true)
            OaCheckFragment.getInfo();


        signActivity_checkBox = (CheckBox)findViewById(R.id.signActivity_checkBox);
        signActivity_checkBox.setChecked(true);

        signActivity_editText_id = (EditText)findViewById(R.id.signActivity_editText_id);
        signActivity_editText_name = (EditText)findViewById(R.id.signActivity_editText_name);


        signActivity_ImageView = (DrawImageView)findViewById(R.id.signActivity_ImageView);
        signActivity_ImageView.arVertex = new ArrayList<>();

        signActivity_btn_sign = (Button)findViewById(R.id.signActivity_btn_sign);
        signActivity_btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("myLog", String.valueOf(signActivity_checkBox.isChecked()));
                if (signActivity_checkBox.isChecked() && signActivity_editText_name.getText().toString().equals("")) {
                    Toast.makeText(SignActivity.this, "대리인 성명을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if ((!signActivity_checkBox.isChecked()) && UpdateData.User_name.equals("")) {
                    Toast.makeText(SignActivity.this, "사용자 이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SignActivity.this);
                    dialog.setTitle("저장");
                    dialog.setMessage("서명을 저장하시겠습니까?");
                    dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (signActivity_checkBox.isChecked()) {
                                sign_img_name = signActivity_editText_name.getText().toString() + "_" + UpdateData.TagNo + ".jpg";
                            } else {
                                sign_img_name = UpdateData.User_name + "_" + UpdateData.TagNo + ".jpg";
                            }
                            View content = findViewById(R.id.signActivity_ImageView);
                            content.setDrawingCacheEnabled(true);
                            Bitmap bitmap = content.getDrawingCache();
                            File file = new File(getExternalFilesDir("sign"), sign_img_name);
                            try {
                                file.createNewFile();
                                FileOutputStream outputStream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                                outputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    dialog.setNegativeButton("아니오", null);
                    dialog.show();
                }
            }
        });

        signActivity_btn_clear = (Button)findViewById(R.id.signActivity_btn_clear);
        signActivity_btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signActivity_ImageView.arVertex = new ArrayList<DrawImageView.Vertex>();
            }
        });

        signActivity_btn_update = (Button)findViewById(R.id.signActivity_btn_update);
        signActivity_btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SignActivity.this);
                dialog.setTitle("수정");
                dialog.setMessage("데이터를 수정하시겠습니까?");
                dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(UpdateData.EquipFragment == true)
                            EquipmentInfoFragment.getInfo();
                        if(UpdateData.UserInfoFragment == true)
                            UserInfoFragment.getInfo();
                        if(UpdateData.LocationFragment == true)
                            LocationInfoFragment.getInfo();
                        if(UpdateData.OaCheckFragment == true)
                            OaCheckFragment.getInfo();
                        currentDateTimeString  = DateFormat.getDateTimeInstance().format(new Date());
                        UpdateData.Check_date = currentDateTimeString;
                        UpdateData.Is_checked = "yes";
                        ContentValues values = new ContentValues();
                        values.put(MyDBConstant.MyDBTable.INSTALL_AREA, UpdateData.Install_area);
                        values.put(MyDBConstant.MyDBTable.INSTALL_LOCATION, UpdateData.Install_location);
                        values.put(MyDBConstant.MyDBTable.DETAIL_LOCATION, UpdateData.Detail_location);
                        values.put(MyDBConstant.MyDBTable.SECTION, UpdateData.Section);
                        values.put(MyDBConstant.MyDBTable.DIVISION, UpdateData.Division);
                        values.put(MyDBConstant.MyDBTable.RESPONSIBILITY, UpdateData.Responsibility);
                        values.put(MyDBConstant.MyDBTable.TEAM, UpdateData.Team);
                        values.put(MyDBConstant.MyDBTable.PART, UpdateData.Part);
                        values.put(MyDBConstant.MyDBTable.MANAGER_ID_NUMBER, UpdateData.Manager_id_number);
                        values.put(MyDBConstant.MyDBTable.MANAGER_NAME, UpdateData.Manager_name);
                        values.put(MyDBConstant.MyDBTable.MANAGER_POSITION, UpdateData.Manager_position);
                        values.put(MyDBConstant.MyDBTable.MANAGER_PHONE, UpdateData.Manager_phone);
                        values.put(MyDBConstant.MyDBTable.USER_ID_NUMBER, UpdateData.User_id_number);
                        values.put(MyDBConstant.MyDBTable.USER_NAME, UpdateData.User_name);
                        values.put(MyDBConstant.MyDBTable.USER_POSITION, UpdateData.User_position);
                        values.put(MyDBConstant.MyDBTable.USER_PHONE, UpdateData.User_phone);
                        values.put(MyDBConstant.MyDBTable.TAGNO, UpdateData.TagNo);
                        values.put(MyDBConstant.MyDBTable.SERIALNO, UpdateData.SerialNo);
                        values.put(MyDBConstant.MyDBTable.SPEC, UpdateData.Spec);
                        values.put(MyDBConstant.MyDBTable.MODEL, UpdateData.Model);
                        values.put(MyDBConstant.MyDBTable.CPU, UpdateData.Cpu);
                        values.put(MyDBConstant.MyDBTable.HDD, UpdateData.Hdd);
                        values.put(MyDBConstant.MyDBTable.MEMORY, UpdateData.Memory);
                        values.put(MyDBConstant.MyDBTable.OS, UpdateData.Os);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK1, UpdateData.OA_check1);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK2, UpdateData.OA_check2);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK3, UpdateData.OA_check3);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK4, UpdateData.OA_check4);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK5, UpdateData.OA_check5);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK6, UpdateData.OA_check6);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK7, UpdateData.OA_check7);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK8, UpdateData.OA_check8);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK9, UpdateData.OA_check9);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK10, UpdateData.OA_check10);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK11, UpdateData.OA_check11);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK12, UpdateData.OA_check12);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK13, UpdateData.OA_check13);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK14, UpdateData.OA_check14);
                        values.put(MyDBConstant.MyDBTable.OA_CHECK15, UpdateData.OA_check15);
                        values.put(MyDBConstant.MyDBTable.WORKER, UpdateData.Worker);
                        values.put(MyDBConstant.MyDBTable.IS_CHECKED,UpdateData.Is_checked);
                        values.put(MyDBConstant.MyDBTable.CHECK_DATE,UpdateData.Check_date);

                        String whrereClause = "TagNo = ?";
                        String[] whereArgs = new String[]{"" + sign.TagNo};
                        db.update(MyDBConstant.MyDBTable.INVENTORYTABLE, values, whrereClause, whereArgs);
                    }
                });
                dialog.setNegativeButton("아니오",null);
                dialog.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignActivity.this, DetailActivity.class);
        startActivity(intent);
    }
}
