package com.example.yoo.barcodescannerproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yoo.barcodescannerproject.R;
import com.example.yoo.barcodescannerproject.common.MyDB;
import com.example.yoo.barcodescannerproject.common.UpdateData;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationInfoFragment extends Fragment {
    static EditText locationFragment_editText_install_location,locationFragment_editText_install_area,locationFragment_editText_detail_location;
    static EditText locationFragment_editText_section, locationFragment_editText_division, locationFragment_editText_responsibility, locationFragment_editText_team, locationFragment_editText_part;
    static Bundle b;
    static MyDB location;

    public LocationInfoFragment() {
        // Required empty public constructor
    }

    public static void getInfo()
    {
        UpdateData.Install_location = locationFragment_editText_install_location.getText().toString();
        UpdateData.Install_area = locationFragment_editText_install_area.getText().toString();
        UpdateData.Detail_location = locationFragment_editText_detail_location.getText().toString();
        UpdateData.Section = locationFragment_editText_section.getText().toString();
        UpdateData.Division = locationFragment_editText_division.getText().toString();
        UpdateData.Responsibility = locationFragment_editText_responsibility.getText().toString();
        UpdateData.Team = locationFragment_editText_team.getText().toString();
        UpdateData.Part = locationFragment_editText_part.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        b = getArguments();
        location = b.getParcelable("LocationInfo");

        View v= inflater.inflate(R.layout.fragment_location_info, container, false);
        locationFragment_editText_install_location = (EditText)v.findViewById(R.id.locationFragment_editText_install_location);
        locationFragment_editText_install_location.setText(location.getInstall_location());

        locationFragment_editText_install_area = (EditText)v.findViewById(R.id.locationFragment_editText_install_area);
        locationFragment_editText_install_area.setText(location.getInstall_area());

        locationFragment_editText_detail_location = (EditText)v.findViewById(R.id.locationFragment_editText_detail_location);
        locationFragment_editText_detail_location.setText(location.getDetail_location());

        locationFragment_editText_section = (EditText)v.findViewById(R.id.locationFragment_editText_section);
        locationFragment_editText_section.setText(location.getSection());

        locationFragment_editText_division = (EditText)v.findViewById(R.id.locationFragment_editText_division);
        locationFragment_editText_division.setText(location.getDivision());

        locationFragment_editText_responsibility = (EditText)v.findViewById(R.id.locationFragment_editText_responsibility);
        locationFragment_editText_responsibility.setText(location.getResponsibility());

        locationFragment_editText_team =(EditText)v.findViewById(R.id.locationFragment_editText_team);
        locationFragment_editText_team.setText(location.getTeam());

        locationFragment_editText_part = (EditText)v.findViewById(R.id.locationFragment_editText_part);
        locationFragment_editText_part.setText(location.getPart());

        getInfo();
        return v;
    }

}
