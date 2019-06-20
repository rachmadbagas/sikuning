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
import io.jagoketik.sikuning.model.destinasi_model;

public class destinasiAdapter extends RecyclerView.Adapter<destinasiAdapter.destinasiViewHolder> {

    private Context mcx;
    private List<Object> tujuanList;

    public destinasiAdapter(Context mcx, List<Object> tujuanList) {
        this.mcx = mcx;
        this.tujuanList = tujuanList;
    }

    @NonNull
    @Override
    public destinasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcx);
        View view = inflater.inflate(R.layout.destinasi_item,null);
        return new destinasiAdapter.destinasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull destinasiViewHolder holder, int position) {
        Object tujuanx = tujuanList.get(position);
        holder.destinasi.setText(tujuanx.toString());
    }

    @Override
    public int getItemCount() {
        return tujuanList.size();
    }

    class destinasiViewHolder extends RecyclerView.ViewHolder{
        TextView destinasi;
        public destinasiViewHolder(View itemView) {
            super(itemView);
            destinasi  = itemView.findViewById(R.id.destinasi);

        }
    }
}
