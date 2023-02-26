package com.example.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rickandmorty.data.PaginaRespuesta;
import com.example.rickandmorty.data.Personajes;

import java.util.ArrayList;
import java.util.List;

public class MainActivityDetalle extends AppCompatActivity {

    ImageView Eimage;
    TextView nombre,estado,especie,id;
    PersonajesViewModel vm;
    LiveData<PaginaRespuesta> data;

    private List<Personajes> results= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle);
        Eimage=findViewById(R.id.Dimag);
        nombre=findViewById(R.id.Dnombre);
        estado=findViewById(R.id.Destado);
        especie=findViewById(R.id.Despecie);
        id=findViewById(R.id.D_id);
        int position =getIntent().getIntExtra("position",0);
        int page=getIntent().getIntExtra("page",0);


        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data = vm.getPaginaRespuestaLiveData();

        vm.buscarPagina(page+"");
        data.observe(this,(data)->{

            results = data.getPersonajes();
            Personajes pagina=results.get(position);

            nombre.setText(pagina.getName());
            especie.setText(pagina.getSpecies());
            estado.setText(pagina.getStatus());
            id.setText(pagina.getId());
            if (pagina.getImagelink() != null) {
                String imageUrl = pagina.getImagelink()
                        .replace("http://", "https://");

                Glide.with(this).load(imageUrl).into(Eimage);
            }
        });
    }


}