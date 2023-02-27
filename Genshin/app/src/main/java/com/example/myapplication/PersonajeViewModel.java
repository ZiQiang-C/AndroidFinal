package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Api.PersonajeRepository;
import com.example.myapplication.Api.PersonajeSerive;
import com.example.myapplication.data.PersonajeRepuesta;

import java.util.List;

public class PersonajeViewModel extends ViewModel {
    private LiveData<List<String>> listaData;
    private LiveData<PersonajeRepuesta> detalleData;
    private PersonajeRepository repository = PersonajeRepository.getInstance();

    public void init(){
        repository=new PersonajeRepository();
        listaData=repository.getPerosnajeListaData();
        detalleData=repository.getPersonajeListaDetalle();
    }

    public void getLista(){
        repository.getPersonajes();
    }
    public  void getDetalle(String name){
        repository.getPersonajeDetalle(name);
    }

    public LiveData<List<String>> getListaData() {
        if (listaData == null) {
            listaData = repository.getPerosnajeListaData();
        }
        return listaData;
    }

    public LiveData<PersonajeRepuesta> getDetalleData() {
        if (detalleData == null) {
            detalleData = repository.getPersonajeListaDetalle();
        }
        return detalleData;
    }
}
