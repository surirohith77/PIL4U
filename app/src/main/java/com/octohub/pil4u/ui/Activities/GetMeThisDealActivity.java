package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.octohub.pil4u.R;

public class GetMeThisDealActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{

    private String[] time = { "Months","Years"};
    private String[] propertyIdentified = { "Select","Yes","No"};
    private String[] employementCurrently = { "Salaried","Self Employed","Business"};
    private String[] income = { "Monthly","Annually"};
    private String[] city = { "Select City","Bangalore","Chennai","Delhi","Hyderabad","Mumbai","Kolkata"};
    AppCompatSpinner spinnerTime, spinnerProperty, spinnerEmployement, spinnerIncome, spinnerCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_me_this_deal);



        initializeToolbar();

        initlizeSpinnerTIme();
        initlizeSpinnerPropertyIdentified();
        initlizeSpinnerEmployedment();
        initlizeSpinnerIncome();
        initlizeSpinnercity();
    }

    private void initializeToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your Details");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }



    public void initlizeSpinnerTIme(){

        spinnerTime =  findViewById(R.id.spinnerTime);
        spinnerTime.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,time);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTime.setAdapter(aa);
    }

    public void initlizeSpinnerPropertyIdentified(){

        spinnerProperty =  findViewById(R.id.spinnerProperty);
        spinnerProperty.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,propertyIdentified);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerProperty.setAdapter(aa);
    }

    public void initlizeSpinnerEmployedment(){

        spinnerEmployement =  findViewById(R.id.spinnerEmployement);
        spinnerEmployement.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,employementCurrently);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerEmployement.setAdapter(aa);
    }


    public void initlizeSpinnercity(){

        spinnerCity =  findViewById(R.id.spinnerCity);
        spinnerCity.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCity.setAdapter(aa);
    }

    public void initlizeSpinnerIncome(){

        spinnerIncome =  findViewById(R.id.spinnerIncome);
        spinnerIncome.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,income);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerIncome.setAdapter(aa);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

     /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

      //  timeType = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();


    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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