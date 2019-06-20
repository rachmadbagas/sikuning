package io.jagoketik.sikuning.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.api.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class kritik_saran extends Fragment {

    Button submit;
    ImageView back;
    TextView judulTV, pesanTV;
    String judul, pesan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_kritik_saran, container, false);
        judulTV = v.findViewById(R.id.judul);
        pesanTV = v.findViewById(R.id.pesan);


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
                SharedPreferences sharedPref = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
                String uid = sharedPref.getString("ID", "");
                judul = judulTV.getText().toString();
                pesan = pesanTV.getText().toString();

                if (judul.isEmpty()) {
                    judulTV.setError("judul harus diisi dong");
                    judulTV.requestFocus();
                } else if (pesan.isEmpty()) {
                    pesanTV.setError("pesan harus diisi");
                    pesanTV.requestFocus();
                } else {
                    Call<ResponseBody> call = RetrofitClient.getInstance().getApi().sendkrisar(uid, judul, pesan);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.code() == 200) {
                                Toast.makeText(getContext(), "Berhasil mengirim kritik dan saran , Terimakasih", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getContext(), "Gagal mengirim kritik dan saran , Coba Lagi :P", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.getStackTrace();
                        }
                    });
                }

            }
        });
        return v;
    }

}
