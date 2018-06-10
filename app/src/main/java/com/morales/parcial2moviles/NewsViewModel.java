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

    //Creamos el observable que nos permitira que los datos siemore esten actualizados
    private LiveData<List<New>> mNews;


    public NewsViewModel(@NonNull Application application) {
        super(application);
        newRopository = new NewRopository(application);
        mNews = newRopository.getAllNews();
    }

    public LiveData<List<New>> getAllNews(){
        return mNews;
    }
}
