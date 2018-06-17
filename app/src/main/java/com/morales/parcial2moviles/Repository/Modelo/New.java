package com.morales.parcial2moviles.Repository.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karla on 06/06/2018.
 */

@Entity(tableName = "new")
public class New {

    private String title;
    private String body;
    private String game;
    @SerializedName("created_date")
    private String created_date;
    private String coverImage;
   // private String createdDate;
    private String description;

    //Creamos el id para la base de datos y lo nombramos llave primaria
    @PrimaryKey
    @ColumnInfo(name = "_id")
    @SerializedName("_id")
    @NonNull

    private String id;


    //Constructor usado para los cardview donde se muestra solo la imagen y el titulo de la noticia
    public New(String title, String coverImage) {
        this.title = title;
        this.coverImage = coverImage;
    }

    //Constructor vacio
    public New() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    //GETTERS

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getGame() {
        return game;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getDescription() {
        return description;
    }

    //SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }



    public void setDescription(String description) {
        this.description = description;
    }
}
