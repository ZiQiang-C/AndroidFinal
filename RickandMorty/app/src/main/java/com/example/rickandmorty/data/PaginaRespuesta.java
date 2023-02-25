package com.example.rickandmorty.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginaRespuesta {
    //Devuelve info de las paginas
    @SerializedName("info")
    @Expose
    InfoPage infopage;

    //Devuelve personajes de la página actual
    @SerializedName("results")
    @Expose
    List<Personajes> personajes;

    public InfoPage getInfopage() {
        return infopage;
    }

    public List<Personajes> getPersonajesRespuestas() {
        return personajes;
    }
}
