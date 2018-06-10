package com.morales.parcial2moviles.repository.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.morales.parcial2moviles.repository.modelo.New;

import java.lang.reflect.Type;

/**
 * Created by Karla on 06/06/2018.
 */

public class NewDeserializer implements JsonDeserializer<New> {
    public New noticias;
    @Override
    public New deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        noticias = new New();

        //Se crea un objeto Json para recibir objeto de la API

        JsonObject newJsonObject =  json.getAsJsonObject();

        //Se recibe datos del objeto Json y se parsean a string

        noticias.setId(newJsonObject.get("_id").getAsString());
        noticias.setTitle(newJsonObject.get("title").getAsString());
        noticias.setBody(newJsonObject.get("body").getAsString());
        noticias.setGame(newJsonObject.get("game").getAsString());
        noticias.setCreated_date(newJsonObject.get("created_date").getAsString());
        noticias.setCoverImage(newJsonObject.get("coverImage").getAsString());
        noticias.setDescription(newJsonObject.get("description").getAsString());

        return noticias;
    }
}
