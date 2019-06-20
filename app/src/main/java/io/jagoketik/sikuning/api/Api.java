package io.jagoketik.sikuning.api;

import java.util.List;

import io.jagoketik.sikuning.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import io.jagoketik.sikuning.model.angkot;

public interface Api {

    @FormUrlEncoded
    @POST("/user/add")
    Call<ResponseBody> registeruser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password,
            @Field("hp") String hp
    );

    @FormUrlEncoded
    @POST("/user/login")
    Call<User> doLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("/angkot/kode")
    Call<List<angkot>> getkodeangkot();

}
