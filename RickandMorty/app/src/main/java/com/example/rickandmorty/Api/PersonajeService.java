package com.example.rickandmorty.Api;

import com.example.rickandmorty.data.PaginaRespuesta;
import com.example.rickandmorty.data.Personajes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonajeService {
    //Get que manda y recibe un personaje filtrado por id :D
    @GET("/api/character/{id}")
    Call<Personajes> buscarPersonaje(@Path("id") int id);

    //Get, que devuelve 20 personajes, se filtra a través de page
    @GET("/api/character")
    Call <PaginaRespuesta> buscarPagina(
            @Query("page") String page
    );
}
