package com.example.yoo.barcodescannerproject.common;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yoo on 2016-06-24.
 */
public class MyDB implements Parcelable {

    public String Install_area;     //설치 지역
    public String Install_location;//설치장소
    public String Detail_location;  //상세위치
    public String Section;
    public String Division;         //실서부
    public String Responsibility;
    public String Team;             //team
    public String Part;
    public String Manager_id_number;
    public String Manager_name;
    public String Manager_position;
    public String Manager_phone;
    public String User_id_number;
    public String User_name;
    public String User_position;
    public String User_phone;
    public String Use;
    public String TagNo;
    public String SerialNo;
    public String Classification; //장비구분
    public String Spec;
    public String Model;
    public String Maker;
    public String Inch;
    public String Cpu;  //CPU
    public String Hdd; //HDD
    public String Memory; //Memory
    public String Os;   //OS
    public String Current_state;
    public String Give_date;
    public String Buy_date;
    public String Buy_year;
    public String OA_check1;
    public String OA_check2;
    public String OA_check3;
    public String OA_check4;
    public String OA_check5;
    public String OA_check6;
    public String OA_check7;
    public String OA_check8;
    public String OA_check9;
    public String OA_check10;
    public String OA_check11;
    public String OA_check12;
    public String OA_check13;
    public String OA_check14;
    public String OA_check15;
    public String Check_date;
    public String Worker;
    public String Is_checked;

    public MyDB(){}

    public MyDB(String install_area, String install_location, String detail_location, String section, String division, String responsibility, String team, String part, String manager_id_number, String manager_name, String manager_position, String manager_phone, String user_id_number, String user_name, String user_position, String user_phone, String use, String tagNo, String serialNo, String classification, String spec, String model, String maker, String inch, String cpu, String hdd, String memory, String os, String current_state, String give_date, String buy_date, String buy_year, String OA_check1, String OA_check2, String OA_check3, String OA_check4, String OA_check5, String OA_check6, String OA_check7, String OA_check8, String OA_check9, String OA_check10, String OA_check11, String OA_check12, String OA_check13, String OA_check14, String OA_check15, String check_date, String worker, String Is_checked) {
        Install_area = install_area;
        Install_location = install_location;
        Detail_location = detail_location;
        Section = section;
        Division = division;
        Responsibility = responsibility;
        Team = team;
        Part = part;
        Manager_id_number = manager_id_number;
        Manager_name = manager_name;
        Manager_position = manager_position;
        Manager_phone = manager_phone;
        User_id_number = user_id_number;
        User_name = user_name;
        User_position = user_position;
        User_phone = user_phone;
        Use = use;
        TagNo = tagNo;
        SerialNo = serialNo;
        Classification = classification;
        Spec = spec;
        Model = model;
        Maker = maker;
        Inch = inch;
        Cpu = cpu;
        Hdd = hdd;
        Memory = memory;
        Os = os;
        Current_state = current_state;
        Give_date = give_date;
        Buy_date = buy_date;
        Buy_year = buy_year;
        this.OA_check1 = OA_check1;
        this.OA_check2 = OA_check2;
        this.OA_check3 = OA_check3;
        this.OA_check4 = OA_check4;
        this.OA_check5 = OA_check5;
        this.OA_check6 = OA_check6;
        this.OA_check7 = OA_check7;
        this.OA_check8 = OA_check8;
        this.OA_check9 = OA_check9;
        this.OA_check10 = OA_check10;
        this.OA_check11 = OA_check11;
        this.OA_check12 = OA_check12;
        this.OA_check13 = OA_check13;
        this.OA_check14 = OA_check14;
        this.OA_check15 = OA_check15;
        Check_date = check_date;
        Worker = worker;
        this.Is_checked = Is_checked;
    }
    public MyDB (Parcel in)
    {
        Install_area = in.readString();
        Install_location = in.readString();
        Detail_location = in.readString();
        Section = in.readString();
        Division = in.readString();
        Responsibility = in.readString();
        Team = in.readString();
        Part = in.readString();
        Manager_id_number = in.readString();
        Manager_name = in.readString();
        Manager_position = in.readString();
        Manager_phone = in.readString();
        User_id_number = in.readString();
        User_name = in.readString();
        User_position = in.readString();
        User_phone = in.readString();
        Use = in.readString();
        TagNo = in.readString();
        SerialNo = in.readString();
        Classification = in.readString();
        Spec = in.readString();
        Model = in.readString();
        Maker = in.readString();
        Inch = in.readString();
        Cpu = in.readString();
        Hdd = in.readString();
        Memory = in.readString();
        Os = in.readString();
        Current_state = in.readString();
        Give_date = in.readString();
        Buy_date = in.readString();
        Buy_year = in.readString();
        OA_check1 = in.readString();
        OA_check2 = in.readString();
        OA_check3 = in.readString();
        OA_check4 = in.readString();
        OA_check5 = in.readString();
        OA_check6 = in.readString();
        OA_check7 = in.readString();
        OA_check8 = in.readString();
        OA_check9 = in.readString();
        OA_check10 = in.readString();
        OA_check11 = in.readString();
        OA_check12 = in.readString();
        OA_check13 = in.readString();
        OA_check14 = in.readString();
        OA_check15 = in.readString();
        Check_date = in.readString();
        Worker = in.readString();
        Is_checked = in.readString();
    }

