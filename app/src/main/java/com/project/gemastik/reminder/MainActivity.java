package com.project.gemastik.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.project.gemastik.reminder.cnbfragment.MotivasiFragment;
import com.project.gemastik.reminder.cnbfragment.ImpianFragment;
import com.project.gemastik.reminder.cnbfragment.JadwalFragment;
import com.project.gemastik.reminder.cnbfragment.ProfilFragment;
import com.project.gemastik.reminder.verify.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.chipbar);

        if (savedInstanceState == null){
            chipNavigationBar.setItemSelected(R.id.jadwal, true);
            fragmentManager = getSupportFragmentManager();
            JadwalFragment jadwalFragment = new JadwalFragment();
            fragmentManager.beginTransaction().replace(R.id.container, jadwalFragment).commit();
        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragments = null;

                switch (id){
                    case R.id.jadwal:
                        fragments = new JadwalFragment();
                        break;
                    case R.id.impian:
                        fragments = new ImpianFragment();
                        break;
                    case R.id.artikel:
                        fragments = new MotivasiFragment();
                        break;
                    case R.id.profile:
                        fragments = new ProfilFragment();
                        break;
                }

                if (fragments != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container,fragments).commit();
                }
            }
        });
    }

}