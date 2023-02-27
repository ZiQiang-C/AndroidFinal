package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.atracciones.data.AtraccionesRpuesta;

public class ActivityComentario extends AppCompatActivity {
    private TextView nombre;
    private TextView dec;
    private TextView ocupantes;
    private RecyclerView lista;
    private ComentariosAdapter adapter;
    private AtraccionesViewModel vml;
    LiveData<AtraccionesRpuesta> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

        nombre = findViewById(R.id.comentarioNombre);
        dec = findViewById(R.id.comentarioDesc);
        ocupantes = findViewById(R.id.comentarioOcupantes);
        lista = findViewById(R.id.comentariosRV);

        adapter = new ComentariosAdapter();
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);




        vml = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vml.init();
        data=vml.getDetalleData();


        Intent intent = getIntent();
        String id = intent.getStringExtra(ActivyAtreacciones.ID_DETALLE);
        vml.getDetalle(id);

        data.observe(this,(data)->{
            nombre.setText(data.getNombre());
            dec.setText(data.getDescripcion());
            ocupantes.setText(data.getOcupantes());
            adapter.setResults(data.getComentarios());
        });

    }
}