package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.jagoketik.sikuning.R;


public class minta_bantuan extends Fragment {
ImageView back;
TextView panic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_minta_bantuan, container, false);

        back = v.findViewById(R.id.back_button);
        panic = v.findViewById(R.id.panicBtn);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .remove(getFragmentManager().findFragmentById(R.id.menuPanel))
                        .add(R.id.menuPanel,new main_usernameFrag())
                        .commit();
            }
        });

        panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //panic button action
            }
        });


        return v;
    }
}
