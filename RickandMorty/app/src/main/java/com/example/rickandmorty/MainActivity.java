package com.example.rickandmorty;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.rickandmorty.R;
import com.example.rickandmorty.data.PaginaRespuesta;

public class MainActivity extends AppCompatActivity implements PersonajeAdapter.OnItemClickListener{
    Button BSiguiente,BVolver;
    RecyclerView personajeRecycler;
    PersonajesViewModel vm;
    LiveData<PaginaRespuesta> data;

    public static String numero="1";
    public static ActivityResultLauncher resultadoLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BSiguiente = findViewById(R.id.BSiguiente);
        BVolver = findViewById(R.id.BSiguiente);
        personajeRecycler = findViewById(R.id.PersonajesRecycler);

        //Vainas del Recycler y el adapter
        PersonajeAdapter adapter = new PersonajeAdapter();
        personajeRecycler.setLayoutManager(new LinearLayoutManager(this));
        personajeRecycler.setAdapter(adapter);

        //Método onClick de la verga (hay que hacerlo)
        adapter.setOnItemClickListener(this);

        //Vainas del ViewModel
        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data = vm.getPaginaRespuestaLiveData();

        //Observador MutableLiveData
        data.observe(this, (data) ->{
            adapter.setResults(data.getPersonajesRespuestas());
        });

        vm.buscarPagina(numero);

        //Launcher Results
        resultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{

        });

    }

    @Override
    public void onItemClick(int position) {
        envio(position);
    }

    private void envio(int position) {
        Intent intent = new Intent(MainActivity.this,MainActivityDetalle.class);
        intent.putExtra("position",position);

        resultadoLauncher.launch(intent);
    }
}