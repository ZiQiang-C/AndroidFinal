package com.example.atracciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atracciones.data.ComentariosRepuesta;

import java.util.ArrayList;
import java.util.List;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosViewHolder>{
    public static List<ComentariosRepuesta> data = new ArrayList<>();
    @NonNull
    @Override
    public ComentariosAdapter.ComentariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comentarios, parent, false);
        return new ComentariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentariosAdapter.ComentariosViewHolder holder, int position) {
        holder.getTexto().setText(data.get(position).getTexto());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setResults(List<ComentariosRepuesta> data){
        this.data = data;
        notifyDataSetChanged();
    }
    public class ComentariosViewHolder extends RecyclerView.ViewHolder {
        private TextView texto;

        public ComentariosViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.comentarioTexto);
        }
        public TextView getTexto() {
            return texto;
        }
    }
}
