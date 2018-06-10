package com.morales.parcial2moviles.repository.modelo;

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
    private String created_date;
    private String coverImage;
    private String createdDate;
    private String description;

    @PrimaryKey
    @ColumnInfo(name = "_id")
    @SerializedName("_id")
    @NonNull
    private String id;


    public New(String title, String coverImage) {
        this.title = title;
        this.coverImage = coverImage;
    }

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

    public String getCreatedDate() {
        return createdDate;
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

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
