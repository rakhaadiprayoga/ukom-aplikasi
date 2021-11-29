package com.rakhaadi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class screenawal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenawal);

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(screenawal.this, MainActivity.class));
//                finish();
//            }
//        };
//
//        Handler h = new Handler();
//        h.postDelayed(r,3000);


    }
    public void btnbuatakun(View view) {
        Intent intent = new Intent(this, buatakun.class);
        startActivity(intent);
    }

    public void tvmasuk(View view) {
        Intent intent = new Intent(this,sudahpunyaakunlogin.class);
        startActivity(intent);
    }
}