package io.jagoketik.sikuning.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.adapter.angkotAdapter;
import io.jagoketik.sikuning.model.angkot;

public class info_angkot extends Fragment {
private ImageView back;
RecyclerView rv;
angkotAdapter adapter;

List<angkot> angkotList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info_angkot, null);
        back = v.findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .remove(getFragmentManager().findFragmentById(R.id.menuPanel))
                        .commit();
            }
        });

        angkotList = new ArrayList<>();
        rv = (RecyclerView) v.findViewById(R.id.angkotItem);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        angkotList.add(
                new angkot(
                        "A", new String[]{"F"}
                )
        );

        adapter = new angkotAdapter(getActivity(),angkotList);
        rv.setAdapter(adapter);

        return v;
    }


}
