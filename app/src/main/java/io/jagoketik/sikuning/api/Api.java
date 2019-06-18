package io.jagoketik.sikuning.api;

import java.util.List;

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

    @GET("/angkot/kode")
    Call<List<angkot>> getkodeangkot();

}
