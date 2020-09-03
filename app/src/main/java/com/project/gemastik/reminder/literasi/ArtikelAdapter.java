package com.project.gemastik.reminder.literasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.gemastik.reminder.R;

import java.util.List;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ArtikelHolder> {

    private static final String TAG = "ArtikelAdapter";
    List<ArtikelItem> artikelItemList;


    public ArtikelAdapter(List<ArtikelItem> artikelItemList) {
        this.artikelItemList = artikelItemList;
    }

    @NonNull
    @Override
    public ArtikelAdapter.ArtikelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artikel_item,parent,false);

        return new ArtikelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelAdapter.ArtikelHolder holder, int position) {
        ArtikelItem artikelItem = artikelItemList.get(position);
        holder.title.setText(artikelItem.getNamaEbook());
        holder.kategori.setText(artikelItem.getKategori());
        Glide.with(holder.itemView.getContext())
                .load(artikelItem.getPosterEbook())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return artikelItemList.size();
    }

    public class ArtikelHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ArtikelHolder";
        ImageView imageView;
        TextView title, kategori;

        public ArtikelHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.judul_ebook);
            kategori = itemView.findViewById(R.id.kat_ebook);
            imageView = itemView.findViewById(R.id.poster_ebook);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context,ArtikelDetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
