package com.project.gemastik.reminder.jadwal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.project.gemastik.reminder.R;

public class AddJadwalActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jadwal);

        tabLayout = findViewById(R.id.tabjadwal);
        frameLayout = findViewById(R.id.frame_jadwal);

        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        ftrans.replace(R.id.frame_jadwal,new AgendaFragment());
        ftrans.commit();
        tabNew();
    }

    private void tabNew(){

        TabLayout.Tab tabSatu = tabLayout.newTab();
        tabSatu.setText("Agenda");
        tabSatu.setIcon(R.drawable.ic_today);
        tabLayout.addTab(tabSatu);

        TabLayout.Tab tabDua = tabLayout.newTab();
        tabDua.setText("Ulang Tahun");
        tabDua.setIcon(R.drawable.ic_birthday);
        tabLayout.addTab(tabDua);

        TabLayout.Tab tabTiga = tabLayout.newTab();
        tabTiga.setText("Peringatan");
        tabTiga.setIcon(R.drawable.ic_favorite_black_24dp);
        tabLayout.addTab(tabTiga);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new AgendaFragment();
                        break;
                    case 1:
                        fragment = new UltahFragment();
                        break;
                    case 2:
                        fragment = new PeringatanFragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_jadwal, fragment);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
