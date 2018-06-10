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
public abstract class DatabaseGameNews extends RoomDatabase {

    public abstract NewDAO newDAO();

    private static DatabaseGameNews INSTANCE;

    public static DatabaseGameNews getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseGameNews.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseGameNews.class, "new_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
