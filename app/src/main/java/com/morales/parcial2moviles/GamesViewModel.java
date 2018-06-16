package com.morales.parcial2moviles;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.morales.parcial2moviles.Repository.Modelo.Game;
import com.morales.parcial2moviles.Repository.NewRopository;

import java.util.List;

/**
 * Created by Karla on 15/06/2018.
 */

public class GamesViewModel extends AndroidViewModel{


    private NewRopository newRopositoryGame;


    private LiveData<List<Game>> mGames;

    public GamesViewModel(@NonNull Application application) {
        super(application);
        newRopositoryGame = new NewRopository(application);

        mGames = newRopositoryGame.getAllGames();


    }
    public LiveData<List<Game>> getmGames(){
        return mGames;
    }
}
