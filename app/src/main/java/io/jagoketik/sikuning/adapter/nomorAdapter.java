package io.jagoketik.sikuning.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.model.angkot;
import io.jagoketik.sikuning.model.nomor_lin;

public class nomorAdapter extends RecyclerView.Adapter<nomorAdapter.nomorViewHolder>{

    public nomorAdapter(Context mcx, List<nomor_lin> nomor) {
        this.mcx = mcx;
        this.nomor = nomor;
    }

    private Context mcx;
    private List<nomor_lin> nomor;



    @NonNull
    @Override
    public nomorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcx);
        View view = inflater.inflate(R.layout.nomor_angkot,null);
        return new nomorAdapter.nomorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nomorViewHolder holder, int position) {
            nomor_lin noLin = nomor.get(position);
        holder.nomor.setText(noLin.getKode());

    }

    @Override
    public int getItemCount() {
        return nomor.size();
    }

    class nomorViewHolder extends RecyclerView.ViewHolder {
        TextView nomor;
        public nomorViewHolder(View itemView) {
            super(itemView);
            nomor = itemView.findViewById(R.id.nomorangkot);
        }
    }
}
