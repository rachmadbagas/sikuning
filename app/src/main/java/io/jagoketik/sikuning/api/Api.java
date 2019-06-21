package io.jagoketik.sikuning.api;

import java.util.List;

import io.jagoketik.sikuning.model.User;
import io.jagoketik.sikuning.model.mobil_angkot;
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

    @FormUrlEncoded
    @POST("/angkot/sekitar")
    Call<List<mobil_angkot>> getangkot(
            @Field("lat") String lat,
            @Field("long") String longg
    );

    @FormUrlEncoded
    @POST("/krisar/add")
    Call<ResponseBody> sendkrisar(
            @Field("uid") String uid,
            @Field("judul") String judul,
            @Field("pesan") String pesan
    );

    @FormUrlEncoded
    @POST("/bantuan/add")
    Call<ResponseBody> sendbantuan(
            @Field("uid") String uid,
            @Field("lat") Double lat,
            @Field("long") Double longg
    );

    @FormUrlEncoded
    @POST("/order/add")
    Call<ResponseBody> sendorder(
            @Field("uid") String uid,
            @Field("angkotid") String angkotid,
            @Field("lat") Double lat,
            @Field("long") Double longg
    );



}


