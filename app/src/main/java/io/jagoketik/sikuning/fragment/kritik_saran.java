package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import io.jagoketik.sikuning.R;

public class kritik_saran extends Fragment {

    Button submit;
    ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_kritik_saran, container, false);
        submit = v.findViewById(R.id.submitKrisar);
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //submit kritik saran
            }
        });
        return v;
    }

}
