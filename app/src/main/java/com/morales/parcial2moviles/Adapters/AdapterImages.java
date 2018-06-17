package com.morales.parcial2moviles.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.morales.parcial2moviles.Games.SeePlayers;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Karla on 16/06/2018.
 */

public class AdapterImages extends RecyclerView.Adapter<AdapterImages.myViewHolder>{

    private List<Player_Games> mPlayer;
    private String imagen;
    private Context mContext;

    public AdapterImages() {

    }


    public static class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            imageView = (CircleImageView) itemView.findViewById(R.id.Imagen_imagenes);
            cardView = (CardView)itemView.findViewById(R.id.cardview_idImagen);
        }
    }


    //Constructor que tiene el contexto
    public AdapterImages(List<Player_Games> playerList, Context mContext) {
        this.mContext = mContext;
        this.mPlayer = playerList;
    }

    public AdapterImages(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public AdapterImages.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        //Inflamos el layout cardview en el cual se muestra cada noticia
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.cardview_images ,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final AdapterImages.myViewHolder holder, final int position) {


        //Buscamos la posicion actual de la lista
        final Player_Games playerM = mPlayer.get(position);


        //Comprobamos si la posicion de la imagen es diferente de nula
        if (!(mPlayer.get(position).getAvatar() == null)) {
            //Utilizamos la libreria Picasso para manejar las imagenes y el almacenamiento en cache
            Picasso.with(mContext).load(playerM
                    .getAvatar())
                    .error(R.drawable.karla).into(holder.imageView);
        } else {
            //Imagen por default en caso de que la noticia no tenga imagen alguna
            Picasso.with(mContext).load(R.drawable.karla).error(R.drawable.karla).into(holder.imageView);
        }

    }

    //Seteamos la lista de noticias y notificamos que ubo un cambio en la lista

    public void setImages(String images) {
        imagen = images;
        notifyDataSetChanged();
    }


    //Obtenemos el tamanio de la lista
    @Override
    public int getItemCount() {
        if (mPlayer != null)
            return mPlayer.size();
        else return 0;
    }
}
