package com.project.gemastik.reminder.literasi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.gemastik.reminder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {

    RecyclerView recyclerView;
    List<ArtikelItem> itemList;

    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artikel, container, false);

        recyclerView = view.findViewById(R.id.rv_artikel);

        ArtikelAdapter adapter = new ArtikelAdapter(itemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        dataArtikel();

        return view;
    }

    private void dataArtikel(){
        itemList = new ArrayList<>();
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
    }
}
