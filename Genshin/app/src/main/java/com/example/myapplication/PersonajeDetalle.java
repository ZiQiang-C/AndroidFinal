package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.data.PersonajeRepuesta;

import java.util.ArrayList;
import java.util.List;

public class PersonajeDetalle extends AppCompatActivity {

    PersonajeViewModel vml;
    LiveData<PersonajeRepuesta> data;
    ImageView imagen;
    TextView Dname,title,vision;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);

        imagen=findViewById(R.id.Dimagen);
        Dname=findViewById(R.id.Dname);
        title=findViewById(R.id.Dtitle);
        vision=findViewById(R.id.Dvision);

        String name = getIntent().getStringExtra("name");
        //Log.d("a",name);

        vml = new ViewModelProvider(this).get(PersonajeViewModel.class);
        vml.init();

        data=vml.getDetalleData();
        vml.getDetalle(name);
        data.observe(this,(data)->{
            Dname.setText(data.getName());
            title.setText(data.getTitle());
            vision.setText(data.getVision());

            CogerImagen(name);


        });
        vml.getDetalle(name);
    }

    private void CogerImagen(String name) {
        String imgURL = "https://api.genshin.dev/characters/"+name+"/gacha-splash";
        Glide.with(this).load(imgURL).into(imagen);
    }
}