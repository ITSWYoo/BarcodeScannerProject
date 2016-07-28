package com.example.yoo.barcodescannerproject.common;

import android.provider.BaseColumns;

/**
 * Created by Yoo on 2016-06-24.
 */
public class MyDBConstant {
    public interface MyDBTable extends BaseColumns{
        public static final String INVENTORYTABLE = "InventoryTable";
        public static final String USERDATATABLE = "UserDataTable";

        public static final String INSTALL_AREA = "Install_area";       // 설치 지역
        public static final String INSTALL_LOCATION = "Install_location";   //설치장소
        public static final String DETAIL_LOCATION = "Detail_location"; //상세위치
        public static final String SECTION = "Section";                 //부문
        public static final String DIVISION = "Division";               //실서부
        public static final String RESPONSIBILITY = "Responsibility"; //담당
        public static final String TEAM = "Team";                       //team
        public static final String PART = "Part";                       //파트

        public static final String MANAGER_ID_NUMBER = "Manager_id_number";  //관리자 사번
        public static final String MANAGER_NAME = "Manager_name";               //관리자 이름
        public static final String MANAGER_POSITION = "Manager_position";       //관리자 직급
        public static final String MANAGER_PHONE = "Manager_phone";             //관리자 전화번호

        public static final String USER_ID_NUMBER = "User_id_number";       //사용자 사번
        public static final String USER_NAME = "User_name";                 //사용자 이름
        public static final String USER_POSITION = "User_position";         //사용자 직급
        public static final String USER_PHONE = "User_phone";               //사용자 전화번호

        public static final String USE = "Use";                             //용도
        public static final String TAGNO = "TagNo";                         //태그 번호
        public static final String SERIALNO = "SerialNo";                   //시리얼 번호
        public static final String CLASSIFICATION ="Classification";       //장비구분
        public static final String SPEC = "Spec";                           //사양
        public static final String MODEL = "Model";                         //제품명
        public static final String MAKER = "Maker";                         //제조사
        public static final String INCH = "Inch";                           //인치
        public static final String CPU = "CPU";                             //CPU
        public static final String HDD = "HDD";                             //HDD
        public static final String MEMORY ="Memory";                        //Memory
        public static final String OS = "OS";                               //OS
        public static final String CURRENT_STATE = "Current_state";     //현재상태
        public static final String GIVE_DATE = "Give_date";             //지급일자
        public static final String BUY_DATE = "Buy_date";               //구매일자
        public static final String BUY_YEAR = "Buy_year";               //구매년
        public static final String OA_CHECK1 = "OA_check1";             //점검1
        public static final String OA_CHECK2 = "OA_check2";
        public static final String OA_CHECK3 = "OA_check3";
        public static final String OA_CHECK4 = "OA_check4";
        public static final String OA_CHECK5 = "OA_check5";
        public static final String OA_CHECK6 = "OA_check6";
        public static final String OA_CHECK7 = "OA_check7";
        public static final String OA_CHECK8 = "OA_check8";
        public static final String OA_CHECK9 = "OA_check9";
        public static final String OA_CHECK10 = "OA_check10";
        public static final String OA_CHECK11 = "OA_check11";
        public static final String OA_CHECK12 = "OA_check12";
        public static final String OA_CHECK13 = "OA_check13";
        public static final String OA_CHECK14 = "OA_check14";
        public static final String OA_CHECK15 = "OA_check15";
        public static final String CHECK_DATE = "Check_date";           //작업일자
        public static final String WORKER = "Worker";                   //작업자
        public static final String IS_CHECKED = "Is_checked";                      //실사유무


        //public static final String
    }
}
