package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.octohub.pil4u.R;

public class TravelInsuranceFragmnet extends Fragment implements
        AdapterView.OnItemSelectedListener{

    View view;
    Activity activity;

    AppCompatSpinner spinnerTravelling,spinnerCoverAmt, spinnerDay, spinnerMonth, spinnerYear;
    private String[] travelling = { "Select","Worldwide (Excluding US and Canada)","Worldwide (Including US and Canada)"};
    private String[] coverAmount = { "Select","0.5 to 5.0 Lacs"};



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.travel_insurance_fragmnet,container,false);

        RelativeLayout relativeLayout = view.findViewById(R.id.relativeMain);
        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up3);
        relativeLayout.startAnimation(animation1);

        initlizeSpinnertravelling();
        initlizeSpinnerCoverAmt();
        intialzieDay();
        intialzieMonth();
        intialzieYear();
        return view;
    }

    public void initlizeSpinnertravelling(){

        spinnerTravelling =  view.findViewById(R.id.spinnerTravelling);
        spinnerTravelling.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,travelling);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTravelling.setAdapter(aa);
    }

    public void initlizeSpinnerCoverAmt(){

        spinnerCoverAmt =  view.findViewById(R.id.spinnerCoverAmt);
        spinnerCoverAmt.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,coverAmount);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCoverAmt.setAdapter(aa);
    }


    private void intialzieDay(){

        spinnerDay = view.findViewById(R.id.spinnerDay);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.day, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapter);
        spinnerDay.setOnItemSelectedListener(this);
    }

    private void intialzieMonth(){

        spinnerMonth = view.findViewById(R.id.spinnerMonth);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.month, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapter);
        spinnerMonth.setOnItemSelectedListener(this);
    }

    private void intialzieYear(){

        spinnerYear = view.findViewById(R.id.spinnerYear);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapter);
        spinnerYear.setOnItemSelectedListener(this);
    }


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
}
