package com.example.rickandmorty;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rickandmorty.Api.PersonajeRepository;
import com.example.rickandmorty.data.PaginaRespuesta;
import com.example.rickandmorty.data.Personajes;

public class PersonajesViewModel extends AndroidViewModel {
    private PersonajeRepository personajeRepository;
    private LiveData<PaginaRespuesta> paginaRespuestaLiveData;
    private LiveData<Personajes> personajeRespuestaLiveData;

    public PersonajesViewModel(@NonNull Application application){
        super(application);
    }
    public void init() {
        personajeRepository = new PersonajeRepository();
        paginaRespuestaLiveData = personajeRepository.getPaginasRespuestaLiveData();
        personajeRespuestaLiveData = personajeRepository.getPersonajeRespuestaLiveData();

    }
    //Métodos que actualizan el Mutable

    public void buscarPersonaje(String id) {
        personajeRepository.buscarPersonaje(id);
    }
    //métodos que actualizan el Mutable
    public void buscarPagina (String page) {
        personajeRepository.buscarPagina(page);
    }
    /*public void buscarPagina2 (String page,String id){
        personajeRepository.buscarPagina2(page,id);
    }*/
    public void siguientePagina(String peticionSiguiente) {personajeRepository.siguientePagina(peticionSiguiente);};

    //Hace nueva petición volver a la anterior
    public void volverPagina(String peticionVolver) {personajeRepository.volverPagina(peticionVolver);};

    public LiveData<PaginaRespuesta> getPaginaRespuestaLiveData() {
        return paginaRespuestaLiveData;
    }

    public LiveData<Personajes> getPersonajeRespuestaLiveData() {
        return personajeRespuestaLiveData;
    }
}
