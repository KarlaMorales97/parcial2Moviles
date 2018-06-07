package com.morales.parcial2moviles.Login;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Karla on 05/06/2018.
 */

public class Token_Login implements JsonDeserializer<String> {


    public String token = "";

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        //OBTENIENDO EL TOKEN POR MEDIO DE UN JSON ALMACENANDO EN UN OBJETO JSON

        if(json.getAsJsonObject()!=null){
            JsonObject getToken = json.getAsJsonObject();
            token= getToken.get("token").getAsString();

        }
        return token;
    }
}
