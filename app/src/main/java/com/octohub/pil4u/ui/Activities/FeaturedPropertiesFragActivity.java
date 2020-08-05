package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Fragments.DetailsFragment;
import com.octohub.pil4u.ui.Fragments.FeaturesFragment;
import com.octohub.pil4u.ui.Fragments.LocationsFragment;
import com.octohub.pil4u.ui.Fragments.PlansFragment;
import com.octohub.pil4u.ui.Fragments.ReviewsFragment;
import com.octohub.pil4u.ui.Fragments.VideosFragment;

import java.util.ArrayList;
import java.util.List;

public class FeaturedPropertiesFragActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_properties_frag);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Feautre Properties");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initialize();
    }

   /* private void initTOolabr() {

        toolbar = findViewById(R.id.toolbar);
      //  toolbar.setTitle("2 Wheeler Insurance");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_favorites, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;


            case  R.id.ic_favorites:
                Intent intent = new Intent(this,FavoritesActivity.class);
                startActivity(intent);
                return true;

            case  R.id.ic_search:
                // Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(this,SearchviewActivity.class);
                startActivity(intent2);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }


    private void initialize(){

        ViewPager viewPager = findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Details");
        tabName.add("Features");
        tabName.add("Locations");
        tabName.add("Plans");
        tabName.add("Videos");
        tabName.add("Reviews");


        List<Fragment> tabFragment = new ArrayList<>();
        DetailsFragment detailsFragment = new DetailsFragment();
        FeaturesFragment featuresFragment = new FeaturesFragment();
        LocationsFragment locationsFragment = new LocationsFragment();
        PlansFragment plansFragment = new PlansFragment();
        VideosFragment  videosFragment = new VideosFragment();
        ReviewsFragment reviewsFragment = new ReviewsFragment();

        tabFragment.add(detailsFragment);
        tabFragment.add(featuresFragment);
        tabFragment.add(locationsFragment);
        tabFragment.add(plansFragment);
        tabFragment.add(videosFragment);
        tabFragment.add(reviewsFragment);

        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getSupportFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id .tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
       tabLayout.setSelectedTabIndicator(null);

     //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
     //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));

    }


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;

        }


        return super.onOptionsItemSelected(item);
    }*/
}