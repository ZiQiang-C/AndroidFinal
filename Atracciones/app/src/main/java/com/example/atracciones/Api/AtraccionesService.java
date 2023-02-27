package com.example.atracciones.Api;

import com.example.atracciones.data.AtraccionesRpuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AtraccionesService {


    @GET("pmdm/api/atracciones")
    Call<List<AtraccionesRpuesta>> getAtraccion();

    @GET("pmdm/api/atracciones/{id}")
    Call<AtraccionesRpuesta> getDetalle(@Path("id") String id);

    @GET
    Call<AtraccionesRpuesta> getDetalleV2(@Url String url);
}
