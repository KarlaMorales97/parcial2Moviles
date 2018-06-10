package com.morales.parcial2moviles.repository.api;

/**
 * Created by Karla on 04/06/2018.
 */
import com.morales.parcial2moviles.repository.modelo.New;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GameNewsAPI {


    public  final String URL= "http://gamenewsuca.herokuapp.com";

    @GET("/news") Call<List<New>> getData(@Header("Authorization") String datos);

    //Mandando y recibiendo datos de usuario a la API
    @FormUrlEncoded
    @POST("/login") Call<String> login(@Field("user") String myUser, @Field("password") String myPassword);

    //Obteniendo datos de /news, la descripcion de cada noticia



}
