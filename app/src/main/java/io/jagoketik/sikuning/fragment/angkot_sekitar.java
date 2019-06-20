package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.adapter.angkotAdapter;
import io.jagoketik.sikuning.adapter.nomorAdapter;
import io.jagoketik.sikuning.model.angkot;
import io.jagoketik.sikuning.model.nomor_lin;


public class angkot_sekitar extends Fragment {
    RecyclerView rv;
    nomorAdapter adapter;

    List<nomor_lin> nomor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_angkot_sekitar, container, false);

        rv = (RecyclerView) v.findViewById(R.id.angkotsekitar);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        nomor = new ArrayList<>();

        nomor.add(
                new nomor_lin(
                        "A12"
                )
        );
        nomor.add(
                new nomor_lin(
                        "A13"
                )
        );

        adapter = new nomorAdapter(getActivity(),nomor);
        rv.setAdapter(adapter);
        return v;
    }


}
