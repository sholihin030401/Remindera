package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.verify.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    TextView btnLogout;
    TextView txEmail, txUsername;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        btnLogout = view.findViewById(R.id.txlogout);
        txEmail = view.findViewById(R.id.mailProfile);

        String users = this.getArguments().getString("username");

        txUsername = view.findViewById(R.id.userProfile);
        txUsername.setText(users);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        txEmail.setText(mUser.getEmail());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
