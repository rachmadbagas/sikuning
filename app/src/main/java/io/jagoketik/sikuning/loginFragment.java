package io.jagoketik.sikuning;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class loginFragment extends Fragment implements View.OnClickListener {
    private Button daftar, masuk;
    private EditText username, password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        daftar = (Button) v.findViewById(R.id.daftarBtn);
        masuk = (Button) v.findViewById(R.id.btn_login);
        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.daftarBtn:
                Intent intent = (Intent) new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}