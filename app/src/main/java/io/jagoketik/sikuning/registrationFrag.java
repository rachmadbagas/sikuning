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
import android.widget.Toast;

import io.jagoketik.sikuning.api.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class registrationFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button daftar;
    private EditText name,email,alamat,hp,konfirmasiPass,password;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registration, container, false);
        daftar = v.findViewById(R.id.daftarBtn);
        name = v.findViewById(R.id.nameET);
        email = v.findViewById(R.id.emailET);
        alamat = v.findViewById(R.id.alamatET);
        hp = v.findViewById(R.id.hpET);
        password = v.findViewById(R.id.passwordET);
        konfirmasiPass = v.findViewById(R.id.konfirmET);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .registeruser(name.getText().toString(),email.getText().toString(),alamat.getText().toString(),password.getText().toString(),hp.getText().toString());

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getContext(),"Berhasil",Toast.LENGTH_SHORT).show();
                        Intent as = new Intent(getActivity(),LoginActivity.class);
                        startActivity(as);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getContext(),"Gagal",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
