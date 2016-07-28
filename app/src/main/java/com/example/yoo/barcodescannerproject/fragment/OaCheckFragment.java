package com.example.yoo.barcodescannerproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.yoo.barcodescannerproject.R;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.UpdateData;

/**
 * A simple {@link Fragment} subclass.
 */
public class OaCheckFragment extends Fragment {
    static RadioGroup OAcheckFragmnet_radioGroup_check1 , OAcheckFragmnet_radioGroup_check2, OAcheckFragmnet_radioGroup_check3, OAcheckFragmnet_radioGroup_check4, OAcheckFragmnet_radioGroup_check5;
    static RadioGroup OAcheckFragmnet_radioGroup_check6, OAcheckFragmnet_radioGroup_check7, OAcheckFragmnet_radioGroup_check8 , OAcheckFragmnet_radioGroup_check9, OAcheckFragmnet_radioGroup_check10;
    static RadioGroup OAcheckFragmnet_radioGroup_check11, OAcheckFragmnet_radioGroup_check12, OAcheckFragmnet_radioGroup_check13, OAcheckFragmnet_radioGroup_check14, OAcheckFragmnet_radioGroup_check15;
    Bundle b;
    MyDB check;

    public OaCheckFragment() {
        // Required empty public constructor
    }
    public static void getInfo()
    {
        if(OAcheckFragmnet_radioGroup_check1.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check1_yes)
            UpdateData.OA_check1 ="yes";
        else
            UpdateData.OA_check1 = "no";

        if(OAcheckFragmnet_radioGroup_check2.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check2_yes)
            UpdateData.OA_check2 ="yes";
        else
            UpdateData.OA_check2 = "no";

        if(OAcheckFragmnet_radioGroup_check3.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check3_yes)
            UpdateData.OA_check3 ="yes";
        else
            UpdateData.OA_check3 = "no";

        if(OAcheckFragmnet_radioGroup_check4.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check4_yes)
            UpdateData.OA_check4 ="yes";
        else
            UpdateData.OA_check4 = "no";

        if(OAcheckFragmnet_radioGroup_check5.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check5_yes)
            UpdateData.OA_check5 ="yes";
        else
            UpdateData.OA_check5 = "no";

        if(OAcheckFragmnet_radioGroup_check6.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check6_yes)
            UpdateData.OA_check6 ="yes";
        else
            UpdateData.OA_check6 = "no";

        if(OAcheckFragmnet_radioGroup_check7.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check7_yes)
            UpdateData.OA_check7 ="yes";
        else
            UpdateData.OA_check7 = "no";

        if(OAcheckFragmnet_radioGroup_check8.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check8_yes)
            UpdateData.OA_check8 ="yes";
        else
            UpdateData.OA_check8 = "no";

        if(OAcheckFragmnet_radioGroup_check9.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check9_yes)
            UpdateData.OA_check9 ="yes";
        else
            UpdateData.OA_check9 = "no";

        if(OAcheckFragmnet_radioGroup_check10.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check10_yes)
            UpdateData.OA_check10 ="yes";
        else
            UpdateData.OA_check10 = "no";

        if(OAcheckFragmnet_radioGroup_check11.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check11_yes)
            UpdateData.OA_check11 ="yes";
        else
            UpdateData.OA_check11 = "no";

        if(OAcheckFragmnet_radioGroup_check12.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check12_yes)
            UpdateData.OA_check12 ="yes";
        else
            UpdateData.OA_check12 = "no";

        if(OAcheckFragmnet_radioGroup_check13.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check13_yes)
            UpdateData.OA_check13 ="yes";
        else
            UpdateData.OA_check13 = "no";

        if(OAcheckFragmnet_radioGroup_check14.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check14_yes)
            UpdateData.OA_check14 ="yes";
        else
            UpdateData.OA_check14 = "no";

        if(OAcheckFragmnet_radioGroup_check15.getCheckedRadioButtonId()==R.id.OAcheckFragmnet_radioButton_check15_yes)
            UpdateData.OA_check15 ="yes";
        else
            UpdateData.OA_check15 = "no";

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_oa_check, container, false);
        b = getArguments();
        check = b.getParcelable("OaCheck");

