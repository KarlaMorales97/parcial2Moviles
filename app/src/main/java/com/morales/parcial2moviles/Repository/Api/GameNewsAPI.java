package com.morales.parcial2moviles.Repository.Api;

/**
 * Created by Karla on 04/06/2018.
 */
import com.morales.parcial2moviles.Favoritos.Favoritos;
import com.morales.parcial2moviles.Repository.Modelo.Game;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GameNewsAPI {


    //URL donde esta ubicada la API
    public  final String URL= "http://gamenewsuca.herokuapp.com";


    //Mandando y recibiendo datos de usuario a la API con el metodo POST
    @FormUrlEncoded
    @POST("/login") Call<String> login(@Field("user") String myUser, @Field("password") String myPassword);


    //Obteniendo datos de /news, la descripcion de cada noticia con el metodo GET y HEADER

    @GET("/news") Call<List<New>> getData(@Header("Authorization") String datos);


    @GET("/news/type/list")
    Call<List<Game>> getGamess(@Header("Authorization") String autorizacion);

    //Obtener a los players con el metodo GET
    @GET("/players")
    Call<List<Player_Games>> getAllPlayers(@Header("Authorization") String authorization);


    //Obtener favoritos con el metodo POST
    @FormUrlEncoded
    @POST("/users/{id}/fav") Call<List<Favoritos>> addFav(@Header("Authorirization") String autorizacion, @Field("new") String n_new);








}
