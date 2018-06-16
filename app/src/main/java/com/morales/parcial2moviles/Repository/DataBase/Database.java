package com.morales.parcial2moviles.Repository.DataBase;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.morales.parcial2moviles.Repository.DataBase.News.NewDAO;
import com.morales.parcial2moviles.Repository.DataBase.Players.PlayersDAO;
import com.morales.parcial2moviles.Repository.Modelo.Game;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

/**
 * Created by Karla on 08/06/2018.
 */

@android.arch.persistence.room.Database(entities = {New.class, Game.class, Player_Games.class}, version = 1)
//Creamos metodo abstracto que extiende de room
public abstract class Database extends RoomDatabase {

    //Inicializamos el DAO
    public abstract NewDAO newDAO();
    public abstract PlayersDAO playersDao();

    //Instanciamos la base de datos
    private static Database INSTANCE;

    public static Database getDatabase(final Context context) {
        //Verificamos si la instancia es nula
        if (INSTANCE == null) {

            //Es una instancia la cual pregunta si no hay otro trhead actuando
            //Se sincroniza la clase actual de base de datos
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    //Si la instancia es nula entonces obtenemos el contexto de la aplicacion y lo construimos
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "new_database")
                            .build();
                }
            }
        }
        //Retornamos la instancia
        return INSTANCE;
    }

}
