package com.example.quranfinalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyVH>{

    List<ItemDetails> items;

    public MyRecyclerViewAdapter(List<ItemDetails> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.name_detail_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=items.get(position);
        holder.textViewNumber.setText(String.valueOf(holder.data.getNumber()));
        holder.textViewEnglishName.setText(holder.data.getEnglishName());
        holder.textViewArabicName.setText(holder.data.getArabicName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewNumber;
        TextView textViewArabicName;
        TextView textViewEnglishName;
        ItemDetails data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.item_number);
            textViewArabicName = itemView.findViewById(R.id.item_arabic_name);
            textViewEnglishName = itemView.findViewById(R.id.item_english_name);
        }
    }
}
