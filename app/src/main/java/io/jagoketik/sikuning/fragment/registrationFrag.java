package io.jagoketik.sikuning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.activity.LoginActivity;
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
                register_user();
            }
        });


        return v;
    }


    public void register_user() {
        Boolean Error = false;

        if (name.getText().toString().isEmpty()) {
            name.setError("Nama harus diisi !!");
            name.requestFocus();
            Error = true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError("Email harus sesuai format !!");
            email.requestFocus();
            Error = true;
        }

        if (alamat.getText().toString().isEmpty()) {
            alamat.setError("Alamat harus diisi !!");
            alamat.requestFocus();
            Error = true;
        }

        if (hp.getText().toString().isEmpty()) {
            hp.setError("HP harus diisi !!");
            hp.requestFocus();
            Error = true;
        }

        if (password.getText().toString().isEmpty()) {
            password.setError("Password harus diisi !!");
            password.requestFocus();
            password.setText("");
            Error = true;
        }

        if (!konfirmasiPass.getText().toString().equals(password.getText().toString())) {
            konfirmasiPass.setError("Password Tidak Sama !!");
            konfirmasiPass.requestFocus();
            password.setText("");
            konfirmasiPass.setText("");
            Error = true;
        }


        if (!Error) {
            Call<ResponseBody> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .registeruser(name.getText().toString(), email.getText().toString(), alamat.getText().toString(), password.getText().toString(), hp.getText().toString());

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    try {
                        String s = response.body().string();
                        //parse json
                        JSONObject reader = new JSONObject(s);
                        //get message
                        try {
                            String msg = reader.getString("message").trim();
                            if (!msg.equals("Error")) {
                                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                                Intent as = new Intent(getActivity(), LoginActivity.class);
                                startActivity(as);
                            } else {
                                try {
                                    JSONObject sql = reader.getJSONObject("error");
                                    msg = sql.getString("sqlMessage");
                                    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                                } catch (JSONException j) {
                                    j.printStackTrace();
                                }
                                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException j) {
                        j.printStackTrace();
                    } catch (NullPointerException n) {
                        n.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getContext(), "Koneksi Ke server gagal atau terjadi kesalahan", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
