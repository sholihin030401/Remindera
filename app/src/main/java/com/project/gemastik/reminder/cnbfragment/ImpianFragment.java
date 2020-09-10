package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.impian.AddImpianActivity;
import com.project.gemastik.reminder.impian.ImpianAdapter;
import com.project.gemastik.reminder.impian.ImpianItem;
import com.project.gemastik.reminder.impian.TipsFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImpianFragment extends Fragment {

    public static String DATA_LIST = "data_list";

    CardView btn_goals;
    RecyclerView rv_impian;
    private ArrayList<ImpianItem> list = new ArrayList<>();
    public ImpianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFrag = inflater.inflate(R.layout.fragment_impian, container, false);

        FloatingActionButton fab = viewFrag.findViewById(R.id.fabAddImpian);

        rv_impian = viewFrag.findViewById(R.id.rv_impian);
        rv_impian.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        list = (ArrayList<ImpianItem>) getArguments().getSerializable("Data");
        ImpianAdapter adapter = new ImpianAdapter(list, getContext());
        rv_impian.setLayoutManager(manager);
        rv_impian.setAdapter(adapter);

        btn_goals = viewFrag.findViewById(R.id.ask_goals);
        btn_goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipsFragment fragment = new TipsFragment();
                fragment.show(getChildFragmentManager(),"FragmentTips");
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddImpianActivity.class);
                startActivity(intent);
            }
        });
        return viewFrag;
    }
}
