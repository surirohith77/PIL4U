package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.Adapter.OffersAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapterBottomFrag;
import com.octohub.pil4u.Model.Offers;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.DatePickerFragment;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Insurance2Fragment extends Fragment implements View.OnClickListener/*, DatePickerDialog.OnDateSetListener*/,  AdapterView.OnItemSelectedListener{


    Activity activity;
    View view ;

    CardView cardLife, cardNonLife;
    LinearLayout linearLife, linearNonlife;

    int cardLifeCounter = 0;
    int cardNonLifeCounter = 0;

    SliderView sliderView;
    private SmarateistSliderAdapterBottomFrag smarateistSliderAdapter;
    ArrayList sliderLIst;

    CardView cardInvestment, cardMotor, cardBusinessLoan, cardLic;

    TextView tvDob;

    DatePickerDialog.OnDateSetListener mDateSetListener ;

    private static final String TAG = "Insurance2Fragment";

    private String[] coverFor = { "Select Cover For","1 Adult Only","2 Adults","2 Adults & 1 child","2 Adults & 2 children","2 Adults & 3 children","2 Adults & 4 children"
            ,"1 Adult & 1 child","1 Adult & 2 children","1 Adult & 3 children","1 Adult & 4 children"};

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.insurance2_fragment,container,false);

        //initialize();

        initializeFragments();
        intializeSLiderData();


        return view;
    }

    private void initialize() {

    /*    cardLife = view.findViewById(R.id.cardLife);
        cardNonLife = view.findViewById(R.id.cardNonLife);

        cardInvestment = view.findViewById(R.id.cardInvestment);
        cardMotor = view.findViewById(R.id.cardMotor);
        cardBusinessLoan = view.findViewById(R.id.cardBusinessLoan);
        cardLic = view.findViewById(R.id.cardLic);

        linearLife = view.findViewById(R.id.linearLife);
        linearNonlife = view.findViewById(R.id.linearNonlife);

        cardLife.setOnClickListener(this);
        cardNonLife.setOnClickListener(this);

        cardLic.setOnClickListener(this);
        cardBusinessLoan.setOnClickListener(this);
        cardMotor.setOnClickListener(this);
        cardInvestment.setOnClickListener(this);*/
    }

    private void intializeSLiderData() {

        sliderView = view.findViewById(R.id.imageSlider);

        smarateistSliderAdapter = new SmarateistSliderAdapterBottomFrag(activity);
        sliderView.setSliderAdapter(smarateistSliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderLIst = new ArrayList();
        sliderLIst.add(new SliderItem("Insurance1",R.drawable.insurance_slider1));
        sliderLIst.add(new SliderItem("Insurance2",R.drawable.insurance_slider2));
        sliderLIst.add(new SliderItem("Insurance3",R.drawable.insurance_slider3));
        //sliderLIst.add(new SliderItem("With 4 bed rooms",R.drawable.insidehouse3));

        smarateistSliderAdapter.renewItems(sliderLIst);
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){

       /*     case R.id.cardLife:

            *//*    cardLifeCounter ++;

                if (cardLifeCounter == 1) {*//*
                    linearLife.setVisibility(View.VISIBLE);
                    linearNonlife.setVisibility(View.GONE);
              *//*  } else {

                    linearLife.setVisibility(View.GONE);
                    linearNonlife.setVisibility(View.GONE);
                    cardLifeCounter = 0;
                }*//*

                break;

            case R.id.cardNonLife:

           *//*     cardNonLifeCounter ++;

                if (cardNonLifeCounter == 1) {
*//*
                    linearLife.setVisibility(View.GONE);
                    linearNonlife.setVisibility(View.VISIBLE);

            *//*    }
                else {
                    linearNonlife.setVisibility(View.GONE);
                    linearLife.setVisibility(View.GONE);
                    cardNonLifeCounter = 0;
                }*//*
                break;

            case R.id.cardLic:
                openBottomsheetviewLIC();
                break;

            case R.id.cardBusinessLoan:
               // openBottomsheetviewHealth();
                openBottomsheetviewLIC();
                break;

            case R.id.cardMotor:
              // openBottomsheetviewMOTOR();
                openBottomsheetviewLIC();
                break;

            case R.id.cardInvestment:
               // openBottomsheetviewINVESTMENT();
                 openBottomsheetviewLIC();
                break;
*/
        }

    }


    private void openBottomsheetviewLIC() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.lic_bottom_sheet);


        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

     //   bottomSheetDialog.dismiss();
        tvDob = bottomSheetDialog.findViewById(R.id.tvDob);
        tvDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                


                DatePickerDialog dialog = new DatePickerDialog(
                        activity,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date =  day+ "/" + month + "/" + year;
                tvDob.setText("Date of birth(DOB) "+date);
            }
        };

        AppCompatSpinner spinnerCoverFor;

        spinnerCoverFor =  bottomSheetDialog.findViewById(R.id.spinnerCoverFor);
        spinnerCoverFor.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,coverFor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCoverFor.setAdapter(aa);


        bottomSheetDialog.show();

    }


    private void openBottomsheetviewHealth() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.health_in_bottom_sheet);
        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        //   bottomSheetDialog.dismiss();
        bottomSheetDialog.show();

    }

    private void openBottomsheetviewMOTOR() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.motor_bottom_sheet);
        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        //   bottomSheetDialog.dismiss();
        bottomSheetDialog.show();

    }

    private void openBottomsheetviewINVESTMENT() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.investment_bottom_sheet);
        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        //   bottomSheetDialog.dismiss();
        bottomSheetDialog.show();

    }

 /*   @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        tvDob.setText(currentDateString);

    }*/

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

     /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

    /*   String timeType = spinnerDay.getItemAtPosition(spinnerDay.getSelectedItemPosition()).toString();
        Toast.makeText(activity, ""+timeType, Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void initializeFragments(){

        ViewPager viewPager = view.findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Life Insurance");
        tabName.add("Non Life Insurance");


        List<Fragment> tabFragment = new ArrayList<>();
       /* LifeInsuranceFragment lifeInsuranceFragment = new LifeInsuranceFragment();
        NonLifeInsuranceFragment nonLifeInsuranceFragment = new NonLifeInsuranceFragment();*/

       BanksFragment banksFragment = new BanksFragment();
       CalculateEmiFragment calculateEmiFragment = new CalculateEmiFragment();


        tabFragment.add(banksFragment);
        tabFragment.add(calculateEmiFragment);

        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
        //  tabLayout.setSelectedTabIndicator(null);

        //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
        //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));


        //    cardSearch.setOnClickListener(this);


    }
}
