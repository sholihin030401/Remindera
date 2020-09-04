package com.project.gemastik.reminder.impian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.gemastik.reminder.R;

import java.util.ArrayList;
import java.util.List;

public class KebiasaanAdapter extends RecyclerView.Adapter<KebiasaanAdapter.KebiasaanHolder> {

    List<KebiasaanItem> items;

    public KebiasaanAdapter(List<KebiasaanItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public KebiasaanAdapter.KebiasaanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_habits_item,parent,false);

        return new KebiasaanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KebiasaanAdapter.KebiasaanHolder holder, int position) {
        KebiasaanItem kebiasaanItem = items.get(position);
        holder.kebiasaan.setText(kebiasaanItem.getTextHabits());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class KebiasaanHolder extends RecyclerView.ViewHolder {

        TextView kebiasaan;

        public KebiasaanHolder(@NonNull View itemView) {
            super(itemView);

            kebiasaan = itemView.findViewById(R.id.habits_item);
        }
    }
}
