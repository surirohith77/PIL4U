package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {

    Activity activity;
    View view;

    ViewPager viewPager;
    private BottomNavigationView navigation;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.home_fragment,container,false);

        navigation = view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // navigation.getMenu().findItem(R.id.home).setChecked(true);
        navigation.setItemIconTintList(null);
        //  navigation.getMenu().findItem(R.id.home).setIcon(R.drawable.home);


        viewPager = view.findViewById(R.id.vp_content);

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
                getFragmentManager(),
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

       return  view;
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
}
