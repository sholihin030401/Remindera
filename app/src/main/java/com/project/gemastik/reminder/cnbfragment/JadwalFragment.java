package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.jadwal.AddJadwalActivity;

import org.joda.time.DateTime;


/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment implements DatePickerListener {

    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fabAddJadwal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddJadwalActivity.class);
                startActivity(intent);
            }
        });

        HorizontalPicker picker = view.findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(120)
                .setOffset(7)
                .setDateSelectedColor(getResources().getColor(R.color.colorPrimary))
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
                .showTodayButton(false)
                .init();

        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime());
        return view;
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {

    }
}
