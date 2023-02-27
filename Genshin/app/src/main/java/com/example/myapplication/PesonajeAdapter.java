package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PesonajeAdapter extends RecyclerView.Adapter<PesonajeAdapter.PersonajeViewHolder> {
    private List<String> data = new ArrayList<>();
    //  onItemClickListener 要小写
    private onItemClickListener  mListener;




    public interface ItemClickListener{
        void onClick(View view, String v);
    }
    private ItemClickListener clickListener;



    public interface onItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener  listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public PesonajeAdapter.PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_personaje, parent, false);
        return new PersonajeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull PesonajeAdapter.PersonajeViewHolder holder, int position) {
        holder.getName().setText(data.get(position));

        String imgURL = "https://api.genshin.dev/characters/"+data.get(position)+"/icon";
        Glide.with(holder.itemView)
                .load(imgURL)
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setData(List<String> data){
        this.data = data;
        notifyDataSetChanged();
    }


    public List<String> getData() {
        return data;
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView imageView;


        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.Imagen);

        }

        public TextView getName() {
            return name;
        }

    }


}
