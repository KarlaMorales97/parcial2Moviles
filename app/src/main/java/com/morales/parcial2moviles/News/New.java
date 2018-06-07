package com.morales.parcial2moviles.News;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karla on 06/06/2018.
 */

public class New {

    @SerializedName("_id")
    private String id;

    @SerializedName("created_date")
    private String date;

    @SerializedName("__v")
    private int v;


    private String Token;
    private String tittle;
    private String coverImgae;
    private String description;

}
