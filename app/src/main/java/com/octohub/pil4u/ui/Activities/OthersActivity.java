package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Fragments.FurnitureFragment;
import com.octohub.pil4u.ui.Fragments.MyPropertiesFragment;
import com.octohub.pil4u.ui.Fragments.MyaddsFragment;
import com.octohub.pil4u.utils.AccoutUtils;

public class OthersActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    private DrawerLayout drawer;
    Toolbar toolbar;

    TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerview = navigationView.getHeaderView(0);
        tvName = headerview.findViewById(R.id.tvname);
        tvName.setText("Hi, "+ AccoutUtils.getUsername(this));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //  IvIConAnimation();
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                    new FurnitureFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
         //   navigationView.setItemIconTintList(null);
        }


  //      toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

          /*  case R.id.home:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new HomeFragment()).commit();
                break;*/

            case R.id.properties:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyPropertiesFragment()).commit();
                break;

            case R.id.advertise:

                //  Toast.makeText(this, "PurchaseFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyaddsFragment()).commit();
                break;

           /* case R.id.nav_statement:

               // Toast.makeText(this, "Statement", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new StatementDFragment()).commit();
                break;*/

          /*  case R.id.action:
                // Toast.makeText(this, "StockFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyActionFragment()).commit();
                break;

            case R.id.notification:
                // Toast.makeText(this, "OrderFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyNotificationFragment()).commit();
                break;
*/
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
       // navigationView.setItemIconTintList(null);
    }

}