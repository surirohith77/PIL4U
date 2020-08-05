package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;
import com.octohub.pil4u.R;

import java.util.Calendar;

public class CheckCivilScoreActivity extends AppCompatActivity {

    DatePickerDialog.OnDateSetListener mDateSetListener ;
    TextView   tvDob, tvDobSelect ;
    HalfGauge halfGauge;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_civil_score);

        initializeToolbar();

        tvDob = findViewById(R.id.tvDob);
        tvDobSelect = findViewById(R.id.tvDobSelect);
        btnSubmit = findViewById(R.id.btnSubmit);

        halfGauge = findViewById(R.id.halfgauge);
        setHalfGauge();

        tvDobSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openCalendar();
            }
        });

    //    HalfGauge halfGauge = new HalfGauge(this);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //setHalfGauge();
                Range range  = new  Range();
                range.setColor( Color.parseColor("#ce0000"));
                range.setFrom(600.0);
                range.setTo(700.0);

                Range range2  = new  Range();
                range2.setColor( Color.parseColor("#E3E500"));
                range2.setFrom(700.0);
                range2.setTo(800.0);

                Range range3  = new  Range();
                range3.setColor( Color.parseColor("#00b20b"));
                range3.setFrom(800.0);
                range3.setTo(900.0);

                halfGauge.addRange(range);
                halfGauge.addRange(range2);
                halfGauge.addRange(range3);

                halfGauge.setMinValue(600.0);
                halfGauge.setMaxValue(900.0);
                halfGauge.setValue(780.0);
            }
        });


    }

    private void setHalfGauge() {

        Range range  = new  Range();
        range.setColor( Color.parseColor("#ce0000"));
        range.setFrom(600.0);
        range.setTo(700.0);

        Range range2  = new  Range();
        range2.setColor( Color.parseColor("#E3E500"));
        range2.setFrom(700.0);
        range2.setTo(800.0);

        Range range3  = new  Range();
        range3.setColor( Color.parseColor("#00b20b"));
        range3.setFrom(800.0);
        range3.setTo(900.0);

        halfGauge.addRange(range);
        halfGauge.addRange(range2);
        halfGauge.addRange(range3);

        halfGauge.setMinValue(600.0);
        halfGauge.setMaxValue(900.0);
        halfGauge.setValue(750.0);
    }

    private void initializeToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Check CIVIL");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void openCalendar() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);



        DatePickerDialog dialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                //   Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date =  day+ "/" + month + "/" + year;
                tvDob.setText("DOB : "+date);
            }
        };
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