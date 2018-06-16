package com.morales.parcial2moviles.Favoritos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karla on 11/06/2018.
 */


@Entity(tableName = "favoritos")
public class Favoritos {

    private String title;
    private String body;
    private String game;
    private String created_date;
    private String createdDate;

    //Creamos el id para la base de datos y lo nombramos llave primaria
    @PrimaryKey
    @ColumnInfo(name = "_id")
    @SerializedName("_id")
    @NonNull
    private String id;



}
