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
import android.widget.GridLayout;
import android.widget.TextView;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.activity.sideNavBar;


public class main_usernameFrag extends Fragment {
    GridLayout username;
    TextView nameTV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_username, container, false);
        nameTV = v.findViewById(R.id.usernameTV);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
        String name = sharedPref.getString("NAME", "");
        nameTV.setText(name);
        username = v.findViewById(R.id.usernameContainer);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;
    }

}
