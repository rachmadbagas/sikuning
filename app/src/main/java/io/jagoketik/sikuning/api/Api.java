package io.jagoketik.sikuning.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;

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

}
