package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Fragments.AdvFragment;
import com.octohub.pil4u.ui.Fragments.BottomSearchFragment;
import com.octohub.pil4u.ui.Fragments.InsuranceFragment;
import com.octohub.pil4u.ui.Fragments.LoanFragment;
import com.octohub.pil4u.ui.Fragments.OthersFragment;
import com.octohub.pil4u.utils.AccoutUtils;
import com.octohub.pil4u.utils.shared_prefernece;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    TextView tvTool1, tvTool2, tvTool3;
    RelativeLayout relativeToolbar;
    Toolbar toolbar;
    ViewPager viewPager;
    private BottomNavigationView navigation;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     //   initializeToolbar();


        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // navigation.getMenu().findItem(R.id.home).setChecked(true);
        navigation.setItemIconTintList(null);
        //  navigation.getMenu().findItem(R.id.home).setIcon(R.drawable.home);


        viewPager = findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Home");
        tabName.add("Advertise");
        tabName.add("Insurance");
        tabName.add("Loans");
        tabName.add("Others");

        List<Fragment> tabFragment = new ArrayList<>();

        BottomSearchFragment bottomHomeFragment = new BottomSearchFragment();
        AdvFragment advFragment = new AdvFragment();
        LoanFragment loanFragment = new LoanFragment();
        InsuranceFragment insuranceFragment = new InsuranceFragment();
        OthersFragment othersFragment = new OthersFragment();

        tabFragment.add(bottomHomeFragment);
        tabFragment.add(advFragment);
        tabFragment.add(loanFragment);
        tabFragment.add(insuranceFragment);
        tabFragment.add(othersFragment);

        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getSupportFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);
        //  viewPager.setOffscreenPageLimit(2);
        // viewPager.addOnPageChangeListener(this);


        // to stop swiping in view pager
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    private void initializeToolbar() {



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        relativeToolbar = findViewById(R.id.relative_toolbar);

        ImageView ivHeart = findViewById(R.id.ic_heart);


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

                startActivity(new Intent(MainActivity2.this, LocationPreferenceActivities.class));
            }
        });

        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {



            switch (item.getItemId()) {

                case R.id.home:
                    viewPager.setCurrentItem(0);
                    navigation.setItemIconTintList(null);
                    item.setIcon(R.drawable.home);
                    return true;

                case R.id.advertise:
                    viewPager.setCurrentItem(1);
                    navigation.setItemIconTintList(null);
                    item.setIcon(R.drawable.ad);
                    return true;

               /* case R.id.loans:
                    viewPager.setCurrentItem(2);
                    navigation.setItemIconTintList(null);
                    item.setIcon(R.drawable.loans);
                    return true;*/

                case R.id.insurance:
                    viewPager.setCurrentItem(3);
                    navigation.setItemIconTintList(null);
                    item.setIcon(R.drawable.insurance);

                  /*  InsuranceFragment nextFrag= new InsuranceFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.insurance, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();*/
                    return true;

                case R.id.others:
                    viewPager.setCurrentItem(4);
                    navigation.setItemIconTintList(null);
                    item.setIcon(R.drawable.sofa);

                    //  startActivity(new Intent(activity, OthersActivity.class));
                    return true;

            }
            return false;
        }

    };


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /*   if (item.getItemId() == R.id.ic_heart) {
            startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
        }*/

       /* if (item.getItemId() == R.id.ic_add) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }*/
      /*  if (item.getItemId() == R.id.ic_about) {
            startActivity(new Intent(getApplicationContext(),about_mine.class));

        }*/
        return super.onOptionsItemSelected(item);
    }

    // from menu
    public void Logout(MenuItem item) {


        new AlertDialog.Builder(MainActivity2.this)
                .setIcon(R.drawable.cone)
                .setTitle("Signing out")
                .setMessage("Are you sure , All your settings will be erased ? ")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "Data cleared", Toast.LENGTH_LONG).show();

                        FirebaseAuth.getInstance().signOut();

                        AccoutUtils.clearActiveUserDetails(MainActivity2.this);

                        shared_prefernece shared_prefernece = new shared_prefernece(MainActivity2.this);
                        shared_prefernece.writeloginstatus(false);

                        Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        }).create().show();
    }
}