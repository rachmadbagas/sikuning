package io.jagoketik.sikuning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class registrationFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button daftar;
    private EditText username,konfirmasiPass,password;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registration, container, false);
        daftar = v.findViewById(R.id.daftarBtn);
        username = v.findViewById(R.id.usernameET);
        password = v.findViewById(R.id.passwordET);
        konfirmasiPass = v.findViewById(R.id.konfirmET);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
