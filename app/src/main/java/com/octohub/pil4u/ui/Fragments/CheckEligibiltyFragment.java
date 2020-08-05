package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.octohub.pil4u.R;

import java.util.ArrayList;
import java.util.List;

public class CheckEligibiltyFragment extends Fragment implements
        AdapterView.OnItemSelectedListener{

    Activity activity;
    View view;

    private String[] time = { "Months","Years"};
    private String[] employementCurrently = { "Salaried","Self Employed","Business"};
    private String[] income = { "Monthly","Annually"};
    AppCompatSpinner spinnerTime, spinnerProperty, spinnerEmployement, spinnerIncome, spinnerCity;

    String[] months = {"You could borrow upto","Payable Amount"};
    int[] earnings = {6716630,14400000};
    AnyChartView anyChartView ;
    Button btnApplyLoan;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.check_eligibility_fragment,container,false);

        anyChartView = view.findViewById(R.id.anychartview);
        btnApplyLoan = view.findViewById(R.id.btnApplyLoan);


        initlizeSpinnerTIme();
        initlizeSpinnerEmployedment();
        initlizeSpinnerIncome();

        setupPieChart();

        return  view;
    }


    public void initlizeSpinnerTIme(){

        spinnerTime =   view.findViewById(R.id.spinnerTime);
        spinnerTime.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,time);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTime.setAdapter(aa);
    }



    public void initlizeSpinnerEmployedment(){

        spinnerEmployement =   view.findViewById(R.id.spinnerEmployement);
        spinnerEmployement.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,employementCurrently);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerEmployement.setAdapter(aa);
    }




    public void initlizeSpinnerIncome(){

        spinnerIncome =  view.findViewById(R.id.spinnerIncome);
        spinnerIncome.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,income);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerIncome.setAdapter(aa);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

     /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

        //  timeType = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();


    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void setupPieChart() {

       // earnings  = new Float[]{Float.valueOf(principal),ti};
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i< months.length ; i++){
            dataEntries.add(new ValueDataEntry(months[i],earnings[i]));

        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }

}
