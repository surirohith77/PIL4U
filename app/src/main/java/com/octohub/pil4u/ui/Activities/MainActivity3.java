package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Fragments.AdvFragment;
import com.octohub.pil4u.ui.Fragments.BanksFragment;
import com.octohub.pil4u.ui.Fragments.BottomSearchFragment;
import com.octohub.pil4u.ui.Fragments.InsuranceFragment;
import com.octohub.pil4u.ui.Fragments.InsuranceSearchFragment;
import com.octohub.pil4u.ui.Fragments.LoanFragment;
import com.octohub.pil4u.utils.AccoutUtils;
import com.octohub.pil4u.utils.BottomNavigationViewBehavior;

public class MainActivity3 extends AppCompatActivity  /*implements BanksFragment.FragmentBankListener, LoanFragment.FragmentLoanListener*/{

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager = getSupportFragmentManager();

    TextView tvTool1, tvTool2, tvTool3;
    RelativeLayout relativeToolbar;
    Toolbar toolbar;


    private LoanFragment loanFragment;
    private BanksFragment banksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Toolbar();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frameLayout);


        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        bottomNavigationView.setOnNavigationItemSelectedListener(naviCustoListView);
       /* bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        bottomNavigationView.setItemIconTintList(null);*/
      // bottomNavigationView.setItemIconTintList(null);

      /*  final Fragment fragBottom = new BottomHomeFragment();
        Fragment fragment = fragBottom;
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();

        }*/

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                    new BottomSearchFragment()).commitAllowingStateLoss();
        }

        loanFragment = new LoanFragment();
        banksFragment = new BanksFragment();

     //   Toast.makeText(MainActivity3.this, "HOme", Toast.LENGTH_SHORT).show();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviCustoListView =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;


                    switch (menuItem.getItemId()){



                        case R.id.home:
                           /* final Fragment fragBottom = new BottomHomeFragment();
                            Fragment fragment = fragBottom;*/


                           // menuItem.setIcon(R.drawable.property_bnv);

                        //    menuItem.setIcon(R.drawable.property_bnv);


                            selectedFragment = new BottomSearchFragment();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, selectedFragment).commitAllowingStateLoss();
                          /*  bottomNavigationView.setItemIconTintList(null);
                            menuItem.setIcon(R.drawable.property_bnv);*/
                           // fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();
                            break;

                        case R.id.insurance:
                            //startActivity(new Intent(MainActivity3.this, AdvFragment.class));
                         /*   final Fragment fragmentAdv = new AdvFragment();
                            Fragment fragment2 = fragmentAdv;*/
                          /*  bottomNavigationView.setItemIconTintList(null);
                           menuItem.setIcon(R.drawable.insurance_bnv);*/

                        //    menuItem.setIcon(R.drawable.ic_outline_policy_site);
                            selectedFragment = new InsuranceSearchFragment();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, selectedFragment).commitAllowingStateLoss();

                           /* bottomNavigationView.setItemIconTintList(null);
                            menuItem.setIcon(R.drawable.insurance);*/

                            break;

                        case R.id.loans:
                            //startActivity(new Intent(MainActivity3.this, AdvFragment.class));
                         /*   final Fragment fragmentAdv = new AdvFragment();
                            Fragment fragment2 = fragmentAdv;*/

                         //   menuItem.setIcon(R.drawable.ic_outline_account_balance_24);

                            selectedFragment = new LoanFragment();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, selectedFragment).commitAllowingStateLoss();
                         /*   bottomNavigationView.setItemIconTintList(null);
                            menuItem.setIcon(R.drawable.loan_bnv);*/

                            break;

                        case R.id.advertise:
                          startActivity(new Intent(MainActivity3.this, AdvertiseActivity.class));
                           // startActivity(new Intent(MainActivity3.this, MobileOTPActivity.class));

                          //  menuItem.setIcon(R.drawable.ic_outline_apartment_site);

                           /* selectedFragment = new AdvFragment();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();*/

                         /*   bottomNavigationView.setItemIconTintList(null);
                            menuItem.setIcon(R.drawable.ad_bnv);*/
                            break;
                    }

                    return true;
                }
            };


    private void initializeToolbar() {

        final ImageView ivHeart = findViewById(R.id.ic_heart);
      final ImageView ic_search = findViewById(R.id.ic_search);

        tvTool1 = findViewById(R.id.tvTool1);
        tvTool2 = findViewById(R.id.tvTool2);
        tvTool3 = findViewById(R.id.tvTool3);

        String subLocality = AccoutUtils.getSubLocality(this);
        String address = AccoutUtils.getAddress(this);

        if (!address.equals("")) {

            tvTool1.setVisibility(View.VISIBLE);
            tvTool2.setVisibility(View.VISIBLE);
            tvTool3.setVisibility(View.GONE);

            tvTool1.setText(subLocality);
            tvTool2.setText(address);

        }
        else {

            //   tvTool1.setText("Click here to set address");
            tvTool1.setVisibility(View.GONE);
            tvTool2.setVisibility(View.GONE);

            tvTool3.setVisibility(View.VISIBLE);


        }

        relativeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity3.this, LocationPreferenceActivities.class));
            }
        });

        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation1 =
                        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce1);
                ivHeart.startAnimation(animation1);

                startActivity(new Intent(MainActivity3.this, FavoritesActivity.class));
            }
        });

        ic_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity3.this, SearchviewActivity.class));
            }
        });

    }


    private void Toolbar(){


        toolbar = findViewById(R.id.toolbar);
     /*   ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        relativeToolbar = view.findViewById(R.id.relative_toolbar);*/
        relativeToolbar = findViewById(R.id.relative_toolbar);
        setSupportActionBar(toolbar);
        /*final AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar();*/
        /*.setDisplayHomeAsUpEnabled(true);*/

        initializeToolbar();
    }

 /*   @Override
    protected void onRestart() {
        super.onRestart();
*//*
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                    new BottomSearchFragment()).commitAllowingStateLoss();*//*

        Fragment selectedFragment = null;
        selectedFragment = new BottomSearchFragment();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, selectedFragment).commitAllowingStateLoss();

    }*/

    /* @Override
    public void onInputBSent(CharSequence input) {

    }

    @Override
    public void onInputASent(CharSequence input) {
        banksFragment.getLoanName(input);
    }*/
}