package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.octohub.pil4u.R;

public class MobileNumberActivity extends AppCompatActivity {

    EditText etMobile;
    AppCompatButton btnSendOTP;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);

        etMobile = findViewById(R.id.et_mobile);
        btnSendOTP = findViewById(R.id.btn_send_otp);

        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              mobileNumber =  etMobile.getText().toString().trim();

              if (mobileNumber.isEmpty()){

                  Toast.makeText(MobileNumberActivity.this, "Mobile number is empty", Toast.LENGTH_SHORT).show();
                  etMobile.requestFocus();
                  return;
              }

                if (mobileNumber.length() != 13){

                    Toast.makeText(MobileNumberActivity.this, "Please check the number", Toast.LENGTH_SHORT).show();
                    etMobile.requestFocus();
                    return;
                }

                Toast.makeText(MobileNumberActivity.this, "OTP Sent to "+mobileNumber, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MobileNumberActivity.this,OTPVerificationActivity.class);
                intent.putExtra("phonenumber",mobileNumber);

            //    AccoutUtils.setMobile_number(this,phonenumber);

                startActivity(intent);

            }
        });

    }

    public void skipto(View view) {

        startActivity(new Intent(this,SelectRoleActivity.class));
    }
}