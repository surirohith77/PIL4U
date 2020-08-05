package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.octohub.pil4u.R;

public class Login_Voda_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnSendOTP;
    TextView tvResendOTP;
    RelativeLayout relativeOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__voda_);

        btnLogin = findViewById(R.id.btnLogin);
        btnSendOTP = findViewById(R.id.btnSendOTP);
        tvResendOTP = findViewById(R.id.tvResendOTP);
        relativeOTP = findViewById(R.id.relativeOTP);
        tvResendOTP.setText(Html.fromHtml("<u>Resend OTP</u></font>"));

        btnSendOTP.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnSendOTP:
                btnSendOTP.setVisibility(View.GONE);
                relativeOTP.setVisibility(View.VISIBLE);
                break;
            case R.id.btnLogin:
               startActivity(new Intent(this,FeaturedPropertiesFragActivity.class));

              /*  Intent intent = new Intent(LocationPreferenceActivities.this,MainActivity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();*/
                break;
        }
    }

    public void skipto(View view) {

        startActivity(new Intent(this,FeaturedPropertiesFragActivity.class));
    }
}