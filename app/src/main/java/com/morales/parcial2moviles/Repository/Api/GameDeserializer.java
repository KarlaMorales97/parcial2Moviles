package com.morales.parcial2moviles.Repository.Api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.morales.parcial2moviles.Repository.Modelo.Game;

import java.lang.reflect.Type;

/**
 * Created by Karla on 15/06/2018.
 */

public class GameDeserializer implements JsonDeserializer<Game> {
    public Game games;
    @Override
    public Game deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {



        games = new Game();

        JsonObject JsonObject =  json.getAsJsonObject();

        games.setGameCategory(JsonObject.getAsString());

        return games;
    }
}
