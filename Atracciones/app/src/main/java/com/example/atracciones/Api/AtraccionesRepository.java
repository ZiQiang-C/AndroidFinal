package com.example.atracciones.Api;

import androidx.lifecycle.MutableLiveData;

import com.example.atracciones.data.AtraccionesRpuesta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionesRepository {

    private static final  String URl_BASE ="http://192.168.100.135:8000/";
    private static AtraccionesRepository instance;
    private  AtraccionesService atraccionesService;
    private  MutableLiveData<List<AtraccionesRpuesta>> atraccionLiveData;
    private  MutableLiveData<AtraccionesRpuesta> detalleLiveData;
    private String prueba;

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public AtraccionesRepository(){
        atraccionLiveData = new MutableLiveData<>();
        detalleLiveData = new MutableLiveData<>();

        atraccionesService=new  retrofit2.Retrofit.Builder()
                .baseUrl(URl_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AtraccionesService.class);
    }

    public void getDetalle(String id){
        atraccionesService.getDetalle(id).enqueue(new Callback<AtraccionesRpuesta>() {
            @Override
            public void onResponse(Call<AtraccionesRpuesta> call, Response<AtraccionesRpuesta> response) {
                if(response.body()!=null){
                    detalleLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<AtraccionesRpuesta> call, Throwable t) {
                detalleLiveData.postValue(null);
            }
        });
    }

    public void getAtraccion(){
        atraccionesService.getAtraccion().enqueue(new Callback<List<AtraccionesRpuesta>>() {
            @Override
            public void onResponse(Call<List<AtraccionesRpuesta>> call, Response<List<AtraccionesRpuesta>> response) {
                List<AtraccionesRpuesta> listaAtraccion = response.body();
                atraccionLiveData.postValue(listaAtraccion);
            }

            @Override
            public void onFailure(Call<List<AtraccionesRpuesta>> call, Throwable t) {
                List<AtraccionesRpuesta> listaAtraccion = new ArrayList<>();
                atraccionLiveData.postValue(listaAtraccion);
            }
        });
    }
    public static AtraccionesRepository getInstance(){
        if (instance==null){
            instance= new AtraccionesRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AtraccionesRpuesta>> getAtraccionLiveData() {
        return atraccionLiveData;
    }

    public MutableLiveData<AtraccionesRpuesta> getDetalleLiveData() {
        return detalleLiveData;
    }
}
