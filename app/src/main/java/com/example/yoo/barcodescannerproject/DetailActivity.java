package com.example.yoo.barcodescannerproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.UpdateData;
import com.example.yoo.barcodescannerproject.fragment.EquipmentInfoFragment;
import com.example.yoo.barcodescannerproject.fragment.LocationInfoFragment;
import com.example.yoo.barcodescannerproject.fragment.OaCheckFragment;
import com.example.yoo.barcodescannerproject.fragment.SignFragment;
import com.example.yoo.barcodescannerproject.fragment.UserInfoFragment;

public class DetailActivity extends AppCompatActivity {
    TabLayout tabLayout ;
    ViewPager pager;
    MyPagerAdapter myPagerAdapter;
    LocationInfoFragment locationInfoFragment;
    EquipmentInfoFragment equipmentInfoFragment;
    OaCheckFragment oaCheckFragment;
    SignFragment signFragment;
    UserInfoFragment userInfoFragment;
    MyDB fromMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        fromMain = (MyDB)bundle.getParcelable("data");
        //from MainActivity

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        //Tablayout & ViewPager

        setUpdateData(fromMain);
        //set UpdateData


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==4)
                {
                    Intent intent = new Intent(DetailActivity.this, SignActivity.class);
                    intent.putExtra("Sign",fromMain);
                    startActivity(intent);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //ViewPager Listener
    }


    class MyPagerAdapter extends FragmentPagerAdapter{
        private static final int ITEM_COUNT=5;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle b;
            switch (position){
                case 0:
                    b= new Bundle();
                    b.putParcelable("Equipment",fromMain);
                    equipmentInfoFragment = new EquipmentInfoFragment();
                    UpdateData.EquipFragment = true;
                    equipmentInfoFragment.setArguments(b);
                    Log.e("myLog", String.valueOf(position));
                    return equipmentInfoFragment;
                case 1:
                    b= new Bundle();
                    b.putParcelable("UserInfo",fromMain);
                    userInfoFragment = new UserInfoFragment();
                    UpdateData.UserInfoFragment= true;
                    userInfoFragment.setArguments(b);
                    Log.e("myLog", String.valueOf(position));
                    return userInfoFragment;
                case 2:
                    b= new Bundle();
                    b.putParcelable("LocationInfo",fromMain);
                    locationInfoFragment = new LocationInfoFragment();
                    UpdateData.LocationFragment =true;
                    locationInfoFragment.setArguments(b);
                    Log.e("myLog", String.valueOf(position));
                    return locationInfoFragment;
                case 3:
                    b= new Bundle();
                    b.putParcelable("OaCheck", fromMain);
                    oaCheckFragment = new OaCheckFragment();
                    UpdateData.OaCheckFragment = true;
                    oaCheckFragment.setArguments(b);
                    Log.e("myLog", String.valueOf(position));
                    return oaCheckFragment;
                case 4:
                    b = new Bundle();
                    b.putParcelable("Sign",fromMain);
                    signFragment = new SignFragment();
                    signFragment.setArguments(b);
//                    Intent intent = new Intent(DetailActivity.this, SignActivity.class);
//                    intent.putExtra("Sign",muser);
//                    startActivity(intent);
                    Log.e("myLog", String.valueOf(position));
                    return signFragment;

            }
            return null;
        }

        @Override
        public int getCount() {
            return ITEM_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position ==0)
            {
                return "장비정보";
            }
            else if(position==1)
                return "사용자정보";
            else if(position==2)
                return "위치정보";
            else if(position==3)
                return "OA 점검";
            else if(position==4)
                return "서명";
            return null;
        }
    }
    public void setUpdateData(MyDB fromMain)
    {
        UpdateData.Install_area = fromMain.Install_area;
        UpdateData.Install_location = fromMain.Install_location;
        UpdateData.Detail_location = fromMain.Detail_location;
        UpdateData.Section = fromMain.Section;
        UpdateData.Division = fromMain.Division;
        UpdateData.Responsibility = fromMain.Responsibility;
        UpdateData.Team = fromMain.Team;
        UpdateData.Part = fromMain.Part;
        UpdateData.Manager_id_number =fromMain.Manager_id_number;
        UpdateData.Manager_name = fromMain.Manager_name;
        UpdateData.Manager_position = fromMain.Manager_position;
        UpdateData.Manager_phone = fromMain.Manager_phone;
        UpdateData.User_id_number = fromMain.User_id_number;
        UpdateData.User_name = fromMain.User_name;
        UpdateData.User_position = fromMain.User_position;
        UpdateData.User_phone = fromMain.User_phone;
        UpdateData.Use = fromMain.Use;
        UpdateData.TagNo = fromMain.TagNo;
        UpdateData.SerialNo = fromMain.SerialNo;
        UpdateData.Classification = fromMain.Classification;
        UpdateData.Spec = fromMain.Spec;
        UpdateData.Model = fromMain.Model;
        UpdateData.Maker = fromMain.Maker;
        UpdateData.Inch = fromMain.Inch;
        UpdateData.Cpu = fromMain.Cpu;
        UpdateData.Hdd = fromMain.Hdd;
        UpdateData.Memory = fromMain.Memory;
        UpdateData.Os = fromMain.Os;
        UpdateData.Current_state = fromMain.Current_state;
        UpdateData.Give_date = fromMain.Give_date;
        UpdateData.Buy_date = fromMain.Buy_date;
        UpdateData.Buy_year =fromMain.Buy_year;
        UpdateData.OA_check1 = fromMain.OA_check1;
        UpdateData.OA_check2 = fromMain.OA_check2;
        UpdateData.OA_check3 = fromMain.OA_check3;
        UpdateData.OA_check4 =fromMain.OA_check4;
        UpdateData.OA_check5 =fromMain.OA_check5;
        UpdateData.OA_check6 = fromMain.OA_check6;
        UpdateData.OA_check7 = fromMain.OA_check7;
        UpdateData.OA_check8 =fromMain.OA_check8;
        UpdateData.OA_check9 = fromMain.OA_check9;
        UpdateData.OA_check10 = fromMain.OA_check10;
        UpdateData.OA_check11 = fromMain.OA_check11;
        UpdateData.OA_check12 = fromMain.OA_check12;
        UpdateData.OA_check13 =fromMain.OA_check13;
        UpdateData.OA_check14 = fromMain.OA_check14;
        UpdateData.OA_check15 =fromMain.OA_check15;
        UpdateData.Check_date = fromMain.Check_date;
        UpdateData.Worker = fromMain.Worker;
        UpdateData.Is_checked = fromMain.Is_checked;


    }
}
