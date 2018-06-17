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

import com.morales.parcial2moviles.MainActivity;
import com.morales.parcial2moviles.PlayerViewModel;
import com.morales.parcial2moviles.R;
import com.morales.parcial2moviles.Repository.Modelo.Player_Games;

import java.util.List;

public class ActivityGames extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public String game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_games);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Button Back


      getSupportActionBar().setDisplayShowTitleEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        RecyclerView recyclerView;
        AdapterPlayer adapterPlayer;
        PlayerViewModel playerViewModel;
        LinearLayoutManager linearLayoutManager;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String game) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();

            args.putString("game", game);
            fragment.setArguments(args);


            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

     //       PlayerViewModel playerViewModel;
            View rootView = inflater.inflate(R.layout.tab_games, container, false);


       /*     playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);


                //RecyclerView
                //Buscamos el id del recyclerview
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclerviewPlayerID);
                final AdapterPlayer adapterPlayer = new AdapterPlayer(getContext());
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);

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
                }); */


                return rootView;
            }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    GeneralFragment generalFragment= new GeneralFragment();
                    return generalFragment;

                case 1:
                    PlayersFragment playersFragment = new PlayersFragment();
                    return playersFragment;
                case 2:
                    PlayersFragment playersFragment2 = new PlayersFragment();
                    return playersFragment2;

                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
