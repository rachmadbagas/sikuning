package io.jagoketik.sikuning.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.model.angkot;
import io.jagoketik.sikuning.model.mobil_angkot;
import io.jagoketik.sikuning.model.nomor_lin;

public class nomorAdapter extends RecyclerView.Adapter<nomorAdapter.nomorViewHolder>{

    public nomorAdapter(Context mcx, List<mobil_angkot> angkot, OnItemClickListener listener) {
        this.mcx = mcx;
        this.angkot = angkot;
        this.listener = listener;
    }

    private Context mcx;
    private List<mobil_angkot> angkot;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public nomorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcx);
        View view = inflater.inflate(R.layout.nomor_angkot,null);
        return new nomorAdapter.nomorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nomorViewHolder holder, int position) {
        mobil_angkot angkots = angkot.get(position);
        holder.bind(angkots, listener);

    }

    @Override
    public int getItemCount() {
        return angkot.size();
    }

    public interface OnItemClickListener {
        void onItemClick(mobil_angkot model);
    }

    class nomorViewHolder extends RecyclerView.ViewHolder {
        TextView nomor;
        public nomorViewHolder(View itemView) {
            super(itemView);
            nomor = itemView.findViewById(R.id.nomorangkot);
        }

        public void bind(final mobil_angkot model, final OnItemClickListener listener) {
            nomor.setText(model.getKode() + model.getAngkot_nomor().toString() + "");
            nomor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(model);
                }
            });
        }
    }
}
