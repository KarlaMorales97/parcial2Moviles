package com.morales.parcial2moviles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.morales.parcial2moviles.repository.api.GameNewsAPI;
import com.morales.parcial2moviles.Games.CSGO;
import com.morales.parcial2moviles.Games.Dota;
import com.morales.parcial2moviles.Games.legueLegends;
import com.morales.parcial2moviles.News.Adapter;
import com.morales.parcial2moviles.repository.modelo.New;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<New> newList;
    String token;
    ArrayList<New> mList;
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

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
        final Adapter myAdapter = new Adapter(getApplicationContext());
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
                myAdapter.setNews(news);
            }
        });

        ////////////////////////
/*
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GameNewsAPI.URL).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        GameNewsAPI apiData = retrofit.create(GameNewsAPI.class);
        Call<ArrayList<New>> data = apiData.getData("Beared " + token);
        data.enqueue(new Callback<ArrayList<New>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<New>> call, @NonNull Response<ArrayList<New>> response) {

                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"retrofit " + token,Toast.LENGTH_LONG).show();
                    mList = (ArrayList<New>) response.body();
                    Toast.makeText(getApplicationContext(),mList.get(0).getTitle(),Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),mList.get(0).getBody(),Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),mList.get(0).getGame(),Toast.LENGTH_LONG).show();




                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                    Adapter myAdapter = new Adapter(mList, getApplicationContext());
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    newList = new ArrayList<New>();
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


                    recyclerView.setAdapter(myAdapter);


                }else {
                    Toast.makeText(getApplicationContext(),"MUY MAL MUY MAL",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),token,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<New>> call, @NonNull Throwable t) {

                Toast.makeText(getApplicationContext(),"MAL MAL MAL MAL",Toast.LENGTH_SHORT).show();
            }
        });

*/

        //////////////////////////
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            // Handle the camera action
        } else if (id == R.id.nav_legue) {

            Intent intent = new Intent(MainActivity.this, legueLegends.class);
            startActivity(intent);

        } else if (id == R.id.nav_dota) {

            Intent intent = new Intent(MainActivity.this, Dota.class);
            startActivity(intent);

        } else if (id == R.id.nav_cs) {

            Intent intent = new Intent(MainActivity.this, CSGO.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_favorites) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
