package com.project.gemastik.reminder.impian;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.project.gemastik.reminder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogAddTercapaiFragment extends DialogFragment {

    public DialogAddTercapaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_add_tercapai, container, false);

        final DialogAddTercapaiFragment fragment = new DialogAddTercapaiFragment();

        ImageButton btnClose = view.findViewById(R.id.btn_close_dialog);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.dismiss();
            }
        });

        return view;
    }
}
