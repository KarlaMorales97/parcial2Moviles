package com.morales.parcial2moviles.Repository.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karla on 15/06/2018.
 */

@Entity(tableName = "gameCategory")
public class Game {
    @PrimaryKey
    @ColumnInfo(name = "gameCategory")
    @SerializedName("gameCategory")
    @NonNull



    private String gameCategory;

    public Game() {
    }

    public Game(String game) {
        this.gameCategory = game;
    }

    @NonNull
    public String getGameCategory() {
        return gameCategory;
    }

    public void setGameCategory(@NonNull String gameCategory) {
        this.gameCategory = gameCategory;
    }
}
