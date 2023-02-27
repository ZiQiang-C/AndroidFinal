package com.example.myapplication.Api;

import com.example.myapplication.data.PersonajeRepuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonajeSerive {
    @GET("/characters")
    Call<List<String>> getPersonajes();

    @GET("/characters/{name}")
    Call<PersonajeRepuesta> getPersonajeDetalle(@Path("name") String name);
}
