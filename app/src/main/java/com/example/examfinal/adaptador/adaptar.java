package com.example.examfinal.adaptador;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examfinal.R;
import com.example.examfinal.mapaActividad;
import com.example.examfinal.registro;
import com.example.examfinal.repositorio.reposito;

import java.util.List;

public class adaptar  extends  RecyclerView.Adapter<adaptar.VistaHolder> {


    private List<reposito> datos;

    public adaptar(List<reposito> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public VistaHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itm_mostrar, parent,false);
        return new VistaHolder(vista);
    }

    @Override
    public void onBindViewHolder(VistaHolder holder, int position) {
        TextView tvTitulo = holder.itemView.findViewById(R.id.titulos);
        ImageView tvImagen = holder.itemView.findViewById(R.id.img);

        reposito re = datos.get(position);

        tvTitulo.setText(re.getTitulo());

        Button btn =holder.itemView.findViewById(R.id.tienda);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(holder.itemView.getContext(), mapaActividad.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    class VistaHolder extends RecyclerView.ViewHolder{

        public VistaHolder(@NonNull View itemView) {

            super(itemView);
        }
    }

}
