package com.morales.parcial2moviles.News;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.morales.parcial2moviles.R;

import java.util.List;

/**
 * Created by Karla on 03/06/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {


    private Context mContext;
    private List<Book> mData;

    public Adapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder.txt_tittle.setText(mData.get(position).getTittle());
        holder.book_image.setImageResource(mData.get(position).getThumbal());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Book_Activity.class);
                intent.putExtra("Karla",mData.get(position).getTittle());
                intent.putExtra("Beatriz",mData.get(position).getCategory());
                intent.putExtra("Morales",mData.get(position).getDescription());
                intent.putExtra("Thumball",mData.get(position).getThumbal());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView txt_tittle;
        ImageView book_image;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            txt_tittle = (TextView)itemView.findViewById(R.id.book_tittle);
            book_image = (ImageView)itemView.findViewById(R.id.book_image);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);
        }
    }
}
