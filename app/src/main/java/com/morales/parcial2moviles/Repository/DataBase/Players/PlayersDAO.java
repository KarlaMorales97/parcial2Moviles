package com.morales.parcial2moviles.Repository.DataBase.Players;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

/**
 * Created by Karla on 15/06/2018.
 */
@Dao
public interface PlayersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert3(Player_Games players);


    @Query("SELECT * FROM players ORDER BY name DESC")
    LiveData<List<Player_Games>> getAllPlayers();
}
