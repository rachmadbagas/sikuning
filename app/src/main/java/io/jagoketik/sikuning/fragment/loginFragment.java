package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.activity.MainMenuActivity;
import io.jagoketik.sikuning.activity.RegisterActivity;
import io.jagoketik.sikuning.activity.sideNavBar;
import io.jagoketik.sikuning.api.RetrofitClient;
import io.jagoketik.sikuning.activity.driver;
import io.jagoketik.sikuning.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class loginFragment extends Fragment{
    private Button daftar, masuk;
    private EditText emailET, passwordET;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        int isdriver = sharedPref.getInt("ISDRIVER", 0);
        if (!token.isEmpty()) {
            Intent as;
            if (isdriver == 1) {
                as = new Intent(getActivity(), driver.class);
            } else {
                as = new Intent(getActivity(), sideNavBar.class);
            }
            startActivity(as);
            getActivity().finish();
        } else {
            emailET = v.findViewById(R.id.emailET);
            passwordET = v.findViewById(R.id.passwordET);

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

                    Boolean Error = false;
                    String email = emailET.getText().toString();
                    String pass = passwordET.getText().toString();

                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        emailET.setError("Email harus sesuai format !!");
                        emailET.requestFocus();
                        Error = true;
                    }

                    if (pass.isEmpty()) {
                        passwordET.setError("Password Harus diisi !!");
                        passwordET.requestFocus();
                        Error = true;
                    }

                    if (!Error) {
                        Call<User> call = RetrofitClient
                                .getInstance()
                                .getApi().doLogin(email, pass);

                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.code() == 200) {
                                    Toast.makeText(getContext(), "selamat datang " + response.body().getUsers_name().toString(), Toast.LENGTH_SHORT).show();

                                    SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor AUTH_USER = sharedPref.edit();
                                    AUTH_USER.putString("ID", response.body().getUsers_id());
                                    AUTH_USER.putString("TOKEN", response.body().getUsers_token());
                                    AUTH_USER.putString("NAME", response.body().getUsers_name());
                                    AUTH_USER.putString("ALAMAT", response.body().getUsers_alamat());
                                    AUTH_USER.putString("EMAIL", response.body().getUsers_email());
                                    AUTH_USER.putString("HP", response.body().getUsers_hp());
                                    AUTH_USER.putInt("ISDRIVER", response.body().getUsers_isdriver());
                                    AUTH_USER.putString("LAST_LOGIN", response.body().getUsers_last_login());
                                    AUTH_USER.putString("CREATED_AT", response.body().getUsers_created_at());
                                    AUTH_USER.commit();

                                    Intent as;
                                    if (response.body().getUsers_isdriver() == 1) {
                                        as = new Intent(getActivity(), driver.class);
                                    } else {
                                        as = new Intent(getActivity(), sideNavBar.class);
                                    }
                                    startActivity(as);
                                    getActivity().finish();

                                } else {
                                    Toast.makeText(getContext(), "Login Gagal , username / password salah", Toast.LENGTH_SHORT).show();
                                }


                            }


                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                t.getStackTrace();
                            }
                        });

                    }

                }
            });

        }

        return v;
    }



}