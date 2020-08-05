package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.InsuranceAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapterBottomFrag;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.FamilyHealthInsuranceActivity;
import com.octohub.pil4u.ui.Activities.InvestmentPlanActivity;
import com.octohub.pil4u.ui.Activities.TwoWheelerInsuranceActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class InsuranceFragment extends Fragment implements View.OnClickListener{

    Activity activity;
    View view;

    RecyclerView rvInsurance;
    ArrayList insuranceList;
    InsuranceAdapter insuranceAdapter;
    CardView cardHealthInsurance, cardTermInsurance, cardCarInsurance, cardTravelInsurance, cardPensionPlans,
            cardFamily, card2Wheeler, cardInvestmentPlan;

    SliderView sliderView;
    private SmarateistSliderAdapterBottomFrag smarateistSliderAdapter;
    ArrayList sliderLIst;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.insurance_fragment,container,false);

     /*  intializeInsuranceRecyclerview();
       initializeRvInsurance();*/

         intializeSLiderData();
         initialize();

        Fragment someFragment = new HealthInsuranceFragmnet();
       changeFragment(someFragment);
       return  view;

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

    private void initialize() {

        cardInvestmentPlan = view.findViewById(R.id.cardInvestmentPlan);
        card2Wheeler = view.findViewById(R.id.card2Wheeler);
        cardFamily = view.findViewById(R.id.cardFamily);

        cardHealthInsurance = view.findViewById(R.id.cardHealthInsurance);
        cardTermInsurance = view.findViewById(R.id.cardTermInsurance);
        cardCarInsurance = view.findViewById(R.id.cardCarInsurance);
        cardTravelInsurance = view.findViewById(R.id.cardTravelInsurance);
        cardPensionPlans = view.findViewById(R.id.cardPensionPlans);

        cardInvestmentPlan.setOnClickListener(this);
        card2Wheeler.setOnClickListener(this);
        cardFamily.setOnClickListener(this);

        cardHealthInsurance.setOnClickListener(this);
        cardTermInsurance.setOnClickListener(this);
        cardCarInsurance.setOnClickListener(this);
        cardTravelInsurance.setOnClickListener(this);
        cardPensionPlans.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.cardInvestmentPlan:
                startActivity(new Intent(activity, InvestmentPlanActivity.class));
                break;

            case R.id.card2Wheeler:
                startActivity(new Intent(activity, TwoWheelerInsuranceActivity.class));
                break;

            case R.id.cardFamily:
                startActivity(new Intent(activity, FamilyHealthInsuranceActivity.class));
                break;


            case R.id.cardHealthInsurance:

               /* Animation animation1 =
                        AnimationUtils.loadAnimation(activity, R.anim.bounce);
                cardHealthInsurance.startAnimation(animation1);*/
                Fragment someFragment = new HealthInsuranceFragmnet();
                changeFragment(someFragment);
                break;

            case R.id.cardTermInsurance:
               /* Animation animation2 =
                        AnimationUtils.loadAnimation(activity, R.anim.bounce);
                cardTermInsurance.startAnimation(animation2);*/
                Fragment termInsuranceFragmnet = new TermInsuranceFragmnet();
                changeFragment(termInsuranceFragmnet);
                break;

            case R.id.cardCarInsurance:
            /*    Animation animation3 =
                        AnimationUtils.loadAnimation(activity, R.anim.bounce);
                cardCarInsurance.startAnimation(animation3);*/
                Fragment carInsuranceFragmnet = new CarInsuranceFragmnet();
                changeFragment(carInsuranceFragmnet);
                break;

            case R.id.cardTravelInsurance:
            /*    Animation animation4 =
                        AnimationUtils.loadAnimation(activity, R.anim.bounce);
                cardTravelInsurance.startAnimation(animation4);*/
                Fragment travelInsuranceFragmnet = new TravelInsuranceFragmnet();
                changeFragment(travelInsuranceFragmnet);
                break;

            case R.id.cardPensionPlans:
               /* Animation animation5 =
                        AnimationUtils.loadAnimation(activity, R.anim.bounce);
                cardPensionPlans.startAnimation(animation5);*/
                Fragment pensionPlansFragmnet = new PensionPlansFragmnet();
                changeFragment(pensionPlansFragmnet);
                break;
        }
    }

    private void changeFragment(Fragment someFragment){

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
       // transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
        transaction.replace(R.id.user_list_container, someFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();

    }

  /*  private void intializeInsuranceRecyclerview() {

        rvInsurance = view.findViewById(R.id.rvInsurance);
        rvInsurance.setHasFixedSize(true);
      //  rvNotify.addItemDecoration(new DividerItemDecoration(rvNotify.getContext(), DividerItemDecoration.VERTICAL));
        rvInsurance.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
       *//* CardView cardView = view.findViewById(R.id.cardview);
        cardView.setBackgroundResource(R.drawable.cardview_corner_radius);*//*
    }

    private void initializeRvInsurance() {


        insuranceList = new ArrayList();
        insuranceList.add(new Insurance("CB202-2345","25/6/2020","7,652"));
        insuranceList.add(new Insurance("CB202-2346","06/5/2020","27,930"));
        insuranceList.add(new Insurance("CB202-2355","16/6/2020","17,799"));


        insuranceList.add(new Insurance("CB202-2345","25/6/2020","7,652"));
        insuranceList.add(new Insurance("CB202-2346","06/5/2020","27,930"));
        insuranceList.add(new Insurance("CB202-2355","16/6/2020","17,799"));


        insuranceList.add(new Insurance("CB202-2345","25/6/2020","7,652"));
        insuranceList.add(new Insurance("CB202-2346","06/5/2020","27,930"));
        insuranceList.add(new Insurance("CB202-2355","16/6/2020","17,799"));


        insuranceList.add(new Insurance("CB202-2345","25/6/2020","7,652"));
        insuranceList.add(new Insurance("CB202-2346","06/5/2020","27,930"));
        insuranceList.add(new Insurance("CB202-2355","16/6/2020","17,799"));


        insuranceAdapter = new InsuranceAdapter(insuranceList);
        rvInsurance.setAdapter(insuranceAdapter);

    }*/

   /* private void inflateUserListFragment(){
        hideSoftKeyboard();

      *//*  MyNotificationFragment fragment = MyNotificationFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(getString(R.string.intent_user_list), mUserList);
        bundle.putParcelableArrayList(getString(R.string.intent_user_locations), mUserLocations);
        fragment.setArguments(bundle);*//*

        MyNotificationFragment fragment = new MyNotificationFragment();

  *//*      FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
        transaction.replace(R.id.user_list_container, fragment, getString(R.string.fragment_user_list));
        transaction.addToBackStack(getString(R.string.fragment_user_list));
        transaction.commit();*//*

    }*/

 /*   private void hideSoftKeyboard(){
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
*/

}
