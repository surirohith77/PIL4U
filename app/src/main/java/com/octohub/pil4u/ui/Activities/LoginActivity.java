package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.shared_prefernece;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRegister;
    private shared_prefernece sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = new shared_prefernece(this);

      /*  if (sp.readloginstatus()){

                startActivity(new Intent(this, MainActivity2.class));
                finish();

        }
*/
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tvRegister:
                startActivity(new Intent(this,RegisterActivity.class));
        }
    }
}