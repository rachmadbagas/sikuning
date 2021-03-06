package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.adapter.destinasiAdapter;
import io.jagoketik.sikuning.adapter.nomorAdapter;
import io.jagoketik.sikuning.api.RetrofitClient;
import io.jagoketik.sikuning.model.destinasi_model;
import io.jagoketik.sikuning.model.mobil_angkot;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class angkot_sekitar extends Fragment {
    RecyclerView rv,destinasi;
    nomorAdapter adapter;
    destinasiAdapter tujuanAdapter;
    TextView asaltujuanTV;
    List<Object> destinasiList;
    List<mobil_angkot> nomor;
    Button btnslangkot, btnpanggil;
    mobil_angkot selected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_angkot_sekitar, container, false);
        asaltujuanTV = v.findViewById(R.id.asaltujuan);
        btnslangkot = v.findViewById(R.id.btnselectedangkot);
        btnpanggil = v.findViewById(R.id.btnpanggil);
        destinasi = (RecyclerView) v.findViewById(R.id.tujuanList);
        destinasi.setHasFixedSize(true);
        destinasi.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        destinasiList = new ArrayList<Object>();


        LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        final double longitude = location.getLongitude();
        final double latitude = location.getLatitude();

        rv = (RecyclerView) v.findViewById(R.id.angkotsekitar);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        Call<List<mobil_angkot>> call = RetrofitClient.getInstance().getApi().getangkot(latitude + "", longitude + "");
        call.enqueue(new Callback<List<mobil_angkot>>() {
            @Override
            public void onResponse(Call<List<mobil_angkot>> call, Response<List<mobil_angkot>> response) {
                nomor = response.body();

                adapter = new nomorAdapter(getActivity(), nomor, new nomorAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(mobil_angkot model) {
                        if (model.getAngkot_reversed().equals("0")) {
                            asaltujuanTV.setText(model.getTrayek().get(0) + " - " + model.getTrayek().get(model.getTrayek().size() - 1));
                            tujuanAdapter = new destinasiAdapter(getActivity(), model.getTrayek());
                        } else {
                            List<Object> obj = reverse(model.getTrayek());
                            asaltujuanTV.setText(obj.get(0) + " - " + obj.get(obj.size() - 1));
                            tujuanAdapter = new destinasiAdapter(getActivity(), obj);
                        }
                        btnslangkot.setText(model.getKode() + "" + model.getAngkot_nomor());
                        btnpanggil.setEnabled(true);
                        destinasi.setAdapter(tujuanAdapter);
                        selected = model;
                    }
                });
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<mobil_angkot>> call, Throwable t) {

            }
        });


        btnpanggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
                final String uid = sharedPref.getString("ID", "");
                Call<ResponseBody> call = RetrofitClient.getInstance().getApi().sendorder(uid, selected.getAngkot_id(), latitude, longitude);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() == 200) {
                            Toast.makeText(getContext(), "Berhasil Melakukan Pemanggilan Angkot " + selected.getKode() + selected.getAngkot_nomor().toString() + "", Toast.LENGTH_LONG).show();
                            btnpanggil.setText("Menunggu ..");
                            btnpanggil.setEnabled(false);
                            rv.setEnabled(false);
                        } else {
                            Toast.makeText(getContext(), "Pemanggilan Angkot " + selected.getKode() + selected.getAngkot_nomor().toString() + " gagal", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
//                Toast.makeText(getContext(), selected.getUsers_name() , Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }

    public ArrayList<Object> reverse(ArrayList<Object> list) {
        if (list.size() > 1) {
            Object value = list.remove(0);
            reverse(list);
            list.add(value);
        }
        return list;
    }

}
