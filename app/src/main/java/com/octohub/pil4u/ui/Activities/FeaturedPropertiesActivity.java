package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.YoutubePlayerAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.Model.youtubeVideos;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class FeaturedPropertiesActivity extends AppCompatActivity implements RvListener {


    ArrayList  propertiesList, youtubeList;
    FeaturedPropertiesAdapter propertiesAdapter;
    RecyclerView  rvPropertires, rvyoutube;
    YoutubePlayerAdapter youtubePlayerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_properties);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Feautre Properties");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        intializeFeatureRecyclerview();
        initializeYoutubeRecylcerview();
        initializeRvProperties();
        initializeRvYoutube();
}

    private void initializeYoutubeRecylcerview() {


        rvyoutube = findViewById(R.id.rvYoutube);
        rvyoutube.setHasFixedSize(true);
        rvyoutube.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void intializeFeatureRecyclerview() {

        rvPropertires = findViewById(R.id.rvProperties);
        rvPropertires.setHasFixedSize(true);
        rvPropertires.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void initializeRvProperties() {


        propertiesList = new ArrayList();
        propertiesList.add(new FeaturedProperties("\u20B935000","Apartment","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p7));
        propertiesList.add(new FeaturedProperties("\u20B913000","Individual House","Beds: 4","Baths: 2","sq ft: 7200",R.drawable.p4));
        propertiesList.add(new FeaturedProperties("\u20B915000","Villa","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p5));

     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        propertiesAdapter = new FeaturedPropertiesAdapter(this,propertiesList);
        rvPropertires.setAdapter(propertiesAdapter);


    }



    private void initializeRvYoutube() {


        youtubeList = new ArrayList();
        youtubeList.add(new youtubeVideos("SHUJ_qZKo_I"));
        youtubeList.add(new youtubeVideos("SCJYbJBqDIo"));
        youtubeList.add(new youtubeVideos("DhBPFr3RRso"));

     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        youtubePlayerAdapter = new YoutubePlayerAdapter(youtubeList);
        rvyoutube.setAdapter(youtubePlayerAdapter);


    }

    @Override
    public void Rvclick(View view, int Position) {

    }
}