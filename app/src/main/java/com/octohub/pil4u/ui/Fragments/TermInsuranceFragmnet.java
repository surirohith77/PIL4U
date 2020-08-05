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

public class TermInsuranceFragmnet extends Fragment implements
        AdapterView.OnItemSelectedListener{

    View view;
    Activity activity;
    AppCompatSpinner spinnerTobacco,spinnerIncome, spinnerDay, spinnerMonth, spinnerYear;
    private String[] tobacco = { "Select","Yes","No"};
    private String[] income = { "Select","Upto 3 Lac per annum","3 to 5 Lac per annum","5 to 7 Lac per annum","7 to 10 Lac per annum","10 to 15 Lac per annum","15+ Lac per annum"};


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.term_insurance_fragment,container,false);

        RelativeLayout relativeLayout = view.findViewById(R.id.relativeMain);
        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up3);
        relativeLayout.startAnimation(animation1);

        initlizeSpinnerTobacco();
        initlizeSpinnerIncome();
        intialzieDay();
        intialzieMonth();
        intialzieYear();
        return view;
    }


    public void initlizeSpinnerTobacco(){

        spinnerTobacco =  view.findViewById(R.id.spinnerTobacco);
        spinnerTobacco.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,tobacco);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTobacco.setAdapter(aa);
    }

    public void initlizeSpinnerIncome(){

        spinnerIncome =  view.findViewById(R.id.spinnerIncome);
        spinnerIncome.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,income);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerIncome.setAdapter(aa);
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
