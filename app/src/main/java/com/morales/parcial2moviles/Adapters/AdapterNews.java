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

import com.morales.parcial2moviles.News.See_Details_GameNews;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Karla on 03/06/2018.
 */

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.myViewHolder> {

    private List<New> mData;
    private Context mContext;


    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView txt_tittle;
        ImageView imageView;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            //Buscando los textView por id
            txt_tittle = (TextView)itemView.findViewById(R.id.new_tittle);
            imageView = (ImageView)itemView.findViewById(R.id.new_image);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);
        }
    }


    //Constructor que tiene el contexto
    public AdapterNews(Context mContext) {
        this.mContext = mContext;
    }

    public AdapterNews(List<New> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        //Inflamos el layout cardview en el cual se muestra cada noticia
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.cardview,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {

        //Buscamos la posicion actual de la lista
        final New newM = mData.get(position);

        //Lo seteamos al texto visual del layout
        holder.txt_tittle.setText(newM.getTitle());

        //Comprobamos si la posicion de la imagen es diferente de nula
        if (!(mData.get(position).getCoverImage() == null)) {
            //Utilizamos la libreria Picasso para manejar las imagenes y el almacenamiento en cache
            Picasso.with(mContext).load(newM
                    .getCoverImage())
                    .error(R.drawable.karla).into(holder.imageView);
        } else {
            //Imagen por default en caso de que la noticia no tenga imagen alguna
            Picasso.with(mContext).load(R.drawable.karla).error(R.drawable.karla).into(holder.imageView);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, See_Details_GameNews.class);
                intent.putExtra("Tittle",newM.getTitle());
                intent.putExtra("Game", newM.getGame());
                intent.putExtra("Body", newM.getBody());
                intent.putExtra("Fecha", newM.getCreated_date());
                intent.putExtra("Imagen", newM.getCoverImage());
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
    public void setNews(List<New> news){
        mData = news;
        notifyDataSetChanged();
    }
    public void setNewsByGame(List<New> news2){


                mData = news2;
                notifyDataSetChanged();


    }

    //Obtenemos el tamanio de la lista
    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else return 0;
    }


}
