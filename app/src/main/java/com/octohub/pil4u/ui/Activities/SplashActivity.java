package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.AccoutUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String subLocality = AccoutUtils.getSubLocality(this);
        final String address = AccoutUtils.getAddress(this);
        // Delay screen
        long postDelayTime = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (!address.equals("")) {

                    startActivity(new Intent(SplashActivity.this, SplashLocationActivity.class));
                    finish();

                }
                else {

                    startActivity(new Intent(SplashActivity.this, MainActivity3.class));
                    finish();
                }
            }
        }, postDelayTime);


    }
}