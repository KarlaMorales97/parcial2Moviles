package com.morales.parcial2moviles.Repository.DataBase.News;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.morales.parcial2moviles.Repository.Modelo.Game;
import com.morales.parcial2moviles.Repository.Modelo.New;

import java.util.List;

/**
 * Created by Karla on 08/06/2018.
 */

@Dao
public interface NewDAO {


    //Metodo para insertar en la base de datos y reemplazar en la misma
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(New noticia);

    //Metodo para insertar en la base de datos y reemplazar en la misma
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert2(Game... juego);

    //Obtener de la lista de noticias
    @Query("SELECT * FROM  new ORDER BY created_date DESC")
    //Funcion para obtener todas las noticias seleccionadas de las tablas
    LiveData<List<New>> getAllNews();


    @Query("SELECT DISTINCT game FROM new ")
    LiveData<List<String>> getGames();

    @Query("SELECT * FROM  gameCategory")
        //Funcion para obtener todas las noticias seleccionadas de las tablas
    LiveData<List<Game>> getAllGames();



    //Funcion para obtener noticias por categoria de juego de la base de datos
    @Query("SELECT * FROM  new WHERE game = :games ORDER BY created_date DESC")
    LiveData<List<New>> getAllNewsByGame(String games);

    @Query("SELECT coverImage FROM  new WHERE game = :games")
    LiveData<String> getAllImagesByGame(String games);




}
