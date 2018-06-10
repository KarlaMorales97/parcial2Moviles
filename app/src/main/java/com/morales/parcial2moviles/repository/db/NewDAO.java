package com.morales.parcial2moviles.repository.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.morales.parcial2moviles.repository.modelo.New;

import java.util.List;

/**
 * Created by Karla on 08/06/2018.
 */

@Dao
public interface NewDAO {


    //Metodo para insertar en la base de datos y reemplazar en la misma
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(New noticia);

    //Obtener de la lista de noticias
    @Query("SELECT * FROM  new")
    //Funcion para obtener todas las noticias seleccionadas de las tablas
    LiveData<List<New>> getAllNews();

    //Funcion para obtener noticias por categoria de juego de la base de datos
    @Query("SELECT * FROM  new WHERE game = :game")
    LiveData<List<New>> getAllNews(String game);



}
