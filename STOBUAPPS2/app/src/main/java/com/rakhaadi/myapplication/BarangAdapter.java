package com.rakhaadi.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder>{

    List<barang> aBaranglis;

    public BarangAdapter(List<barang> modelbaranglist) {
        this.aBaranglis = modelbaranglist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itembarang,viewGroup,false);

        return new ViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvnamagenteng.setText(aBaranglis.get(i).getMenu());
        viewHolder.tvhargagenteng.setText(String.valueOf(aBaranglis.get(i).getHarga()));
        Glide.with(viewHolder.itemView.getContext())
                .load("" + aBaranglis.get(i).getGambar())
                .into(viewHolder.ivgenteng);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),deskripsibata.class);
                intent.putExtra("Judul",aBaranglis.get(i).getMenu());
                intent.putExtra("hargadetail",aBaranglis.get(i).getHarga());
//                intent.putExtra("Namatoko",aBaranglis.get(i).());
//                intent.putExtra("Rincianproduk",aBaranglis.get(i).());
                intent.putExtra("Gambar",aBaranglis.get(i).getGambar());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aBaranglis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivgenteng;
        TextView tvnamagenteng, tvhargagenteng;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivgenteng = itemView.findViewById(R.id.ivgenteng);
            tvnamagenteng = itemView.findViewById(R.id.tvnamagenteng);
            tvhargagenteng = itemView.findViewById(R.id.tvhargagenteng);
        }
    }
}
