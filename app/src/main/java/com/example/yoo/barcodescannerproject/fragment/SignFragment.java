package com.example.yoo.barcodescannerproject.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoo.barcodescannerproject.MainActivity;
import com.example.yoo.barcodescannerproject.R;
import com.example.yoo.barcodescannerproject.SignActivity;
import com.example.yoo.barcodescannerproject.common.DBHelper;
import com.example.yoo.barcodescannerproject.common.DrawImageView;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.MyDBConstant;
import com.example.yoo.barcodescannerproject.common.UpdateData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment {
//    Button signFragment_btn_update, signFragment_btn_export;
//    public DBHelper dbHelper ;
//    SQLiteDatabase db;
//    String currentDateTimeString;
    MyDB sign;
//    DrawImageView signFragment_ImageView;
//    Button signFragment_btn_sign , signFragment_btn_clear;
//    EditText signFragment_editText_id , signFragment_editText_name;
//    CheckBox signFragment_checkBox;
//    String sign_img_name;
    Button signFragment_btn_sign;
    public SignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_sign, container, false);
        signFragment_btn_sign = (Button)v.findViewById(R.id.signFragment_btn_sign);
        signFragment_btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b= getArguments();
                sign =b.getParcelable("Sign");

                Intent intent = new Intent(getContext(),SignActivity.class);
                intent.putExtra("Sign",sign);
                startActivity(intent);
            }
        });
        return v;
    }
