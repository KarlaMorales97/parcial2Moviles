package com.morales.parcial2moviles.Games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.morales.parcial2moviles.R;
import com.squareup.picasso.Picasso;

public class SeePlayers extends AppCompatActivity {

    //Declarando variables a buscar por id
    ImageView avatarPlayer;
    TextView NombrePlayer, biografiaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_players);

        //Buscando variables por ID
        avatarPlayer = (ImageView) findViewById(R.id.AvatarSee_Player);
        NombrePlayer = (TextView) findViewById(R.id.NombreSee_Player);
        biografiaPlayer = (TextView) findViewById(R.id.BiografiaSee_Player);


        //Recibienedo dato enviados desde el addapter
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String nombre = (String) bundle.getString("Nombre");
            String biografia = (String) bundle.getString("Biografia");
            String avatar = bundle.getString("Avatar");


            if (!(avatar == null)) {
                //Utilizamos la libreria Picasso para manejar las imagenes y el almacenamiento en cache
                Picasso.with(getApplicationContext()).load(avatar)
                        .error(R.drawable.karla).into(avatarPlayer);
            } else {
                //Imagen por default en caso de que la noticia no tenga imagen alguna
                Picasso.with(getApplicationContext()).load(R.drawable.karla).error(R.drawable.karla).into(avatarPlayer);
            }


            NombrePlayer.setText(nombre);
            biografiaPlayer.setText(biografia);

        }
    }
}
