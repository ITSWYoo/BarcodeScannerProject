package com.example.yoo.barcodescannerproject.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoo.barcodescannerproject.R;
import com.example.yoo.barcodescannerproject.common.DBHelper;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.MyDBConstant;
import com.example.yoo.barcodescannerproject.common.UpdateData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends Fragment {
    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor c;
    Button userInfoFragment_button_search , userInfoFragment_button_user_search, userInfoFragment_button_equal;
    static EditText userInfoFragment_editText_manager_id, userInfoFragment_editText_manager_name, userInfoFragment_editText_manager_phone, userInfoFragment_editText_manager_position;
    static EditText userInfoFragment_editText_user_id, userInfoFragment_editText_user_name, userInfoFragment_editText_user_phone, userInfoFragment_editText_user_position;
    String keyword;
    public UserInfoFragment() {
        // Required empty public constructor
    }

    public static void getInfo()
    {
        UpdateData.Manager_id_number = userInfoFragment_editText_manager_id.getText().toString();
        UpdateData.Manager_name = userInfoFragment_editText_manager_name.getText().toString();
        UpdateData.Manager_phone = userInfoFragment_editText_manager_phone.getText().toString();
        UpdateData.Manager_position = userInfoFragment_editText_manager_position.getText().toString();

        UpdateData.User_id_number = userInfoFragment_editText_user_id.getText().toString();
        UpdateData.User_name = userInfoFragment_editText_user_name.getText().toString();
        UpdateData.User_phone = userInfoFragment_editText_user_phone.getText().toString();
        UpdateData.User_position = userInfoFragment_editText_user_position.getText().toString();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v= inflater.inflate(R.layout.fragment_user_info, container, false);
        Bundle b= getArguments();
        MyDB data = b.getParcelable("UserInfo");
        userInfoFragment_editText_manager_id = (EditText)v.findViewById(R.id.userInfoFragment_editText_manager_id);
        userInfoFragment_editText_manager_id.setText(data.getManager_id_number());
        userInfoFragment_editText_manager_name = (EditText)v.findViewById(R.id.userInfoFragment_editText_manager_name);
        userInfoFragment_editText_manager_name.setText(data.getManager_name());
        userInfoFragment_editText_manager_phone = (EditText)v.findViewById(R.id.userInfoFragment_editText_manager_phone);
        userInfoFragment_editText_manager_phone.setText(data.getManager_phone());
        userInfoFragment_editText_manager_position = (EditText)v.findViewById(R.id.userInfoFragment_editText_manager_position);
        userInfoFragment_editText_manager_position.setText(data.getManager_position());

        userInfoFragment_editText_user_id = (EditText)v.findViewById(R.id.userInfoFragment_editText_user_id);
        userInfoFragment_editText_user_id.setText(data.getUser_id_number());
        userInfoFragment_editText_user_name = (EditText)v.findViewById(R.id.userInfoFragment_editText_user_name);
        userInfoFragment_editText_user_name.setText(data.getUser_name());
        userInfoFragment_editText_user_phone = (EditText)v.findViewById(R.id.userInfoFragment_editText_user_phone);
        userInfoFragment_editText_user_phone.setText(data.getUser_phone());
        userInfoFragment_editText_user_position = (EditText)v.findViewById(R.id.userInfoFragment_editText_user_position);
        userInfoFragment_editText_user_position.setText(data.getUser_position());

        userInfoFragment_button_equal = (Button)v.findViewById(R.id.userInfoFragment_button_equal);
        userInfoFragment_button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfoFragment_editText_user_id.setText(userInfoFragment_editText_manager_id.getText().toString());
                userInfoFragment_editText_user_name.setText(userInfoFragment_editText_manager_name.getText().toString());
                userInfoFragment_editText_user_phone.setText(userInfoFragment_editText_manager_phone.getText().toString());
                userInfoFragment_editText_user_position.setText(userInfoFragment_editText_manager_position.getText().toString());
            }
        });

        dbHelper = new DBHelper(getContext());
        DBHelper.setDB(getContext());
        db = dbHelper.getReadableDatabase();
        userInfoFragment_button_search = (Button)v.findViewById(R.id.userInfoFragment_button_search);
        userInfoFragment_button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                keyword =  "'"+userInfoFragment_editText_manager_id.getText().toString()+"'";
                c=db.rawQuery("select * from " + MyDBConstant.MyDBTable.USERDATATABLE+ " where code = "+keyword ,null);
                if(c.getCount()==0)
                {
                    Toast.makeText(getContext(),"등록되지 않은 사번입니다.",Toast.LENGTH_SHORT).show();
                }
                else if(c.getCount()>0) {
                    while (c.moveToNext()) {
                        userInfoFragment_editText_manager_id.setText(c.getString(c.getColumnIndex("code")));
                        userInfoFragment_editText_manager_name.setText(c.getString(c.getColumnIndex("name")));
                        userInfoFragment_editText_manager_phone.setText(c.getString(c.getColumnIndex("phone")));
                        userInfoFragment_editText_manager_position.setText(c.getString(c.getColumnIndex("ex_titname")));
                    }
                    c.close();
                }
            }
        });

        userInfoFragment_button_user_search = (Button)v.findViewById(R.id.userInfoFragment_button_user_search);
        userInfoFragment_button_user_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword =  "'"+userInfoFragment_editText_user_id.getText().toString()+"'";
                c=db.rawQuery("select * from " + MyDBConstant.MyDBTable.USERDATATABLE+ " where code = "+keyword ,null);
                if(c.getCount()==0)
                {
                    Toast.makeText(getContext(),"등록되지 않은 사번입니다.",Toast.LENGTH_SHORT).show();
                }
                else if(c.getCount()>0) {
                    while (c.moveToNext()) {
                        userInfoFragment_editText_user_id.setText(c.getString(c.getColumnIndex("code")));
                        userInfoFragment_editText_user_name.setText(c.getString(c.getColumnIndex("name")));
                        userInfoFragment_editText_user_phone.setText(c.getString(c.getColumnIndex("phone")));
                        userInfoFragment_editText_user_position.setText(c.getString(c.getColumnIndex("ex_titname")));
                    }
                }
            }
        });
        getInfo();
        return v;
    }

}
