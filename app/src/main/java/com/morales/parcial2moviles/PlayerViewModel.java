package com.morales.parcial2moviles;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

/**
 * Created by Karla on 15/06/2018.
 */

public class PlayerViewModel extends AndroidViewModel{
    private PlayerRepository playerRepository;


    private LiveData<List<Player_Games>> mPlayers;

    public PlayerViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application);

        mPlayers = playerRepository.getAllPlayers();

    }

    public LiveData<List<Player_Games>> getmPlayers(){
        return mPlayers;
    }
}
