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

public class angkotAdapter extends RecyclerView.Adapter<angkotAdapter.angkotViewHolder>{

    private Context mcx;
    private List<angkot> angkots;

    public angkotAdapter(Context mcx, List<angkot> angkots) {
        this.mcx = mcx;
        this.angkots = angkots;
    }

    @NonNull
    @Override
    public angkotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcx);
        View view = inflater.inflate(R.layout.angkot_list,null);
        return new angkotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull angkotViewHolder holder, int position) {
        angkot Angkot = angkots.get(position);
        holder.kodeAngkot.setText(Angkot.getJenisAngkot());
    }

    @Override
    public int getItemCount() {
        return angkots.size();
    }

    class angkotViewHolder extends RecyclerView.ViewHolder {
        TextView kodeAngkot;
        public angkotViewHolder(View itemView) {
            super(itemView);
            kodeAngkot = itemView.findViewById(R.id.jenisLin);
        }
    }
}
