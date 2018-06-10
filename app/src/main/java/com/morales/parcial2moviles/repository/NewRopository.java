package com.morales.parcial2moviles.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.morales.parcial2moviles.News.Adapter;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.repository.api.GameNewsAPI;
import com.morales.parcial2moviles.repository.db.DatabaseGameNews;
import com.morales.parcial2moviles.repository.db.NewDAO;
import com.morales.parcial2moviles.repository.modelo.New;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karla on 08/06/2018.
 */

public class NewRopository {
    //Se crea el observable
    private LiveData<List<New>> mNews;
    private NewDAO mDao;
    private GameNewsAPI mAPI;
    private String token;
    Context context;



    //Constructor que recibe una aplicacion

    public NewRopository(Application application) {
        //Inicializamos la base de datos y la obtenemos
        DatabaseGameNews db = DatabaseGameNews.getDatabase(application);
        //Obtenemos el DAO
        mDao = db.newDAO();
        //Insertamos en el DAO las noticias obtenidad
        mNews = mDao.getAllNews();
        //Creamos el shared preferences el cual tiene guardado el token recibido
        SharedPreferences sharedPreferences = application.getSharedPreferences("mToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
    }


    //Se crea un LiveData para obtener los datos actualizados de las noticias
    public LiveData<List<New>> getAllNews() {
        //Funcion que obtiene las noticias recibidas
        getAllNewsAPI();
        return mNews;
    }

    //Funcion que obtiene los datos halados de la API
    private void getAllNewsAPI() {

        //Creamos el retrofit el cual nos ayudara a parsear el JSON automaticamente
        //a POJO
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GameNewsAPI.URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();


        //Creamos el retrofit
        GameNewsAPI apiData = retrofit.create(GameNewsAPI.class);

        //Hacemos una llamada para adquirir el token
        Call<List<New>> data = apiData.getData("Bearded " + token);

        //Hacemos la devolucion de llamada para comprobar que la funcion de lamada fue exitosa
        data.enqueue(new Callback<List<New>>() {

            //Comprobando si la respuesta de inicio de sesion es correcta o no
            @Override
            public void onResponse(Call<List<New>> call, Response<List<New>> response) {
                if (response.isSuccessful()) {
                    List<New> mList = response.body();
                    for (New noticia : mList) {
                        insert(noticia);
                    }
                }
                else if(!response.isSuccessful()){
                    String error = response.errorBody().toString();
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
                }
            }

            //Comprobando si la llamada fallo totalmente
            @Override
            public void onFailure(Call<List<New>> call, Throwable t) {

            }
        });
    }


    //Insertamos la noticia a la base de datos
    public void insert(New noticia) {
        new insertAsyncTask(mDao).execute(noticia);
    }



    //Se crea un insertAsyncTask que es un hilo de segundo plano
    private static class insertAsyncTask extends AsyncTask<New, Void, Void> {

        private NewDAO mAsyncTaskDao;

        insertAsyncTask(NewDAO dao) {
            mAsyncTaskDao = dao;
        }

        //El hilo secundario ejecuta su trabajo dentro de doInBackground
        @Override
        protected Void doInBackground(final New... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
