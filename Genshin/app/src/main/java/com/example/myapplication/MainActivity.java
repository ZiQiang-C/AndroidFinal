package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.data.ListaPersonaRepuesta;

public class MainActivity extends AppCompatActivity implements PesonajeAdapter.onItemClickListener {
    public static final String NAME_DETALLE = "ID";
    private RecyclerView lista;
    private PesonajeAdapter adapter;
    private PersonajeViewModel vml;
    LiveData<ListaPersonaRepuesta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().hide();
        lista = findViewById(R.id.Recye);

        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PesonajeAdapter();
        lista.setAdapter(adapter);

        adapter.setOnItemClickListener( this);
        vml = new ViewModelProvider(this).get(PersonajeViewModel.class);
        vml.init();

        vml.getListaData().observe(this, (dato) -> {
            adapter.setData(dato);
        });


        vml.getLista();
    }
    @Override
    public void onItemClick(int position) {

        String nombre = adapter.getData().get(position);

         Toast.makeText(this, nombre,Toast.LENGTH_SHORT).show();
        envio(nombre);
    }

    public void envio(String nombre) {
        Intent intent = new Intent(this, PersonajeDetalle.class);
        intent.putExtra("name",nombre);
        startActivity(intent);

    }
}