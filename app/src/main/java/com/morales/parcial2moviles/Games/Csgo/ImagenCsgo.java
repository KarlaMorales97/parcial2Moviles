package com.morales.parcial2moviles.Games.Csgo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.morales.parcial2moviles.Adapters.AdapterImages;
import com.morales.parcial2moviles.Adapters.AdapterPlayer;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.morales.parcial2moviles.ViewModels.NewsViewModel;
import com.morales.parcial2moviles.ViewModels.PlayerViewModel;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

/**
 * Created by Karla on 16/06/2018.
 */

public class ImagenCsgo extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        NewsViewModel newsViewModel;
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);


        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        //RecyclerView
        //Buscamos el id del recyclerview
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclerviewPlayerID);
        final AdapterImages adapterImages = new AdapterImages(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapterImages);


        newsViewModel.getAllImagesCsgo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String players) {
                //Seteamos las noticias al adapter
                //String bli = news.get(0).getGame().toString();
                //Toast.makeText(getApplication(), bli, Toast.LENGTH_SHORT).show();
                adapterImages.setImages(players);
            }
        });


        return rootView;
    }
}
