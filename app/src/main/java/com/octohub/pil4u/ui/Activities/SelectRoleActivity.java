package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.AccoutUtils;
import com.octohub.pil4u.utils.shared_prefernece;

import java.util.Objects;

public class SelectRoleActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{


    private String[] roles = { "Select Role","User","Agent", "Builder"};
    private Spinner spin;
    String roleType,username;
    Button btnSave;
    AppCompatEditText etUsernames;

    private shared_prefernece sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);


        sp = new shared_prefernece(this);

        if (sp.readloginstatus()){

            startActivity(new Intent(this, MainActivity3.class));
            finish();

        }

        initlize();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

            }
        });
    }



    public void initlize(){

        spin =  findViewById(R.id.spinner);
        btnSave = findViewById(R.id.btnSave);
        etUsernames = findViewById(R.id.etUsernames);


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

    private void validate() {

      username =  Objects.requireNonNull(etUsernames.getText()).toString().trim();

      if (username.isEmpty()){

          Toast.makeText(this, "User name is empty", Toast.LENGTH_SHORT).show();
          etUsernames.requestFocus();
          return;
      }

        if (roleType.equals("Select Role")){

            Toast.makeText(this, "Please Select the role", Toast.LENGTH_SHORT).show();
            etUsernames.requestFocus();
            return;
        }


      /*  AccoutUtils.setUsername(SelectRoleActivity.this,username);
        AccoutUtils.setRole(SelectRoleActivity.this,roleType);
*/

      setPreferences();

        shared_prefernece sp = new shared_prefernece(this);
        sp.writeloginstatus(true);

        Intent intent = new Intent(SelectRoleActivity.this,MainActivity3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        startActivity(intent);

    }


    private void setPreferences(){

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        sharedPref.edit().putString(getString(R.string.pref_name), username).apply();
        sharedPref.edit().putString(getString(R.string.pref_role), roleType).apply();


    }


}