//        dbHelper = new DBHelper(getContext());
//        db = dbHelper.getWritableDatabase();
//
//
//
//        signFragment_btn_update = (Button)v.findViewById(R.id.signFragment_btn_update);
//        signFragment_btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
//                dialog.setTitle("수정");
//                dialog.setMessage("데이터를 수정하시겠습니까?");
//                dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if(UpdateData.EquipFragment == true)
//                        EquipmentInfoFragment.getInfo();
//                        if(UpdateData.UserInfoFragment == true)
//                        UserInfoFragment.getInfo();
//                        if(UpdateData.LocationFragment == true)
//                        LocationInfoFragment.getInfo();
//                        if(UpdateData.OaCheckFragment == true)
//                        OaCheckFragment.getInfo();
//                        currentDateTimeString  = DateFormat.getDateTimeInstance().format(new Date());
//                        UpdateData.Check_date = currentDateTimeString;
//                        UpdateData.Is_checked = "yes";
////                        UpdateData.Worker
//                        ContentValues values = new ContentValues();
//                        values.put(MyDBConstant.MyDBTable.INSTALL_AREA, UpdateData.Install_area);
//                        values.put(MyDBConstant.MyDBTable.INSTALL_LOCATION, UpdateData.Install_location);
//                        values.put(MyDBConstant.MyDBTable.DETAIL_LOCATION, UpdateData.Detail_location);
//                        values.put(MyDBConstant.MyDBTable.SECTION, UpdateData.Section);
//                        values.put(MyDBConstant.MyDBTable.DIVISION, UpdateData.Division);
//                        values.put(MyDBConstant.MyDBTable.RESPONSIBILITY, UpdateData.Responsibility);
//                        values.put(MyDBConstant.MyDBTable.TEAM, UpdateData.Team);
//                        values.put(MyDBConstant.MyDBTable.PART, UpdateData.Part);
//                        values.put(MyDBConstant.MyDBTable.MANAGER_ID_NUMBER, UpdateData.Manager_id_number);
//                        values.put(MyDBConstant.MyDBTable.MANAGER_NAME, UpdateData.Manager_name);
//                        values.put(MyDBConstant.MyDBTable.MANAGER_POSITION, UpdateData.Manager_position);
//                        values.put(MyDBConstant.MyDBTable.MANAGER_PHONE, UpdateData.Manager_phone);
//                        values.put(MyDBConstant.MyDBTable.USER_ID_NUMBER, UpdateData.User_id_number);
//                        values.put(MyDBConstant.MyDBTable.USER_NAME, UpdateData.User_name);
//                        values.put(MyDBConstant.MyDBTable.USER_POSITION, UpdateData.User_position);
//                        values.put(MyDBConstant.MyDBTable.USER_PHONE, UpdateData.User_phone);
//                        values.put(MyDBConstant.MyDBTable.TAGNO, UpdateData.TagNo);
//                        values.put(MyDBConstant.MyDBTable.SERIALNO, UpdateData.SerialNo);
//                        values.put(MyDBConstant.MyDBTable.SPEC, UpdateData.Spec);
//                        values.put(MyDBConstant.MyDBTable.MODEL, UpdateData.Model);
//                        values.put(MyDBConstant.MyDBTable.CPU, UpdateData.Cpu);
//                        values.put(MyDBConstant.MyDBTable.HDD, UpdateData.Hdd);
//                        values.put(MyDBConstant.MyDBTable.MEMORY, UpdateData.Memory);
//                        values.put(MyDBConstant.MyDBTable.OS, UpdateData.Os);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK1, UpdateData.OA_check1);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK2, UpdateData.OA_check2);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK3, UpdateData.OA_check3);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK4, UpdateData.OA_check4);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK5, UpdateData.OA_check5);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK6, UpdateData.OA_check6);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK7, UpdateData.OA_check7);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK8, UpdateData.OA_check8);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK9, UpdateData.OA_check9);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK10, UpdateData.OA_check10);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK11, UpdateData.OA_check11);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK12, UpdateData.OA_check12);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK13, UpdateData.OA_check13);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK14, UpdateData.OA_check14);
//                        values.put(MyDBConstant.MyDBTable.OA_CHECK15, UpdateData.OA_check15);
//                        values.put(MyDBConstant.MyDBTable.WORKER, UpdateData.Worker);
//                        values.put(MyDBConstant.MyDBTable.IS_CHECKED,UpdateData.Is_checked);
//                        values.put(MyDBConstant.MyDBTable.CHECK_DATE,UpdateData.Check_date);
//
//                        String whrereClause = "TagNo = ?";
//                        String[] whereArgs = new String[]{"" + sign.TagNo};
//                        db.update(MyDBConstant.MyDBTable.INVENTORYTABLE, values, whrereClause, whereArgs);
//                    }
//                });
//                dialog.setNegativeButton("아니오",null);
//                dialog.show();
//            }
//        });
//
//        signFragment_btn_export = (Button)v.findViewById(R.id.signFragment_btn_export);
//        signFragment_btn_export.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
//                dialog.setTitle("추출");
//                dialog.setMessage("데이터를 추출하시겠습니까?");
//                dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        sqliteExport();
//                        Intent intent = new Intent(getContext(),MainActivity.class);
//                        startActivity(intent);
//                    }
//                });
//                dialog.setNegativeButton("아니오", null);
//                dialog.show();
//            }
//        });
//
//        signFragment_checkBox = (CheckBox)v.findViewById(R.id.signFragment_checkBox);
//        signFragment_checkBox.setChecked(true);
//
//        signFragment_editText_id = (EditText)v.findViewById(R.id.signFragment_editText_id);
//        signFragment_editText_name = (EditText)v.findViewById(R.id.signFragment_editText_name);
//
//        signFragment_ImageView = (DrawImageView)v.findViewById(R.id.signFragment_ImageView);
//        signFragment_ImageView.arVertex = new ArrayList<>();
//        signFragment_btn_sign = (Button)v.findViewById(R.id.signFragment_btn_sign);
//        signFragment_btn_sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("myLog", String.valueOf(signFragment_checkBox.isChecked()));
//                if(signFragment_checkBox.isChecked() && signFragment_editText_name.getText().toString().equals(""))
//                {
//                    Toast.makeText(getContext(),"대리인 성명을 입력해주세요",Toast.LENGTH_SHORT).show();
//                }
//                else if((!signFragment_checkBox.isChecked()) && UpdateData.User_name.equals(""))
//                {
//                    Toast.makeText(getContext(),"사용자 이름을 입력해주세요",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
//                    dialog.setTitle("저장");
//                    dialog.setMessage("서명을 저장하시겠습니까?");
//                    dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            if(signFragment_checkBox.isChecked())
//                            {
//                                sign_img_name = signFragment_editText_name.getText().toString()+"_"+UpdateData.TagNo+".jpg";
//                            }
//                            else
//                            {
//                                sign_img_name = UpdateData.User_name+"_"+UpdateData.TagNo+".jpg";
//                            }
//                            View content = getView().findViewById(R.id.signFragment_ImageView);
//                            content.setDrawingCacheEnabled(true);
//                            Bitmap bitmap = content.getDrawingCache();
//                            File file = new File(getActivity().getExternalFilesDir("sign"), sign_img_name);
//                            try {
//                                file.createNewFile();
//                                FileOutputStream outputStream = new FileOutputStream(file);
//                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//                                outputStream.close();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                    dialog.setNegativeButton("아니오", null);
//                    dialog.show();
//                }
//            }
//        });
//
//        signFragment_btn_clear = (Button)v.findViewById(R.id.signFragment_btn_clear);
//        signFragment_btn_clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signFragment_ImageView.arVertex = new ArrayList<DrawImageView.Vertex>();
//            }
//        });
//        return v;
//    }
//
//
//
//    public void sqliteExport(){
//        try {
//                File currentDB = new File("/data/data/com.example.yoo.barcodescannerproject/databases/moms.sqlite");
//                File backupDB = new File(getActivity().getExternalFilesDir("db"),"moms.sqlite");
//
//                if (currentDB.exists()) {
//                    FileChannel src = new FileInputStream(currentDB).getChannel();
//                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
//                    dst.transferFrom(src, 0, src.size());
//                    src.close();
//                    dst.close();
//                }
//                if(backupDB.exists()){
//                    Toast.makeText(getContext(), "DB Export Complete!!", Toast.LENGTH_SHORT).show();
//                }
//
//        } catch (Exception e) {
//        }
//    }
}
