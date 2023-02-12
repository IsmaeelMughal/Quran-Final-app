package com.example.quranfinalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AyatRVAdapter extends RecyclerView.Adapter<AyatRVAdapter.MyAyatVH>{

    List<String> ayats;

    public AyatRVAdapter(List<String> ayats) {
        this.ayats = ayats;
    }

    @NonNull
    @Override
    public MyAyatVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ayat_item, parent, false);
        return new AyatRVAdapter.MyAyatVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAyatVH holder, int position) {
        holder.ayat.setText(ayats.get(position));
    }

    @Override
    public int getItemCount() {
        return ayats.size();
    }

    public class MyAyatVH extends RecyclerView.ViewHolder {
        TextView ayat;
        public MyAyatVH(@NonNull View itemView) {
            super(itemView);
            ayat = itemView.findViewById(R.id.ayat);
        }
    }
}
