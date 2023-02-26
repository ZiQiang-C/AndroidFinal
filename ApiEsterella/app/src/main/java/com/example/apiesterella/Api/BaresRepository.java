package com.example.apiesterella.Api;

import androidx.lifecycle.MutableLiveData;

import com.example.apiesterella.data.BaresResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaresRepository {
    private static BaresRepository instance;
    //URL de la API
    private static String URL_BASE = "http://192.168.100.135:8000/";

    //Objeto de la Interfaz servicio - MutableLiveData
    private BaresService baresService;
    private MutableLiveData<List<BaresResponse>> baresLiveData;

    public BaresRepository(){
        baresLiveData = new MutableLiveData<>();


        //Utilizando el servicio
        baresService = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BaresService.class);
    }
    public static BaresRepository getInstance() {
        if (instance == null) {
            instance = new BaresRepository();
        }
        return instance;
    }
    public void filtradoBares(int busAtraccion){
        baresService.filtradoBares(busAtraccion).enqueue(new Callback<List<BaresResponse>>() {
            @Override
            public void onResponse(Call<List<BaresResponse>> call, Response<List<BaresResponse>> response) {
                if(response.body()!=null){
                    List<BaresResponse> listaBares = response.body();
                    baresLiveData.postValue(listaBares);
                }
            }

            @Override
            public void onFailure(Call<List<BaresResponse>> call, Throwable t) {
                List<BaresResponse> listaBares = new ArrayList<>();
                baresLiveData.postValue(listaBares);
            }
        });
    }
    public void getBares(){
        baresService.getBares().enqueue(new Callback<List<BaresResponse>>() {
            @Override
            public void onResponse(Call<List<BaresResponse>> call, Response<List<BaresResponse>> response) {
                if (response.body() != null) {
                    List<BaresResponse> listaBares = response.body();
                    baresLiveData.postValue(listaBares);
                }
            }

            @Override
            public void onFailure(Call<List<BaresResponse>> call, Throwable t) {
                List<BaresResponse> listaBares = new ArrayList<>();
                baresLiveData.postValue(listaBares);
            }
        });

    }
    public MutableLiveData<List<BaresResponse>> getBaresLiveData() {
        return baresLiveData;
    }
}