    public String getInstall_area() {
        return Install_area;
    }

    public String getInstall_location() {
        return Install_location;
    }

    public String getDetail_location() {
        return Detail_location;
    }

    public String getSection() {
        return Section;
    }

    public String getDivision() {
        return Division;
    }

    public String getResponsibility() {
        return Responsibility;
    }

    public String getTeam() {
        return Team;
    }

    public String getPart() {
        return Part;
    }

    public String getManager_id_number() {
        return Manager_id_number;
    }

    public String getManager_name() {
        return Manager_name;
    }

    public String getManager_position() {
        return Manager_position;
    }

    public String getManager_phone() {
        return Manager_phone;
    }

    public String getUser_id_number() {
        return User_id_number;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getUser_position() {
        return User_position;
    }

    public String getUser_phone() {
        return User_phone;
    }

    public String getUse() {
        return Use;
    }

    public String getTagNo() {
        return TagNo;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public String getClassification() {
        return Classification;
    }

    public String getSpec() {
        return Spec;
    }

    public String getModel() {
        return Model;
    }

    public String getMaker() {
        return Maker;
    }

    public String getInch() {
        return Inch;
    }

    public String getCpu() {
        return Cpu;
    }

    public String getHdd() {
        return Hdd;
    }

    public String getMemory() {
        return Memory;
    }

    public String getOs() {
        return Os;
    }

    public String getCurrent_state() {
        return Current_state;
    }

    public String getGive_date() {
        return Give_date;
    }

    public String getBuy_date() {
        return Buy_date;
    }

    public String getBuy_year() {
        return Buy_year;
    }

    public String getOA_check1() {
        return OA_check1;
    }

    public String getOA_check2() {
        return OA_check2;
    }

    public String getOA_check3() {
        return OA_check3;
    }

    public String getOA_check4() {
        return OA_check4;
    }

    public String getOA_check5() {
        return OA_check5;
    }

    public String getOA_check6() {
        return OA_check6;
    }

    public String getOA_check7() {
        return OA_check7;
    }

    public String getOA_check8() {
        return OA_check8;
    }

    public String getOA_check9() {
        return OA_check9;
    }

    public String getOA_check10() {
        return OA_check10;
    }

    public String getOA_check11() {
        return OA_check11;
    }

    public String getOA_check12() {
        return OA_check12;
    }

    public String getOA_check13() {
        return OA_check13;
    }

    public String getOA_check14() {
        return OA_check14;
    }

    public String getOA_check15() {
        return OA_check15;
    }

    public String getCheck_date() {
        return Check_date;
    }

    public String getWorker() {
        return Worker;
    }

    public String getIs_checked() {
        return Is_checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Install_area);
        dest.writeString(Install_location);
        dest.writeString(Detail_location);
        dest.writeString(Section);
        dest.writeString(Division);
        dest.writeString(Responsibility);
        dest.writeString(Team);
        dest.writeString(Part);
        dest.writeString(Manager_id_number);
        dest.writeString(Manager_name);
        dest.writeString(Manager_position);
        dest.writeString(Manager_phone);
        dest.writeString(User_id_number);
        dest.writeString(User_name);
        dest.writeString(User_position);
        dest.writeString(User_phone);
        dest.writeString(Use);
        dest.writeString(TagNo);
        dest.writeString(SerialNo);
        dest.writeString(Classification);
        dest.writeString(Spec);
        dest.writeString(Model);
        dest.writeString(Maker);
        dest.writeString(Inch);
        dest.writeString(Cpu);
        dest.writeString(Hdd);
        dest.writeString(Memory);
        dest.writeString(Os);
        dest.writeString(Current_state);
        dest.writeString(Give_date);
        dest.writeString(Buy_date);
        dest.writeString(Buy_year);
        dest.writeString(OA_check1);
        dest.writeString(OA_check2);
        dest.writeString(OA_check3);
        dest.writeString(OA_check4);
        dest.writeString(OA_check5);
        dest.writeString(OA_check6);
        dest.writeString(OA_check7);
        dest.writeString(OA_check8);
        dest.writeString(OA_check9);
        dest.writeString(OA_check10);
        dest.writeString(OA_check11);
        dest.writeString(OA_check12);
        dest.writeString(OA_check13);
        dest.writeString(OA_check14);
        dest.writeString(OA_check15);
        dest.writeString(Check_date);
        dest.writeString(Worker);
        dest.writeString(Is_checked);
    }
    private void readFromParcel(Parcel in)
    {
        Install_area = in.readString();
        Install_location = in.readString();
        Detail_location = in.readString();
        Section = in.readString();
        Division = in.readString();
        Responsibility = in.readString();
        Team = in.readString();
        Part = in.readString();
        Manager_id_number = in.readString();
        Manager_name = in.readString();
        Manager_position = in.readString();
        Manager_phone = in.readString();
        User_id_number = in.readString();
        User_name = in.readString();
        User_position = in.readString();
        User_phone = in.readString();
        Use = in.readString();
        TagNo = in.readString();
        SerialNo = in.readString();
        Classification = in.readString();
        Spec = in.readString();
        Model = in.readString();
        Maker = in.readString();
        Inch = in.readString();
        Cpu = in.readString();
        Hdd = in.readString();
        Memory = in.readString();
        Os = in.readString();
        Current_state = in.readString();
        Give_date = in.readString();
        Buy_date = in.readString();
        Buy_year = in.readString();
        OA_check1 = in.readString();
        OA_check2 = in.readString();
        OA_check3 = in.readString();
        OA_check4 = in.readString();
        OA_check5 = in.readString();
        OA_check6 = in.readString();
        OA_check7 = in.readString();
        OA_check8 = in.readString();
        OA_check9 = in.readString();
        OA_check10 = in.readString();
        OA_check11 = in.readString();
        OA_check12 = in.readString();
        OA_check13 = in.readString();
        OA_check14 = in.readString();
        OA_check15 = in.readString();
        Check_date = in.readString();
        Worker = in.readString();
        Is_checked = in.readString();
    }

    public static final Parcelable.Creator<MyDB> CREATOR = new Parcelable.Creator<MyDB>(){

        @Override
        public MyDB createFromParcel(Parcel source) {
            return new MyDB(source);
        }

        @Override
        public MyDB[] newArray(int size) {
            return new MyDB[size];
        }
    };
}
