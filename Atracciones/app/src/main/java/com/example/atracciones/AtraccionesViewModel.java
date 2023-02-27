package com.example.atracciones;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.atracciones.Api.AtraccionesRepository;
import com.example.atracciones.data.AtraccionesRpuesta;

import java.io.Closeable;
import java.util.List;

public class AtraccionesViewModel extends ViewModel {
    private LiveData<List<AtraccionesRpuesta>> listaData;
    private LiveData<AtraccionesRpuesta> detalleData;
    private AtraccionesRepository repository = AtraccionesRepository.getInstance();





    public void init(){
        repository=new AtraccionesRepository();
        listaData=repository.getAtraccionLiveData();
        detalleData=repository.getDetalleLiveData();
    }
    public void getAtraccion() {
        repository.getAtraccion();
    }

    public void getDetalle(String id) {
        repository.getDetalle(id);
    }

    public LiveData<List<AtraccionesRpuesta>> getListaData() {
        if (listaData == null) {
            listaData = repository.getAtraccionLiveData();
        }
        return listaData;
    }

    public LiveData<AtraccionesRpuesta> getDetalleData() {
        if (detalleData == null) {
            detalleData = repository.getDetalleLiveData();
        }
        return detalleData;
    }
}
