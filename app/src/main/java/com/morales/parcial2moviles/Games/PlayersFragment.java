package com.morales.parcial2moviles.Games;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.morales.parcial2moviles.PlayerViewModel;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

/**
 * Created by Karla on 16/06/2018.
 */

public class PlayersFragment extends Fragment {

    public PlayersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        PlayerViewModel playerViewModel;
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);


      playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        //RecyclerView
        //Buscamos el id del recyclerview
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclerviewPlayerID);
        final AdapterPlayer adapterPlayer = new AdapterPlayer(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapterPlayer);


        playerViewModel.getmPlayers().observe(this, new Observer<List<Player_Games>>() {
            @Override
            public void onChanged(@Nullable List<Player_Games> players) {
                //Seteamos las noticias al adapter
                //String bli = news.get(0).getGame().toString();
                //Toast.makeText(getApplication(), bli, Toast.LENGTH_SHORT).show();
                adapterPlayer.setPlayers(players);

            }
        });


        return rootView;
    }

    }

