package com.project.gemastik.reminder.impian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.gemastik.reminder.R;

import java.util.ArrayList;

public class HabitsAdapter extends RecyclerView.Adapter<HabitsAdapter.HabitsHolder> {

    ArrayList<HabitsItem> items;

    public HabitsAdapter(ArrayList<HabitsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HabitsAdapter.HabitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_habits_item,parent,false);

        return new HabitsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitsAdapter.HabitsHolder holder, int position) {
        HabitsItem habitsItem = items.get(position);
        holder.kebiasaan.setText(habitsItem.getTextHabits());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class HabitsHolder extends RecyclerView.ViewHolder {
        TextView kebiasaan;
        public HabitsHolder(@NonNull View itemView) {
            super(itemView);

            kebiasaan = itemView.findViewById(R.id.habits_item);

        }
    }
}
