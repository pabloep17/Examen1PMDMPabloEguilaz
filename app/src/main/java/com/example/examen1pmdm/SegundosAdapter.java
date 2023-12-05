package com.example.examen1pmdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.math.BigInteger;
import java.util.List;

public class SegundosAdapter extends RecyclerView.Adapter<SegundosAdapter.ViewHolder> {

    // Lista de segundos
    private List<Integer> segundosList;

    // La clase para dar formato
    TimeFormater tm = new TimeFormater();

    // Creo el contructor y recibo la lisya
    public SegundosAdapter(List<Integer> userModelList) {
        this.segundosList = userModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Obtengo como se va a ver individualmente cada tiempo
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_row_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Le doy el valor
        holder.segundos.setText(tm.secondsToTime(segundosList.get(position)));
    }

    @Override
    public int getItemCount() {
        return segundosList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView segundos;
        public ViewHolder(View v) {
            super(v);
            // Obtengo el text fiel de la row view donde se muestran los segundos
            segundos = (TextView) v.findViewById(R.id.rowSecondsView);
        }
    }

}