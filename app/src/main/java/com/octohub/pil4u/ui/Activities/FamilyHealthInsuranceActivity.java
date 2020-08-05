package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.octohub.pil4u.R;

public class FamilyHealthInsuranceActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_health_insurance);

        initTOolabr();

    }

    private void initTOolabr() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Family Health Insurance");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

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
}