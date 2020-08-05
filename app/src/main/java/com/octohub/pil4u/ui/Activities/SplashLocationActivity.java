package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.AccoutUtils;

public class SplashLocationActivity extends AppCompatActivity {

    TextView tvAddress1, tvAddress2;
    ImageView ivLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_location);

       // ivLocation = findViewById(R.id.ivLocation);
        tvAddress1 = findViewById(R.id.tvAddress1);
        tvAddress2 = findViewById(R.id.tvAddress2);

        String subLocality = AccoutUtils.getSubLocality(this);
        String address = AccoutUtils.getAddress(this);

            tvAddress1.setText(subLocality);
            tvAddress2.setText(address);

   /*     Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        ivLocation.startAnimation(animation1);*/

      /*  Animation animation2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.lefttoright);
        tvAddress1.startAnimation(animation2);

        Animation animation3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.lefttoright);
        tvAddress2.startAnimation(animation3);*/

        long postDelayTime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    startActivity(new Intent(SplashLocationActivity.this, MainActivity3.class));
                    finish();

            }
        }, postDelayTime);


    }
}