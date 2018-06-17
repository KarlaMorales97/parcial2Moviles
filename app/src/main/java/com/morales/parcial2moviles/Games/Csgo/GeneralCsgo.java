package com.morales.parcial2moviles.Games.Csgo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v4.app.Fragment;

import com.morales.parcial2moviles.Games.Lol.GeneralLol;
import com.morales.parcial2moviles.MainActivity;
import com.morales.parcial2moviles.News.AdapterNews;
import com.morales.parcial2moviles.ViewModels.NewsViewModel;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.DataBase.News.NewDAO;
import com.morales.parcial2moviles.Repository.Modelo.New;

import java.util.List;

/**
 * Created by Karla on 16/06/2018.
 */

public class GeneralCsgo extends Fragment{
    String game;
    NewDAO newDAO;
    String gamee;
    MainActivity mainActivity;

    public static GeneralLol newInstance(String gamee) {
        GeneralLol fragment = new GeneralLol();
        Bundle args = new Bundle();
        args.putString("game", gamee);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gamee = getArguments().getString("game");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        NewsViewModel newsViewModel;
        View rootView = inflater.inflate(R.layout.content_main, container, false);

        SharedPreferences GameList = getContext().getSharedPreferences("mGame", Context.MODE_PRIVATE);
        game = GameList.getString("Game", "");




        //RecyclerView
        //Buscamos el id del recyclerview
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        final AdapterNews myAdapter = new AdapterNews(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(gridLayoutManager);

        //Formula modulo que se utiliza para que el cardview sea de columnas de 1 y de 2 dinamicamente
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position % 3 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        //Seteneamos al recyclerView nuestro adapter
        recyclerView.setAdapter(myAdapter);




        newsViewModel.getAllNewsCsgo().observe(this, new Observer<List<New>>() {
            @Override
            public void onChanged(@Nullable List<New> news) {
                //Seteamos las noticias al adapter
                myAdapter.setNews(news);


            }
        });


        return rootView;

    }

}
