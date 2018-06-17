package com.morales.parcial2moviles.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.morales.parcial2moviles.Repository.Modelo.Player_Games;
import com.morales.parcial2moviles.Repository.PlayerRepository;

import java.util.List;

/**
 * Created by Karla on 15/06/2018.
 */

public class PlayerViewModel extends AndroidViewModel{
    private PlayerRepository playerRepository;


    private LiveData<List<Player_Games>> mPlayers;
    private LiveData<List<Player_Games>> mPlayersLol;
    private LiveData<List<Player_Games>> mPlayersOverwatch;
    private LiveData<List<Player_Games>> mPlayersCsgo;

    public PlayerViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application);

        mPlayers = playerRepository.getAllPlayers();
        mPlayersLol = playerRepository.getAllPlayersLol();
        mPlayersOverwatch = playerRepository.getAllPlayersOverwatch();
        mPlayersCsgo = playerRepository.getAllPlayersCsgo();

    }

    public LiveData<List<Player_Games>> getmPlayers(){
        return mPlayers;
    }
    public LiveData<List<Player_Games>> getmPlayersLol(){
        return mPlayersLol;
    }
    public LiveData<List<Player_Games>> getmPlayersOverwatch(){
        return mPlayersOverwatch;
    }
    public LiveData<List<Player_Games>> getmPlayersCsgo(){
        return mPlayersCsgo;
    }
}
