package com.example.rickandmorty.Api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmorty.data.PaginaRespuesta;
import com.example.rickandmorty.data.Personajes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonajeRepository {
    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://rickandmortyapi.com/";

    private PersonajeService personajeService;

    private MutableLiveData<PaginaRespuesta> paginaRespuestaLiveData;
    private MutableLiveData<Personajes> personajesRespuestaLiveData;
    public PersonajeRepository(){
        //Instanciamos el objeto mutable
        paginaRespuestaLiveData = new MutableLiveData<>();

        //Utilizando el servicio
        personajeService =new retrofit2.Retrofit.Builder()
                .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PersonajeService.class);
    }
    public void buscarPersonaje(int id){
        personajeService.buscarPersonaje(id).enqueue(new Callback<Personajes>() {
            @Override
            public void onResponse(Call<Personajes> call, Response<Personajes> response) {

                personajesRespuestaLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Personajes> call, Throwable t) {
                personajesRespuestaLiveData.postValue(null);
            }
        });
    }
    public  void buscarPagina(String page){
        personajeService.buscarPagina(page).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                paginaRespuestaLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                paginaRespuestaLiveData.postValue(null);
            }
        });
    }

    public LiveData<PaginaRespuesta> getPaginaRespuestaLiveData() {
        return paginaRespuestaLiveData;
    }

    public LiveData<Personajes> getPersonajesRespuestaLiveData() {
        return personajesRespuestaLiveData;
    }
}
