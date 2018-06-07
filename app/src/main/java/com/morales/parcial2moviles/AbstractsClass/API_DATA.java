package com.morales.parcial2moviles.AbstractsClass;

/**
 * Created by Karla on 04/06/2018.
 */
import com.morales.parcial2moviles.Login.LoginActivity;
import com.morales.parcial2moviles.Login.login_data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API_DATA {


    public  final String URL= "http://gamenewsuca.herokuapp.com";



   // @GET("/news") Call List<<Data_News>>(@Header getNews("Authotization")) List<Data_News> datos);


    @FormUrlEncoded
    @POST("/login") Call<String> login(@Field("user") String myUser, @Field("password") String myPassword);


}
