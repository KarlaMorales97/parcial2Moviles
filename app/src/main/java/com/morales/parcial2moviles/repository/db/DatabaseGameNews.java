package com.morales.parcial2moviles.repository.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.morales.parcial2moviles.repository.modelo.New;

/**
 * Created by Karla on 08/06/2018.
 */

@Database(entities = {New.class}, version = 1)
//Creamos metodo abstracto que extiende de room
public abstract class DatabaseGameNews extends RoomDatabase {

    //Inicializamos el DAO
    public abstract NewDAO newDAO();


    //Instanciamos la base de datos
    private static DatabaseGameNews INSTANCE;

    public static DatabaseGameNews getDatabase(final Context context) {
        //Verificamos si la instancia es nula
        if (INSTANCE == null) {

            //Es una instancia la cual pregunta si no hay otro trhead actuando
            //Se sincroniza la clase actual de base de datos
            synchronized (DatabaseGameNews.class) {
                if (INSTANCE == null) {
                    //Si la instancia es nula entonces obtenemos el contexto de la aplicacion y lo construimos
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseGameNews.class, "new_database")
                            .build();
                }
            }
        }
        //Retornamos la instancia
        return INSTANCE;
    }

}
