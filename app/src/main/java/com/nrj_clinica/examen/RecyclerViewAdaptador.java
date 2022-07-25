package com.nrj_clinica.examen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lista_nombre, lista_edad,lista_peso,lista_altura,lista_tipo_sexo,lista_nss,lista_tipo_peso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lista_nombre=(TextView)itemView.findViewById(R.id.lista_nombre);
            lista_edad=(TextView)itemView.findViewById(R.id.lista_edad);
            lista_peso=(TextView)itemView.findViewById(R.id.lista_peso);
            lista_altura=(TextView)itemView.findViewById(R.id.lista_altura);
            lista_tipo_sexo=(TextView)itemView.findViewById(R.id.lista_tipo_sexo);
            lista_nss=(TextView)itemView.findViewById(R.id.lista_nss);
            lista_tipo_peso=(TextView)itemView.findViewById(R.id.lista_tipo_peso);
        }
    }

    public List<listadoPersonas> lista_personas;

    public RecyclerViewAdaptador(List<listadoPersonas> lista_personas) {
        this.lista_personas = lista_personas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_personas,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lista_nombre.setText(lista_personas.get(position).getNombre());
        holder.lista_edad.setText(lista_personas.get(position).getEdad());
        holder.lista_peso.setText(lista_personas.get(position).getPeso());
        holder.lista_altura.setText(lista_personas.get(position).getAltura());
        holder.lista_tipo_sexo.setText(lista_personas.get(position).getTipo_sexo());
        holder.lista_nss.setText(lista_personas.get(position).getNss());
        holder.lista_tipo_peso.setText(lista_personas.get(position).getTipo_peso());
    }

    @Override
    public int getItemCount() {
        return lista_personas.size();
    }
}
