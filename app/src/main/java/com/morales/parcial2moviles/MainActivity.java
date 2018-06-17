package com.morales.parcial2moviles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.morales.parcial2moviles.Games.Csgo.ActivityCsgo;
import com.morales.parcial2moviles.Games.Overwatch.ActivityOverwatch;
import com.morales.parcial2moviles.News.AdapterNews;
import com.morales.parcial2moviles.Repository.Api.GameDeserializer;
import com.morales.parcial2moviles.Games.Lol.ActivityLol;
import com.morales.parcial2moviles.Repository.Modelo.New;
import com.morales.parcial2moviles.ViewModels.GamesViewModel;
import com.morales.parcial2moviles.ViewModels.NewsViewModel;
import com.morales.parcial2moviles.ViewModels.PlayerViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<New> newList;
    String token;
//    ArrayList<New> mList;
    private NewsViewModel newsViewModel;
    private GamesViewModel gamesViewModel;
    private PlayerViewModel playerViewModel;
    private List<New> listItem;
    GameDeserializer gameData;
    String game;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        SharedPreferences sharedPreferences = this.getSharedPreferences("mGame", Context.MODE_PRIVATE); //Inicializamos el SharedPreference
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Game","lol");
        editor.apply();


        listItem = new ArrayList<>();
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        gamesViewModel = ViewModelProviders.of(this).get(GamesViewModel.class);
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Buscamos el id del recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final AdapterNews myAdapter = new AdapterNews(getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(gridLayoutManager);

        //Formula modulo que se utiliza para que el cardview sea de columnas de 1 y de 2 dinamicamente
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position%3 == 0){
                    return 2;
                }
                else{
                    return 1;
                }
            }
        });

        //Seteneamos al recyclerView nuestro adapter
        recyclerView.setAdapter(myAdapter);

        //Obtenemos las noticias de la base de datos
        //Funcion declarada en NewDAO
        newsViewModel.getAllNews().observe(this, new Observer<List<New>>() {
            @Override
            public void onChanged(@Nullable List<New> news) {
                //Seteamos las noticias al adapter
                //String bli = news.get(0).getGame().toString();
                //Toast.makeText(getApplication(), bli, Toast.LENGTH_SHORT).show();
                myAdapter.setNews(news);

            }
        });




      /*  playerViewModel.getmPlayers().observe(this, new Observer<List<Player_Games>>() {
            @Override
            public void onChanged(@Nullable List<Player_Games> playerList) {
                String bli = playerList.get(0).getName().toString();
                //Toast.makeText(getBaseContext(), bli, Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.nav_news) {
            // Handle the camera action
        } else if (id == R.id.lol) {

            Bundle args = new Bundle();
            args.putString("game", game);
            Intent intent = new Intent(this, ActivityLol.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.overwatch) {

            Intent intent = new Intent(this, ActivityOverwatch.class);
            startActivity(intent);
            finish();

        }else if(id == R.id.csgo){

            Intent intent = new Intent(this, ActivityCsgo.class);
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_favorites) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
