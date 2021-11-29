package com.rakhaadi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class deskripsibata extends AppCompatActivity {

    ImageView ivdetail;
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsibata);

        Intent mIntent = getIntent();
        ivdetail = (ImageView) findViewById(R.id.ivdetail);
        tv1 = (TextView) findViewById(R.id.tvjudul);
        tv2 = (TextView) findViewById(R.id.tvhargadetail);
        tv3 = (TextView) findViewById(R.id.tvnamatoko);
        tv4 = (TextView) findViewById(R.id.tvrincianproduk);

        tv1.setText(mIntent.getStringExtra("Judul"));
        tv2.setText(Integer.toString(mIntent.getIntExtra("hargadetail", 0)));
        tv3.setText(mIntent.getStringExtra("Namatoko"));
        tv4.setText(mIntent.getStringExtra("Rincianproduk"));

        Glide.with(deskripsibata.this)
                .load(""+ mIntent.getStringExtra("Gambar"))
                .into(ivdetail);
    }


    public void btnpesansekarang(View view) {
        Intent intent = new Intent(this, formpemesanan.class);
        startActivity(intent);
    }
}