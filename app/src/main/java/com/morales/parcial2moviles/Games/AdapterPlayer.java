package com.morales.parcial2moviles.Games;

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

import com.morales.parcial2moviles.News.See_Details_GameNews;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Karla on 16/06/2018.
 */

public class AdapterPlayer extends RecyclerView.Adapter<AdapterPlayer.myViewHolder>{
    private List<Player_Games> mPlayer;
    private Context mContext;


    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nombre;
        CircleImageView imagen_avatar;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            //Buscando los textView por id
            txt_nombre = (TextView)itemView.findViewById(R.id.Player_name);
            imagen_avatar = (CircleImageView) itemView.findViewById(R.id.Avatar_Player);
            cardView = (CardView)itemView.findViewById(R.id.cardview_idPlayer);
        }
    }


    //Constructor que tiene el contexto
    public AdapterPlayer(List<Player_Games> playerList, Context mContext) {
        this.mContext = mContext;
        this.mPlayer = playerList;
    }

    public AdapterPlayer(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public AdapterPlayer.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        //Inflamos el layout cardview en el cual se muestra cada noticia
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.cardviewplayer,parent,false);
        return new AdapterPlayer.myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final AdapterPlayer.myViewHolder holder, final int position) {


            //Buscamos la posicion actual de la lista
            final Player_Games playerM = mPlayer.get(position);

            //Lo seteamos al texto visual del layout
            holder.txt_nombre.setText(playerM.getName());
            //holder.txt_biografia.setText(playerM.getBiografia());

            //Comprobamos si la posicion de la imagen es diferente de nula
            if (!(mPlayer.get(position).getAvatar() == null)) {
                //Utilizamos la libreria Picasso para manejar las imagenes y el almacenamiento en cache
                Picasso.with(mContext).load(playerM
                        .getAvatar())
                        .error(R.drawable.karla).into(holder.imagen_avatar);
            } else {
                //Imagen por default en caso de que la noticia no tenga imagen alguna
                Picasso.with(mContext).load(R.drawable.karla).error(R.drawable.karla).into(holder.imagen_avatar);
            }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SeePlayers.class);
                intent.putExtra("Nombre",playerM.getName());
                intent.putExtra("Biografia", playerM.getBiografia());
                intent.putExtra("Avatar", playerM.getAvatar());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Book_Activity.class);


                mContext.startActivity(intent);

            }
        });*/
        }

        //Seteamos la lista de noticias y notificamos que ubo un cambio en la lista

    public void setPlayers(List<Player_Games> playerList) {
        mPlayer = playerList;
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
