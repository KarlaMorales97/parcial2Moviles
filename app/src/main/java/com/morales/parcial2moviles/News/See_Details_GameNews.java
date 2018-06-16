package com.morales.parcial2moviles.News;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.squareup.picasso.Picasso;

import java.util.List;

public class See_Details_GameNews extends AppCompatActivity {

    //Declarando variables a buscar por id
    ImageView imagenNew;
    TextView tittleNew, gameNew, body_new, date_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see__details__game_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Buscando variables por ID
        imagenNew = (ImageView) findViewById(R.id.See_Image);
        tittleNew = (TextView) findViewById(R.id.See_Titulo);
        gameNew = (TextView) findViewById(R.id.See_Game);
        body_new = (TextView) findViewById(R.id.See_Body);
        date_new = (TextView) findViewById(R.id.See_Fecha);


        //Recibienedo dato enviados desde el addapter
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String tittle = (String) bundle.getString("Tittle");
            String game = (String) bundle.getString("Game");
            String body = (String) bundle.getString("Body");
            String fecha = (String) bundle.getString("Fecha");
            String image = bundle.getString("Imagen");


            if (!(image == null)) {
                //Utilizamos la libreria Picasso para manejar las imagenes y el almacenamiento en cache
                Picasso.with(getApplicationContext()).load(image)
                        .error(R.drawable.karla).into(imagenNew);
            } else {
                //Imagen por default en caso de que la noticia no tenga imagen alguna
                Picasso.with(getApplicationContext()).load(R.drawable.karla).error(R.drawable.karla).into(imagenNew);
            }


            tittleNew.setText(tittle);
            gameNew.setText(game);
            body_new.setText(body);
            date_new.setText(fecha);

        }
    }


}
