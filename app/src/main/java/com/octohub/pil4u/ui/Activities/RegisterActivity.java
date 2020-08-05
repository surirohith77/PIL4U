package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.octohub.pil4u.R;

public class RegisterActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnClickListener{

    private String[] roles = { "Select Role","User","Agent", "Builder"};
    private Spinner spin;
    String roleType;

    AppCompatButton btnMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnMobile = findViewById(R.id.btnMobile);
        btnMobile.setOnClickListener(this);

        initlize();
    }

    public void initlize(){

        spin =  findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,roles);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (!spin.equals("Select Role")){
            roleType = spin.getItemAtPosition(spin.getSelectedItemPosition()).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnMobile:
             // startActivity(new Intent(this,SelectRoleActivity.class));
               startActivity(new Intent(this,MobileNumberActivity.class));
        }

    }
}