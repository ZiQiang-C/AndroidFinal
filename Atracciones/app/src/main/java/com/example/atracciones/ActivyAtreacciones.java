package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ActivyAtreacciones extends AppCompatActivity {
    public static final String ID_DETALLE="ID";
    private RecyclerView lista;
    private AtraccionesAdapter adapter;
    public AtraccionesViewModel vml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AtraccionesAdapter();

        lista=findViewById(R.id.Recy);


        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);


        vml = new ViewModelProvider(this).get(AtraccionesViewModel.class);

        vml.setCampoPrueba("XDDDDDDDDDDDDDDDDDD");

        vml.getListaData().observe(this, (dato) -> {
            adapter.setResults(dato);
        });

        adapter.setClickListener((view, v) -> {
            String id = getId(v);
            Intent intent = new Intent(this, ActivityComentario.class);
            intent.putExtra(ID_DETALLE, id);

            startActivity(intent);
        });

        vml.getAtraccion();
    }
    private String getId(String url) {
        String[] partes = url.split("/");
        String id = partes[partes.length - 1];
        return id;
    }
}