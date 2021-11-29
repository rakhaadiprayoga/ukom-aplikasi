package com.rakhaadi.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class beranda extends AppCompatActivity {

    ApiInterface ApiInterface;
    private RecyclerView aRecyclerView;
    private RecyclerView.Adapter aAdapter;
    private RecyclerView.LayoutManager aLayoutManager;
    public static beranda oe;


//    RecyclerView recyclerView;
//    BarangAdapter adapter;
//    List<barang> barangList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        //initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //set perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                   ,Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.upload:
                        startActivity(new Intent(getApplicationContext()
                                ,Upload.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                ,about.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        aRecyclerView = (RecyclerView) findViewById(R.id.rcvBarang);
        aLayoutManager = new LinearLayoutManager(this);
        aRecyclerView.setLayoutManager(aLayoutManager);
        ApiInterface = ApiCllient.getClient().create(com.rakhaadi.myapplication.ApiInterface.class);
        oe = this;

        panggilRetrovit();

    }

    public void panggilRetrovit(){
        Call<GetBarang> kategoriCall = ApiInterface.GetBarang();
        kategoriCall.enqueue(new Callback<GetBarang>() {
            @Override
            public void onResponse(Call<GetBarang> call, Response<GetBarang>
                    response) {
                List<barang> modelbaranglist = response.body().getbarang();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(modelbaranglist.size()));
                aAdapter = new BarangAdapter(modelbaranglist);
                aRecyclerView.setAdapter(aAdapter);
            }

            @Override
            public void onFailure(Call<GetBarang> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater menuinflater= getMenuInflater();
//        menuinflater.inflate(R.menu.search_menu, menu);
//        MenuItem menuitem = menu.findItem(R.id.search_action);
//
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuitem);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchView.clearFocus();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }

//    public void load(){
//        recyclerView = findViewById(R.id.rcvBarang);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isiData(){
////        barangList = new ArrayList<barang>();
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
////        barangList.add(new barang("GENTENG METAL PASIR PUTRA ROOF TCT 0,25mm", " Rp85.000 - 175.000"));
//
//        adapter = new BarangAdapter(this, barangList);
//        recyclerView.setAdapter(adapter);
//    }
}