        OAcheckFragmnet_radioGroup_check1 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check1);
        if(check.getOA_check1() !=null &&check.getOA_check1().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check1.check(R.id.OAcheckFragmnet_radioButton_check1_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check1.check(R.id.OAcheckFragmnet_radioButton_check1_no);
        }
        OAcheckFragmnet_radioGroup_check1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check1_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check1_no)
                {}
            }
        });


        OAcheckFragmnet_radioGroup_check2 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check2);
        if(check.getOA_check2() !=null &&check.getOA_check2().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check2.check(R.id.OAcheckFragmnet_radioButton_check2_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check2.check(R.id.OAcheckFragmnet_radioButton_check2_no);
        }
        OAcheckFragmnet_radioGroup_check2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check2_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check2_no)
                {}
            }
        });

        OAcheckFragmnet_radioGroup_check3 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check3);
        if(check.getOA_check3() !=null &&check.getOA_check3() !=null &&check.getOA_check3().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check3.check(R.id.OAcheckFragmnet_radioButton_check3_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check3.check(R.id.OAcheckFragmnet_radioButton_check3_no);
        }
        OAcheckFragmnet_radioGroup_check3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check3_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check3_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check4 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check4);
        if(check.getOA_check4() !=null &&check.getOA_check4().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check4.check(R.id.OAcheckFragmnet_radioButton_check4_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check4.check(R.id.OAcheckFragmnet_radioButton_check4_no);
        }
        OAcheckFragmnet_radioGroup_check4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check4_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check4_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check5 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check5);
        if(check.getOA_check5() !=null &&check.getOA_check5().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check5.check(R.id.OAcheckFragmnet_radioButton_check5_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check5.check(R.id.OAcheckFragmnet_radioButton_check5_no);
        }
        OAcheckFragmnet_radioGroup_check5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check5_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check5_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check6 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check6);
        if(check.getOA_check6() !=null &&check.getOA_check6() !=null &&check.getOA_check6().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check6.check(R.id.OAcheckFragmnet_radioButton_check6_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check6.check(R.id.OAcheckFragmnet_radioButton_check6_no);
        }
        OAcheckFragmnet_radioGroup_check6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check6_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check6_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check7 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check7);
        if(check.getOA_check7() !=null &&check.getOA_check7().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check7.check(R.id.OAcheckFragmnet_radioButton_check7_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check7.check(R.id.OAcheckFragmnet_radioButton_check7_no);
        }
        OAcheckFragmnet_radioGroup_check7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check7_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check7_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check8 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check8);
        if(check.getOA_check8() !=null &&check.getOA_check8().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check8.check(R.id.OAcheckFragmnet_radioButton_check8_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check8.check(R.id.OAcheckFragmnet_radioButton_check8_no);
        }
        OAcheckFragmnet_radioGroup_check8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check8_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check8_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check9 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check9);
        if(check.getOA_check9() !=null &&check.getOA_check9().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check9.check(R.id.OAcheckFragmnet_radioButton_check9_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check9.check(R.id.OAcheckFragmnet_radioButton_check9_no);
        }
        OAcheckFragmnet_radioGroup_check9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check9_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check9_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check10 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check10);
        if(check.getOA_check10() !=null &&check.getOA_check10().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check10.check(R.id.OAcheckFragmnet_radioButton_check10_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check10.check(R.id.OAcheckFragmnet_radioButton_check10_no);
        }
        OAcheckFragmnet_radioGroup_check10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check10_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check10_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check11 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check11);
        if(check.getOA_check11() !=null &&check.getOA_check11().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check11.check(R.id.OAcheckFragmnet_radioButton_check11_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check11.check(R.id.OAcheckFragmnet_radioButton_check11_no);
        }
        OAcheckFragmnet_radioGroup_check11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check11_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check11_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check12 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check12);
        if(check.getOA_check12() !=null &&check.getOA_check12().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check12.check(R.id.OAcheckFragmnet_radioButton_check12_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check12.check(R.id.OAcheckFragmnet_radioButton_check12_no);
        }
        OAcheckFragmnet_radioGroup_check12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check12_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check12_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check13 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check13);
        if(check.getOA_check13() !=null &&check.getOA_check13().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check13.check(R.id.OAcheckFragmnet_radioButton_check13_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check13.check(R.id.OAcheckFragmnet_radioButton_check13_no);
        }
        OAcheckFragmnet_radioGroup_check13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check13_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check13_no)
                {}
            }
        });
        OAcheckFragmnet_radioGroup_check14 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check14);
        if(check.getOA_check14() !=null &&check.getOA_check14().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check14.check(R.id.OAcheckFragmnet_radioButton_check14_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check14.check(R.id.OAcheckFragmnet_radioButton_check14_no);
        }
        OAcheckFragmnet_radioGroup_check14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check14_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check14_no)
                {}
            }
        });

        OAcheckFragmnet_radioGroup_check15 = (RadioGroup)v.findViewById(R.id.OAcheckFragmnet_radioGroup_check15);
        if(check.getOA_check15() !=null &&check.getOA_check15().equals("yes"))
        {
            OAcheckFragmnet_radioGroup_check15.check(R.id.OAcheckFragmnet_radioButton_check15_yes);
        }
        else
        {
            OAcheckFragmnet_radioGroup_check15.check(R.id.OAcheckFragmnet_radioButton_check15_no);
        }
        OAcheckFragmnet_radioGroup_check15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId ==R.id.OAcheckFragmnet_radioButton_check15_yes)
                {}
                else if(checkedId ==R.id.OAcheckFragmnet_radioButton_check15_no)
                {}
            }
        });
        getInfo();
        return v;
    }
}
