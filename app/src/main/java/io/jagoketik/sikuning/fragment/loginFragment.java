package io.jagoketik.sikuning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.activity.MainMenuActivity;
import io.jagoketik.sikuning.activity.RegisterActivity;
import io.jagoketik.sikuning.activity.sideNavBar;


public class loginFragment extends Fragment{
    private Button daftar, masuk;
    private EditText username, password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        daftar = (Button) v.findViewById(R.id.btn_regis);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent as = new Intent(getActivity(), RegisterActivity.class);
                startActivity(as);
                getActivity().finish();
            }
        });
        masuk = (Button) v.findViewById(R.id.btn_login);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent as = new Intent(getActivity(), sideNavBar.class);
                startActivity(as);
                getActivity().finish();

            }
        });

        return v;
    }



}