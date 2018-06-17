package com.morales.parcial2moviles;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.morales.parcial2moviles.Repository.Modelo.Game;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;
import com.morales.parcial2moviles.Repository.NewRopository;
import com.morales.parcial2moviles.Repository.Modelo.New;

import java.util.List;

/**
 * Created by Karla on 08/06/2018.
 */

public class NewsViewModel extends AndroidViewModel {

    private NewRopository newRopository;

    //Creamos el observable que nos permitira que los datos siempre esten actualizados
    private LiveData<List<New>> mNews;
    private LiveData<List<New>> mNewsbyGame;
    private LiveData<List<New>> mNewsGameLol;
    //Constructor que recibe application
    public NewsViewModel(@NonNull Application application) {
        super(application);
        //Inicializando variable newRopository
        newRopository = new NewRopository(application);
        //Obteniendo las noticias e insertandolas en la lista de LiveData de noticias
        mNews = newRopository.getAllNews();
      //  mNewsbyGame = newRopository.getAllNewsByGame();
        mNewsGameLol = newRopository.getAllNewsLol();
    }

    //La vista de liveData retorna las noticias insertadas
    public LiveData<List<New>> getAllNews(){
        return mNews;
    }
    public LiveData<List<New>> getAllNewsByGame(){
        return mNewsbyGame;
    }
    public LiveData<List<New>> getAllNewsLol(){ return mNewsGameLol; }
}
