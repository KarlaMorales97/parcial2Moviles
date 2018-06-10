package com.morales.parcial2moviles;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.morales.parcial2moviles.repository.NewRopository;
import com.morales.parcial2moviles.repository.modelo.New;

import java.util.List;

/**
 * Created by Karla on 08/06/2018.
 */

public class NewsViewModel extends AndroidViewModel {

    private NewRopository newRopository;

    //Creamos el observable que nos permitira que los datos siempre esten actualizados
    private LiveData<List<New>> mNews;


    //Constructor que recibe application
    public NewsViewModel(@NonNull Application application) {
        super(application);
        //Inicializando variable newRopository
        newRopository = new NewRopository(application);
        //Obteniendo las noticias e insertandolas en la lista de LiveData de noticias
        mNews = newRopository.getAllNews();
    }

    //La vista de liveData retorna las noticias insertadas
    public LiveData<List<New>> getAllNews(){
        return mNews;
    }
}
