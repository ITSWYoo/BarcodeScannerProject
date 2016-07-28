package com.example.yoo.barcodescannerproject.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yoo.barcodescannerproject.R;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.UpdateData;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipmentInfoFragment extends Fragment {
    static Spinner spinner_spec, spinner_os;
    static ArrayAdapter<CharSequence> mAdapter_spec, mAdapter_os;
    static EditText equipFragment_editText_tagNo, equipFragment_editText_serialNo, equipFragment_editText_model;
    static EditText equipFragment_editText_HDD ,equipFragment_editText_Memory, equipFragment_editText_CPU;
    static Bundle b;

    public EquipmentInfoFragment() {
        // Required empty public constructor
    }
    public static void getInfo()
    {
        UpdateData.TagNo = equipFragment_editText_tagNo.getText().toString();
        UpdateData.SerialNo = equipFragment_editText_serialNo.getText().toString();
        UpdateData.Model = equipFragment_editText_model.getText().toString();
        UpdateData.Hdd = equipFragment_editText_HDD.getText().toString();
        UpdateData.Memory = equipFragment_editText_Memory.getText().toString();
        UpdateData.Cpu = equipFragment_editText_CPU.getText().toString();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_equipment_info, container, false);
        b = getArguments();
        MyDB equip = b.getParcelable("Equipment");

        equipFragment_editText_tagNo = (EditText)v.findViewById(R.id.equipFragment_editText_tagNo);
        equipFragment_editText_tagNo.setText(equip.getTagNo());


        equipFragment_editText_serialNo = (EditText)v.findViewById(R.id.equipFragment_editText_serialNo);
        equipFragment_editText_serialNo.setText(equip.getSerialNo());

        equipFragment_editText_model = (EditText)v.findViewById(R.id.equipFragment_editText_model);
        equipFragment_editText_model.setText(equip.getModel());

        equipFragment_editText_HDD = (EditText)v.findViewById(R.id.equipFragment_editText_HDD);
        equipFragment_editText_HDD.setText(equip.getHdd());

        equipFragment_editText_Memory = (EditText)v.findViewById(R.id.equipFragment_editText_Memory);
        equipFragment_editText_Memory.setText(equip.getMemory());

        equipFragment_editText_CPU = (EditText)v.findViewById(R.id.equipFragment_editText_CPU);
        equipFragment_editText_CPU.setText(equip.getCpu());

        spinner_spec = (Spinner)v.findViewById(R.id.spinner_spec);
        mAdapter_spec = ArrayAdapter.createFromResource(getContext(),R.array.spec, android.R.layout.simple_spinner_item);
        mAdapter_spec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_spec.setAdapter(mAdapter_spec);

        String spinner_specStr[] = {"Desktop","Notebook","Monitor","Laser","Sub-Notebook","고속SCANNER","DOT","INKJET","고속Laser","바코드프린터","복합기","Color LASER"};

        for(int i = 0; i<spinner_specStr.length; i++)
        {
            if(spinner_specStr[i].equals(equip.getSpec()))
            {
                spinner_spec.setSelection(i);
            }
        }
        spinner_spec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_os = (Spinner)v.findViewById(R.id.spinner_os);
        mAdapter_os = ArrayAdapter.createFromResource(getContext(),R.array.os, android.R.layout.simple_spinner_item);
        mAdapter_os.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_os.setAdapter(mAdapter_os);
        String spinner_osStr[]={"","WIN 7", "WinXP","리눅스","IOS","Win2k","WIN 10"};
        if(equip.getOs()==null)
        {
            spinner_os.setSelection(0);
        }
        else {
            for (int i = 0; i < spinner_osStr.length; i++) {
                if (spinner_osStr[i].equals(equip.getOs())) {
                    spinner_os.setSelection(i);
                }
            }
        }
        spinner_os.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getInfo();
        return v;
    }

}
