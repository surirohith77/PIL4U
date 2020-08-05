package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.goodiebag.pinview.Pinview;
import com.octohub.pil4u.R;

public class MobileOTPActivity extends AppCompatActivity {

    AppCompatEditText etMobiles;
    String mobileNumber;
ImageView ivArrow;

    Pinview pinview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_o_t_p);


     Toolbar  toolbar = findViewById(R.id.toolbar);
     toolbar.setTitle("Login");
     setSupportActionBar(toolbar);

        etMobiles = findViewById(R.id.etMobiles);
        ivArrow = findViewById(R.id.ivArrow);
        pinview = findViewById(R.id.pinview);

        etMobiles.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                mobileNumber = String.valueOf(s);

                if (mobileNumber.length()==10){

                    ivArrow.setVisibility(View.VISIBLE);

                    Animation animation2 =
                            AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                    ivArrow.startAnimation(animation2);


                }




            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pinview.setVisibility(View.VISIBLE);
            }
        });
    }

    public void skipto(View view) {

        startActivity(new Intent(this,OthersActivity.class));
    }
}