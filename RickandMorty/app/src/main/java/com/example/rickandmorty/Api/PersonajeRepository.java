package com.example.rickandmorty.Api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmorty.data.PaginaRespuesta;
import com.example.rickandmorty.data.Personajes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonajeRepository {
    private static String URL_BASE = "https://rickandmortyapi.com";

    //Objeto de la Interfaz servicio - MutableLiveData
    private PersonajeService personajeService;
    private MutableLiveData <PaginaRespuesta> respuestaMutableLiveData;
    private MutableLiveData <Personajes> respuestaMutableLiveDataPersonaje;

    public PersonajeRepository() {

        //Instanciamos el objeto mutable
        respuestaMutableLiveData = new MutableLiveData<>();

        //Utilizando el servicio
        personajeService = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PersonajeService.class);

    }

    public void volverPagina(String volverPeticion) {
        personajeService.volverPagina(volverPeticion).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });
    }

    public void siguientePagina(String peticionSiguiente) {
        personajeService.siguientePagina(peticionSiguiente).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });

    }

    //Método que filtra 1 personaje
    public void buscarPersonaje(String id) {
        personajeService.buscarPersonaje(id).enqueue(new Callback<Personajes>() {
            @Override
            public void onResponse(Call<Personajes> call, Response<Personajes> response) {
                if (response.body() != null) {
                    respuestaMutableLiveDataPersonaje.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Personajes> call, Throwable t) {
                respuestaMutableLiveDataPersonaje.postValue(null);
            }
        });

    }

    //Método que muestra la página
    public void buscarPagina(String page) {
        personajeService.buscarPagina(page).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });

    }

    //Retorna el Mutable
    public LiveData<PaginaRespuesta> getPaginasRespuestaLiveData () {
        return respuestaMutableLiveData;
    }

    //Retorna el Mutable
    public LiveData<Personajes> getPersonajeRespuestaLiveData () {
        return respuestaMutableLiveDataPersonaje;
    }

}
