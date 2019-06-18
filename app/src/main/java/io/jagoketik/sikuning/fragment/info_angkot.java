package io.jagoketik.sikuning.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.adapter.angkotAdapter;
import io.jagoketik.sikuning.api.RetrofitClient;
import io.jagoketik.sikuning.model.angkot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                        .add(R.id.menuPanel,new main_usernameFrag())
                        .commit();
            }
        });

//        angkotList = new ArrayList<>();
        rv = (RecyclerView) v.findViewById(R.id.angkotItem);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<angkot>> call = RetrofitClient.getInstance().getApi().getkodeangkot();
        call.enqueue(new Callback<List<angkot>>() {
            @Override
            public void onResponse(Call<List<angkot>> call, Response<List<angkot>> response) {
                int resId = R.anim.layout_animation_fall_down;
                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
                rv.setLayoutAnimation(animation);

                angkotList = response.body();
                adapter = new angkotAdapter(getActivity(), angkotList);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<angkot>> call, Throwable t) {

            }
        });

        return v;
    }


}
