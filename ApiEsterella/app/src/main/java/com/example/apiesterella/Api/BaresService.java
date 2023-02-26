package com.example.apiesterella.Api;

import com.example.apiesterella.data.BaresResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaresService {
    @GET("pmdm/api/bares/")
    Call<List<BaresResponse>> filtradoBares(
            @Query("estrellas") int estrellas
    );

    @GET("pmdm/api/bares/")
    Call<List<BaresResponse>> getBares();
}
