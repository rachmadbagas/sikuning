package io.jagoketik.sikuning.api;

import io.jagoketik.sikuning.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String baseurl = "https://mbakbro.herokuapp.com";
    private static Retrofit retrofit;
    private static RetrofitClient thisinstance;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(thisinstance == null) {
            thisinstance = new RetrofitClient();
        }
        return thisinstance;
    }


    public Api getApi(){
        return retrofit.create(Api.class);
    }



}
