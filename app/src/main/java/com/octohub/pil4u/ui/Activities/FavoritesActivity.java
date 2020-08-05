package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.octohub.pil4u.Adapter.FavoriteTilesAdapter;
import com.octohub.pil4u.Adapter.FavoritesAdapter;
import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.YoutubePlayerAdapter;
import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.SwipeToDeleteCallback;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    ArrayList  favoritsList, tilesList;
    FavoritesAdapter favoritesAdapter;
    RecyclerView rvFavorits, rvTiles;
    CoordinatorLayout coordinatorLayout;

    FavoriteTilesAdapter favoriteTilesAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Favorites");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

         coordinatorLayout = findViewById(R.id.coordinatorLayout);

        intializeFavoriteRecyclerview();
        initializeRvFavorites();

       // enableSwipeToDeleteAndUndo();
    }


    private void intializeFavoriteRecyclerview() {

        rvFavorits = findViewById(R.id.rvFavorites);
        rvFavorits.setHasFixedSize(true);
        rvFavorits.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void initializeRvFavorites() {


        favoritsList = new ArrayList();

        AddTOList(favoritsList);

        favoritesAdapter = new FavoritesAdapter(favoritsList);
        rvFavorits.setAdapter(favoritesAdapter);


    }



    private void intializeTilesRecyclerview() {

       // rvFavorits = findViewById(R.id.rvFavoritesTIles);
        rvFavorits.setHasFixedSize(true);
        rvFavorits.setLayoutManager(new LinearLayoutManager(this));

        GridLayoutManager manager = new GridLayoutManager(this,2);
        rvFavorits.setLayoutManager(manager);

     /*   StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rvFavorits.setLayoutManager(staggeredGridLayoutManager);*/

    }

    private void initializeRvTiles() {


        favoritsList = new ArrayList();

        AddTOList(favoritsList);

        favoriteTilesAdapter = new FavoriteTilesAdapter(favoritsList);
        rvFavorits.setAdapter(favoriteTilesAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;

            case  R.id.ic_list:

              //  Toast.makeText(this, "list", Toast.LENGTH_SHORT).show();

                favoritsList.clear();
               // tilesList.clear();
                intializeFavoriteRecyclerview();
                initializeRvFavorites();
             //   enableSwipeToDeleteAndUndo();
                return true;

            case  R.id.ic_tiles:
            //    Toast.makeText(this, "tiles", Toast.LENGTH_SHORT).show();

                favoritsList.clear();
//                tilesList.clear();

                intializeTilesRecyclerview();
                initializeRvTiles();
           //     enableSwipeToDeleteAndUndoTIlesAdapter();
                return true;

            case  R.id.ic_search:
               // Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this,SearchviewActivity.class);
                startActivity(intent);

                return true;
            }


        return super.onOptionsItemSelected(item);
    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();
                final Favorites item = favoritesAdapter.getData().get(position);

                favoritesAdapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        favoritesAdapter.restoreItem(item, position);
                        rvFavorits.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(rvFavorits);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorites, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void AddTOList(ArrayList items){

        items.add(new Favorites("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p7));
        items.add(new Favorites("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p4));
        items.add(new Favorites("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015",R.drawable.p5));
        items.add(new Favorites("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015",R.drawable.insidehouse3));
        items.add(new Favorites("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p7));
        items.add(new Favorites("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p4));
        items.add(new Favorites("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015",R.drawable.p5));
        items.add(new Favorites("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015",R.drawable.insidehouse3));

        items.add(new Favorites("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p7));
        items.add(new Favorites("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p4));
        items.add(new Favorites("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015",R.drawable.p5));
        items.add(new Favorites("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015",R.drawable.insidehouse3));
        items.add(new Favorites("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p7));
        items.add(new Favorites("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015",R.drawable.p4));
        items.add(new Favorites("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015",R.drawable.p5));
        items.add(new Favorites("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015",R.drawable.insidehouse3));


    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     *//*   if (item.getItemId() == R.id.ic_heart) {
            startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
        }*//*

       *//* if (item.getItemId() == R.id.ic_add) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }*//*
      *//*  if (item.getItemId() == R.id.ic_about) {
            startActivity(new Intent(getApplicationContext(),about_mine.class));

        }*//*
        return super.onOptionsItemSelected(item);
    }*/

    private void enableSwipeToDeleteAndUndoTIlesAdapter() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();
                final Favorites item = favoriteTilesAdapter.getData().get(position);

                favoriteTilesAdapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        favoriteTilesAdapter.restoreItem(item, position);
                        rvFavorits.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(rvFavorits);
    }

}