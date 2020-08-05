package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.octohub.pil4u.R;

public class OthersFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener  {

    Activity activity;
    View view;

    NavigationView navigationView;
    private DrawerLayout drawer;

    Toolbar toolbar;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.others_fragment,container,false);

     /*   activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        toolbar = view.findViewById(R.id.toolbar);
      /*  ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setDisplayHomeAsUpEnabled(true);
*/
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar();
        /*
        Displays back arrow
        .setDisplayHomeAsUpEnabled(true);*/

        drawer = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //  IvIConAnimation();
        toggle.syncState();
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                    new Home2Fragment()).commit();
            navigationView.setCheckedItem(R.id.home);
            navigationView.setItemIconTintList(null);
        }

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));


        return  view;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new Home2Fragment()).commit();
                break;

            case R.id.properties:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyPropertiesFragment()).commit();
                break;

            case R.id.advertise:

                //  Toast.makeText(this, "PurchaseFragment", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyaddsFragment()).commit();
                break;

           /* case R.id.nav_statement:

               // Toast.makeText(this, "Statement", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new StatementDFragment()).commit();
                break;*/

           /* case R.id.action:
                // Toast.makeText(this, "StockFragment", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyActionFragment()).commit();
                break;

            case R.id.notification:
                // Toast.makeText(this, "OrderFragment", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyNotificationFragment()).commit();
                break;*/

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* @Override
    public void onPause() {
        super.onPause();
       // toolbar.hideOverflowMenu();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar();
    }*/
}
