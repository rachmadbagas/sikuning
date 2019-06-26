package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.activity.LoginActivity;
import io.jagoketik.sikuning.activity.sideNavBar;

public class driver_buttons extends Fragment {
    Button logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_driver_buttons, container, false);
        logout = v.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
                SharedPreferences.Editor AUTH_USER = sharedPref.edit();
                AUTH_USER.putString("ID", null);
                AUTH_USER.putString("TOKEN", null);
                AUTH_USER.putString("NAME", null);
                AUTH_USER.putString("ALAMAT", null);
                AUTH_USER.putString("EMAIL", null);
                AUTH_USER.putString("HP", null);
                AUTH_USER.putInt("ISDRIVER", 9999);
                AUTH_USER.putString("LAST_LOGIN", null);
                AUTH_USER.putString("CREATED_AT", null);
                AUTH_USER.commit();
                Intent as = new Intent(getActivity(), LoginActivity.class);
                startActivity(as);
                getActivity().finish();
                Toast.makeText(getContext(),"Berhasil Logout",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }


}
