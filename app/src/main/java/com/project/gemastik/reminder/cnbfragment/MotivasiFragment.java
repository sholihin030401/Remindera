package com.project.gemastik.reminder.cnbfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.motivasi.ArtikelFragment;
import com.project.gemastik.reminder.motivasi.VideoFragment;
import com.project.gemastik.reminder.motivasi.ViewPagerArtikel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotivasiFragment extends Fragment {

    public MotivasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motivasi, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.viewpager_artikel);
        TabLayout tabLayout = view.findViewById(R.id.tab_artikel);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerArtikel pager = new ViewPagerArtikel(getChildFragmentManager());

        pager.addFragment(new ArtikelFragment(), "Artikel");
        pager.addFragment(new VideoFragment(),"Video");

        viewPager.setAdapter(pager);
    }
}
