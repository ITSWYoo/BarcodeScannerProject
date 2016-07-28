package com.example.yoo.barcodescannerproject;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoo.barcodescannerproject.common.DBHelper;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.MyDBConstant;
import com.example.yoo.barcodescannerproject.common.UpdateData;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_search, btn_camera;
    private EditText editText_barcode;
    public DBHelper dbHelper ;
    SQLiteDatabase db;
    Cursor c;

    private TextView textView_tagNo_or_serialNo;
    private EditText editText_user;

    private RecyclerView recyclerView_barcodeList;
    private RecyclerViewAdapter recyclerViewAdapter;

    private CheckBox checkbox_tag, checkbox_serial; //태그인지 시리얼인지 ->Recyclerview item이 바뀜
    private int checked_what;
    private static int CHECKED_TAG = 1;
    private static int CHECKED_SERIAL = 2;

    private int barcodeInt=0;

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    Button mainActivity_btn_export;

    ArrayList<MyDB> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한 허가 리스너 마시멜로이상 필요
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                //허가 되면 외부스토리지를 통해 sqlite불러와서 내부db생성
                dbHelper = new DBHelper(getApplicationContext());
                db = dbHelper.getReadableDatabase();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        new TedPermission(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("파일을 읽어오기 위한 권한이 필요합니다.")
                .setRationaleConfirmText("권한필요")
                .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();


        editText_user =(EditText)findViewById(R.id.editText_user);
        checkbox_tag = (CheckBox)findViewById(R.id.checkbox_tag);
        checkbox_serial = (CheckBox)findViewById(R.id.checkbox_serial);
        checkbox_tag.setChecked(true);
        checked_what = CHECKED_TAG;

        textView_tagNo_or_serialNo = (TextView)findViewById(R.id.textView_tagNo_or_serialNo);

        checkbox_tag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    checkbox_serial.setChecked(false);
                    checked_what = CHECKED_TAG;
                    editText_barcode.setText("");

                    recyclerViewAdapter.item = new ArrayList<>();
                    recyclerViewAdapter.clear();

                }
                else
                {
                    checkbox_serial.setChecked(true);
                    checked_what = CHECKED_SERIAL;
                    textView_tagNo_or_serialNo.setText("SerialNo");
                    editText_barcode.setText("");

                    recyclerViewAdapter.item = new ArrayList<>();
                    recyclerViewAdapter.clear();
                }
            }
        });

        checkbox_serial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkbox_tag.setChecked(false);
                    checked_what = CHECKED_SERIAL;

                    recyclerViewAdapter.item = new ArrayList<>();
                    recyclerViewAdapter.clear();
                    editText_barcode.setText("");
                } else {
                    checkbox_tag.setChecked(true);
                    checked_what = CHECKED_TAG;
                    textView_tagNo_or_serialNo.setText("TagNo");

                    recyclerViewAdapter.item = new ArrayList<>();
                    recyclerViewAdapter.clear();
                    editText_barcode.setText("");
                }
            }
        });


        item = new ArrayList<>();
        recyclerView_barcodeList = (RecyclerView)findViewById(R.id.recyclerView_barcodeList);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView_barcodeList.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),item);
        recyclerView_barcodeList.setAdapter(recyclerViewAdapter);



        editText_barcode = (EditText) findViewById(R.id.editText_barcode);
        editText_barcode.setSelection(editText_barcode.getText().length());

        btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            String keyword = "'" + editText_barcode.getText().toString() + "'";

            @Override
            public void onClick(View v) {
                if (!check_user()) {

                } else {
                    keyword = "'%" + editText_barcode.getText().toString() + "%'";
                    keyword = keyword.toUpperCase();
                    if (checked_what == CHECKED_TAG) {
                        c = db.rawQuery("select * from " + MyDBConstant.MyDBTable.INVENTORYTABLE + " where TagNo LIKE " + keyword, null);

                    } else if (checked_what == CHECKED_SERIAL) {
                        c = db.rawQuery("select * from " + MyDBConstant.MyDBTable.INVENTORYTABLE + " where SerialNo LIKE " + keyword, null);
                    }
                    item = new ArrayList<MyDB>();
                    if (c.getCount() > 0) {
                        while (c.moveToNext()) {
                            MyDB data = new MyDB();
                            data.Install_area = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.INSTALL_AREA));
                            data.Install_location = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.INSTALL_LOCATION));
                            data.Detail_location = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.DETAIL_LOCATION));
                            data.Section = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.SECTION));
                            data.Division = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.DIVISION));
                            data.Responsibility = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.RESPONSIBILITY));
                            data.Team = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.TEAM));
                            data.Part = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.PART));
                            data.Manager_id_number = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MANAGER_ID_NUMBER));
                            data.Manager_name = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MANAGER_NAME));
                            data.Manager_position = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MANAGER_POSITION));
                            data.Manager_phone = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MANAGER_PHONE));
                            data.User_id_number = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.USER_ID_NUMBER));
                            data.User_name = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.USER_NAME));
                            data.User_position = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.USER_POSITION));
                            data.User_phone = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.USER_PHONE));
                            data.Use = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.USE));
                            data.TagNo = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.TAGNO));
                            data.SerialNo = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.SERIALNO));
                            data.Classification = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.CLASSIFICATION));
                            data.Spec = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.SPEC));
                            data.Model = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MODEL));
                            data.Maker = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MAKER));
                            data.Inch = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.INCH));
                            data.Cpu = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.CPU));
                            data.Hdd = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.HDD));
                            data.Memory = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.MEMORY));
                            data.Os = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OS));
                            data.Current_state = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.CURRENT_STATE));
                            data.Give_date = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.GIVE_DATE));
                            data.Buy_date = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.BUY_DATE));
                            data.Buy_year = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.BUY_YEAR));
                            data.OA_check1 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK1));
                            data.OA_check2 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK2));
                            data.OA_check3 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK3));
                            data.OA_check4 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK4));
                            data.OA_check5 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK5));
                            data.OA_check6 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK6));
                            data.OA_check7 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK7));
                            data.OA_check8 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK8));
                            data.OA_check9 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK9));
                            data.OA_check10 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK10));
                            data.OA_check11 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK11));
                            data.OA_check12 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK12));
                            data.OA_check13 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK13));
                            data.OA_check14 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK14));
                            data.OA_check15 = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.OA_CHECK15));
                            data.Check_date = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.CHECK_DATE));
                            data.Worker = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.WORKER));
                            data.Is_checked = c.getString(c.getColumnIndex(MyDBConstant.MyDBTable.IS_CHECKED));
                            item.add(data);
                        }
                        c.close();
                    }
                    barcodeInt = 0;
                    recyclerViewAdapter.item = item;
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });

        btn_camera = (Button)findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check_user())
                {

                }
                else {
                    Intent intent = new Intent(MainActivity.this, BarcodeScanActivity.class);
                    intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
                    startActivityForResult(intent, 0);
                }
            }
        });


        mainActivity_btn_export = (Button)findViewById(R.id.mainActivity_btn_export);
        mainActivity_btn_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("추출");
                dialog.setMessage("데이터를 추출하시겠습니까?");
                dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqliteExport();
                    }
                });
                dialog.setNegativeButton("아니오", null);
                dialog.show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewAdapter.item = new ArrayList<>();
        recyclerViewAdapter.clear();

        if(barcodeInt ==0)
        {
            editText_barcode.setText("");

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        barcodeInt = 1;
        if(requestCode == 0) {

            if(resultCode == Activity.RESULT_OK)
            {
                if(barcodeInt ==1) {
                    String contents = data.getStringExtra("SCAN_RESULT");
                    //위의 contents 값에 scan result가 들어온다.
                    editText_barcode.setText(contents);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
        Context mContext;
        public ArrayList<MyDB> item;

        public RecyclerViewAdapter(Context context, ArrayList<MyDB> item){
            mContext=context;
            this.item = item;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final MyDB myDBObject = item.get(position);
            if(checked_what == CHECKED_TAG)
            {
                holder.textViewProduct_name_recyclerview_item.setText(myDBObject.Model);
                holder.textViewTagNo_or_serialNo_recyclerview_item.setText(myDBObject.TagNo);
            }
            else if(checked_what == CHECKED_SERIAL)
            {
                holder.textViewProduct_name_recyclerview_item.setText(myDBObject.Model);
                holder.textViewTagNo_or_serialNo_recyclerview_item.setText(myDBObject.SerialNo);
            }
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    myDBObject.Worker = editText_user.getText().toString();
                    UpdateData.Worker = myDBObject.getWorker();
                    intent.putExtra("data",myDBObject);
                    startActivity(intent);
                }
            });
        }
        public void clear(){

            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return item.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public View mView;
            public TextView textViewProduct_name_recyclerview_item;
            public TextView textViewTagNo_or_serialNo_recyclerview_item;

            public ViewHolder(View itemView) {
                super(itemView);
                mView=itemView;
                textViewProduct_name_recyclerview_item = (TextView)itemView.findViewById(R.id.textView_product_name_recyclerview_item);
                textViewTagNo_or_serialNo_recyclerview_item = (TextView)itemView.findViewById(R.id.textView_tagNo_or_serialNo_recyclerview_item);

            }
        }
    }
    public Boolean check_user()
    {
        if(editText_user.getText().length()==0)
        {
            Toast.makeText(getApplicationContext(),"사용자를 입력해주세요",Toast.LENGTH_SHORT).show();
            editText_user.requestFocus();
            return false;
        }
        else
            return true;
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        long intervalTitme = currentTime - backPressedTime;

        if (0 <= intervalTitme && FINISH_INTERVAL_TIME >= intervalTitme) {
            super.onBackPressed();
        } else {
            backPressedTime = currentTime;
            Toast.makeText(getApplicationContext(), "뒤로 한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }


    public void sqliteExport(){
        try {

            File currentDB = new File("/data/data/com.example.yoo.barcodescannerproject/databases/moms.sqlite");
            File backupDB = new File(getExternalFilesDir("db"),"moms.sqlite");

            if (currentDB.exists()) {
                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
            if(backupDB.exists()){
                Toast.makeText(MainActivity.this, "DB Export Complete!!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
        }
    }
}
