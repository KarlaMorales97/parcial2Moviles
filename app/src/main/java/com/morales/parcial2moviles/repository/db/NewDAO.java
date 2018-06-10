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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(New noticia);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inest(List<New> noticias);

    @Query("SELECT * FROM  new")
    LiveData<List<New>> getAllNews();

    @Query("SELECT * FROM  new WHERE game = :game")
    LiveData<List<New>> getAllNews(String game);



}
