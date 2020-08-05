package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.octohub.pil4u.R;

public class HealthInsuranceFragmnet extends Fragment  implements
        AdapterView.OnItemSelectedListener{

    View view;
    Activity activity;
    private String[] coverFor = { "Select Cover For","1 Adult Only","2 Adults","2 Adults & 1 child","2 Adults & 2 children","2 Adults & 3 children","2 Adults & 4 children"
            ,"1 Adult & 1 child","1 Adult & 2 children","1 Adults & 3 children","1 Adults & 4 children"};

    AppCompatSpinner spinnerCoverFor,spinnerDay, spinnerMonth, spinnerYear;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.health_insurance_fragment,container,false);

        //TextView tvPlansStart = view.findViewById(R.id.tvPlansStart);
        RelativeLayout relativeLayout = view.findViewById(R.id.relativeMain);
        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up3);
        relativeLayout.startAnimation(animation1);

            initlizeSpinnerCoverFor();
            intialzieDay();
            intialzieMonth();
            intialzieYear();

        return view;
    }

    public void initlizeSpinnerCoverFor(){

        spinnerCoverFor =  view.findViewById(R.id.spinnerCoverFor);
        spinnerCoverFor.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,coverFor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCoverFor.setAdapter(aa);
    }

    private void intialzieDay(){

      spinnerDay = view.findViewById(R.id.spinnerDay);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.day, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapter);
        spinnerDay.setOnItemSelectedListener(this);
     //   spinnerDay.setScrollbarFadingEnabled(false);
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
