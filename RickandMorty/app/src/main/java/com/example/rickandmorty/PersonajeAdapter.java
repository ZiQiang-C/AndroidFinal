package com.example.rickandmorty;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickandmorty.data.Personajes;

import java.util.ArrayList;
import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter <PersonajeAdapter.PersonajeAdapterResultHolder>{
    private List<Personajes> results = new ArrayList<>();
    private OnItemClickListener mListener;
    @NonNull
    @Override
    public PersonajeAdapter.PersonajeAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_personaje, parent, false);
        return  new PersonajeAdapterResultHolder(itemView);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapter.PersonajeAdapterResultHolder holder, int position) {
            //Recibe La página con la info
        Personajes personajeRespuesta = results.get(position);

        //Inserto al Recycler
        holder.EName.setText(personajeRespuesta.getName());
        holder.Estatus.setText(personajeRespuesta.getStatus());
        holder.Especies.setText(personajeRespuesta.getSpecies());
        holder.Egender.setText(personajeRespuesta.getGender());
        holder.Eid.setText(personajeRespuesta.getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                        String id=personajeRespuesta.getId();

                    }
                }
            }
        });
        //En     imágenes
        if (personajeRespuesta.getImagelink() != null) {

            //No hace falta hacer replace ya que es HTTPS
            String imgURL = personajeRespuesta.getImagelink();

            Glide.with(holder.itemView)
                    .load(imgURL)
                    .into(holder.EimagenPersonaje);

        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    public void setResults(List<Personajes> results) {
        this.results = results;
        notifyDataSetChanged();
    }
    //Clase Holder (Es otra clase en el mismo documento) No sé muy bien por qué se hizo así pero cuando retornas, retornas a esto
    class PersonajeAdapterResultHolder extends RecyclerView.ViewHolder {

        //Creamos las variables que utilizaremos para el Recycler
        private TextView EName, Estatus, Especies, Egender,Eid;
        private ImageView EimagenPersonaje;
        public PersonajeAdapterResultHolder(@NonNull View itemView) {
            super(itemView);

            //Asignamos ids
            EName = itemView.findViewById(R.id.Ename);
            Estatus = itemView.findViewById(R.id.Estatus);
            Especies = itemView.findViewById(R.id.Especies);
            Egender = itemView.findViewById(R.id.Egender);
            EimagenPersonaje = itemView.findViewById(R.id.EimagenPersonaje);
            Eid=itemView.findViewById(R.id.Eid);
        }



    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
