package com.rakhaadi.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
//    @GET("/api/kategori")
//    Call<GetKategori> GetKategori();
    @GET("/api/menu")
    Call<GetBarang> GetBarang();

}
