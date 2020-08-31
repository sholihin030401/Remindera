package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.impian.AddImpianActivity;
import com.project.gemastik.reminder.impian.AktifFragment;
import com.project.gemastik.reminder.impian.TercapaiFragment;
import com.project.gemastik.reminder.impian.ViewPagerImpian;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImpianFragment extends Fragment {

    public ImpianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFrag = inflater.inflate(R.layout.fragment_impian, container, false);

        return viewFrag;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.viewpager_impian);
        TabLayout tabLayout = view.findViewById(R.id.tab_impian);
        FloatingActionButton fab = view.findViewById(R.id.fabAddImpian);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intents = new Intent(getActivity(), AddImpianActivity.class);
               startActivity(intents);
            }
        });

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerImpian adapter = new ViewPagerImpian(getChildFragmentManager());

        adapter.addFrag(new AktifFragment(),"Aktif");
        adapter.addFrag(new TercapaiFragment(),"Tercapai");

        viewPager.setAdapter(adapter);
    }
}
