package com.morales.parcial2moviles.Repository.Api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.lang.reflect.Type;
import java.security.PublicKey;

/**
 * Created by Karla on 15/06/2018.
 */

public class PlayersDeserializer implements JsonDeserializer {
    public Player_Games players;
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        players = new Player_Games();

        JsonObject JsonObject = json.getAsJsonObject();

        players.set_id(JsonObject.get("_id").getAsString());
        players.setName(JsonObject.get("name").getAsString());
        players.setBiografia(JsonObject.get("biografia").getAsString());
        players.setAvatar(JsonObject.get("avatar").getAsString());
        players.setGame(JsonObject.get("game").getAsString());


        return players;


    }
}
