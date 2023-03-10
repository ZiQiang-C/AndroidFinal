package com.example.rickandmorty.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {


    //Obtiene la url de aquellos que comparten la ubicación
    @SerializedName("url")
    @Expose
    private String urlLocation;

    //Obtiene el nombre de la locacización actual
    @SerializedName("nam    e")
    @Expose
    private String nameLocation;

    public String getUrlLocation() {
        return urlLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }
}
