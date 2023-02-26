package com.example.apiesterella;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiesterella.Api.BaresRepository;
import com.example.apiesterella.data.BaresResponse;

import java.util.List;

public class BaresViewModel extends ViewModel {
    private MutableLiveData<List<BaresResponse>> data;
    private BaresRepository baresRepository;

    public void init(){
        baresRepository = BaresRepository.getInstance();
        data = baresRepository.getBaresLiveData();
    }

    public void filtradoBares(int estrellas){
        baresRepository.filtradoBares(estrellas);
    }

    public void getBares(){
        baresRepository.getBares();
    }

    public LiveData<List<BaresResponse>> getBaresResponse() {
        return data;
    }
}
