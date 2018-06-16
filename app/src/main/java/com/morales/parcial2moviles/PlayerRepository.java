package com.morales.parcial2moviles;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.morales.parcial2moviles.Repository.Api.GameNewsAPI;
import com.morales.parcial2moviles.Repository.DataBase.Database;
import com.morales.parcial2moviles.Repository.DataBase.Players.PlayersDAO;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karla on 15/06/2018.
 */

public class PlayerRepository {


    private PlayersDAO mDaoPlayer;
    private LiveData<List<Player_Games>> mPlayer;
    private String token;

    public PlayerRepository(Application application) {
        Database db = Database.getDatabase(application);
        mDaoPlayer = db.playersDao();
        mPlayer = mDaoPlayer.getAllPlayers();
        //Creamos el shared preferences el cual tiene guardado el token recibido
        SharedPreferences sharedPreferences = application.getSharedPreferences("mToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");

    }

    //Se crea un LiveData para obtener los datos actualizados de games
    public LiveData<List<Player_Games>> getAllPlayers() {
        //Funcion que obtiene las noticias recibidas
        getAllplayersAPI();
        return mPlayer;
    }


    private void getAllplayersAPI() {
        //Creamos el retrofit el cual nos ayudara a parsear el JSON automaticamente
        //a POJO
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GameNewsAPI.URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();


        //Creamos el retrofit
        GameNewsAPI gameData = retrofit.create(GameNewsAPI.class);


        //Hacemos una llamada para adquirir el token
        Call<List<Player_Games>> allPlayers = gameData.getAllPlayers("Bearded " + token);

        //Hacemos la devolucion de llamada para comprobar que la funcion de lamada fue exitosa
        allPlayers.enqueue(new Callback<List<Player_Games>>() {

            @Override
            public void onResponse(Call<List<Player_Games>> call, Response<List<Player_Games>> response) {
                if (response.isSuccessful()) {
                    List<Player_Games> players = response.body();
                    for (Player_Games player : players) {
                        insert3(player);
                    }
                }
                else if(!response.isSuccessful()){
                }
            }

            @Override
            public void onFailure(Call<List<Player_Games>> call, Throwable t) {
            }

        });
    }

    //Insertamos games a la base de datos
    public void insert3(Player_Games player_games) {
        new insertAsyncTask3(mDaoPlayer).execute(player_games);
    }


    //Se crea un insertAsyncTask que es un hilo de segundo plano GAMEES
    private static class insertAsyncTask3 extends AsyncTask<Player_Games, Void, Void> {

        private PlayersDAO mAsyncTaskDao3;

        insertAsyncTask3(PlayersDAO playersDAO) {
            mAsyncTaskDao3 = playersDAO;
        }

        @Override
        protected Void doInBackground(final Player_Games... players) {
            mAsyncTaskDao3.insert3(players[0]);
            return null;

        }
    }
}
