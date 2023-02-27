package com.example.myapplication.Api;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.data.PersonajeRepuesta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class PersonajeRepository {
    private static final String URl_BASE ="https://api.genshin.dev/";
    private static PersonajeRepository instance;
    private PersonajeSerive personajeSerive;
    private MutableLiveData <List<String>> perosnajeListaData;
    private MutableLiveData <PersonajeRepuesta> personajeListaDetalle;
    List<String> respuesta;
    public PersonajeRepository(){
        personajeListaDetalle=new MutableLiveData<>();
        perosnajeListaData=new MutableLiveData<>();

        personajeSerive=new Retrofit.Builder()
                .baseUrl(URl_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PersonajeSerive.class);
    }


    public static PersonajeRepository getInstance() {
        if (instance==null){
            instance= new PersonajeRepository();
        }
        return instance;
    }

    public void getPersonajes(){
        personajeSerive.getPersonajes().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                respuesta = response.body();
                perosnajeListaData.postValue(respuesta);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }

    public void getPersonajeDetalle(String name){
        personajeSerive.getPersonajeDetalle(name).enqueue(new Callback<PersonajeRepuesta>() {
            @Override
            public void onResponse(Call<PersonajeRepuesta> call, Response<PersonajeRepuesta> response) {
                if(response.body()!=null){
                    personajeListaDetalle.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PersonajeRepuesta> call, Throwable t) {
                personajeListaDetalle.postValue(null);
            }
        });
    }

    public MutableLiveData<List<String>> getPerosnajeListaData() {
        return perosnajeListaData;
    }

    public MutableLiveData<PersonajeRepuesta> getPersonajeListaDetalle() {
        return personajeListaDetalle;
    }
}
