package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.octohub.pil4u.Adapter.FeaturesAdapter;
import com.octohub.pil4u.Adapter.OffersAdapter;
import com.octohub.pil4u.Adapter.RecentSearchesAdapter;
import com.octohub.pil4u.Model.Features;
import com.octohub.pil4u.Model.RecentSearches;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class SearchviewActivity extends AppCompatActivity {

    ArrayList   recentsList;
    RecentSearchesAdapter recentSearchesAdapter;
    RecyclerView rvRecents;
    int counter= 0;
    RelativeLayout relativeSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        intializeRecentSearchesRecyclerview();
        initializeDataRVRecentSearches();
        intializeSeekbar();

        TextView tvFilter = findViewById(R.id.tvFilter);
       relativeSeek = findViewById(R.id.relativeSeek);

        tvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter ++;

                if (counter ==1){
                    relativeSeek.setVisibility(View.VISIBLE);

                }else {

                    relativeSeek.setVisibility(View.GONE);
                    counter = 0;
                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void intializeRecentSearchesRecyclerview() {

        rvRecents = findViewById(R.id.rvRecentSearches);
        rvRecents.setHasFixedSize(true);
      //  rvRecents.setLayoutManager(new LinearLayoutManager(this));
        rvRecents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

       // GridLayoutManager manager = new GridLayoutManager(this,2);
        //rvRecents.setLayoutManager(manager);
    }

    private void initializeDataRVRecentSearches() {


        recentsList = new ArrayList();
        recentsList.add(new RecentSearches("Villa1",R.drawable.insidehouse2));
        recentsList.add(new RecentSearches("Villa2",R.drawable.insidehouse3));
        recentsList.add(new RecentSearches("Villa3",R.drawable.p3));

        recentsList.add(new RecentSearches("Villa4",R.drawable.p2));
        recentsList.add(new RecentSearches("Villa1",R.drawable.insidehouse2));
        recentsList.add(new RecentSearches("Villa2",R.drawable.insidehouse3));
        recentsList.add(new RecentSearches("Villa3",R.drawable.p3));

        recentsList.add(new RecentSearches("Villa4",R.drawable.p2));


     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        recentSearchesAdapter = new RecentSearchesAdapter(recentsList);
        rvRecents.setAdapter(recentSearchesAdapter);
    }

    private void intializeSeekbar() {

        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar6);

        // get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.textMin6);
        final TextView tvMax = (TextView) findViewById(R.id.textMax6);

        // set properties
        rangeSeekbar
                .setCornerRadius(10f)
                /* .setBarColor(Color.parseColor("#93F9B5"))
                 .setBarHighlightColor(Color.parseColor("#16E059"))*/
                .setMinValue(4000)
                .setMaxValue(8000)
                .setMinStartValue(4000)
                .setMaxStartValue(8000)
                .setSteps(100)
                /* .setLeftThumbDrawable(R.drawable.pil4u_logo5_24dp)
                 .setLeftThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)
                 .setRightThumbDrawable(R.drawable.pil4u_logo5_24dp)
                 .setRightThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)*/
                .setDataType(CrystalRangeSeekbar.DataType.INTEGER)
                .apply();

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue)+"\u20B9");
                tvMax.setText(String.valueOf(maxValue)+"\u20B9");
            }
        });

    }
}