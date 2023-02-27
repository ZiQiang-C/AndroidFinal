package com.example.atracciones.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AtraccionesRpuesta {
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("ocupantes")
    @Expose
    private String ocupantes;


    @SerializedName("comentarios")
    @Expose
    private List<ComentariosRepuesta> comentarios;
    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<ComentariosRepuesta> getComentarios() {
        return comentarios;
    }

    public String getOcupantes() {
        return ocupantes;
    }
}
