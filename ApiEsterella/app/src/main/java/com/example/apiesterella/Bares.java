package com.example.apiesterella;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Bares extends AppCompatActivity {
    private RecyclerView lista;
    private Button button;
    private EditText editText;
    private BaresAdapter adapter;
    private BaresViewModel vml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_bares);
        adapter= new BaresAdapter();
        lista=findViewById(R.id.Recy);
        button=findViewById(R.id.IDbutton);
        editText=findViewById(R.id.IDbuscar);

        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);

        vml = new ViewModelProvider(this).get(BaresViewModel.class);
        vml.init();

        vml.getBaresResponse().observe(this, (dato) -> {
            adapter.setResults(dato);
        });
        button.setOnClickListener(view -> {
            int estrellas = Integer.parseInt(String.valueOf(editText.getText()));
            vml.filtradoBares(estrellas);
        });

        vml.getBares();
    }
}