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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
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

public class CalculateEmiFragment extends Fragment implements
        AdapterView.OnItemSelectedListener{

    Activity activity;
    View view;

    private String[] time = { "Months","Years"};

    AppCompatSpinner spinnerTime,spinnerLoanType;

AnyChartView anyChartView ;
    Float ti, emi, TA;

String interest, principal, tenureMonths, timeType;
AppCompatEditText etLoanamt, etTenure, etROI;
Button btnCalculate;
TextView tvTotalpayble, tvMonthlyEMi;

    String[] months = {"Principal Amount","Interest Amount"};
    Float[] earnings ;
    RelativeLayout realtivecalValue;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.caluculate_emi_fragment,container,false);

        anyChartView = view.findViewById(R.id.anychartview);
        etLoanamt = view.findViewById(R.id.etLoanAmt);
        etTenure = view.findViewById(R.id.etTenure);
        etROI = view.findViewById(R.id.etRateofInterest);
        tvTotalpayble = view.findViewById(R.id.tvTotalpayble);
        tvMonthlyEMi = view.findViewById(R.id.tvMonthlyEMi);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        realtivecalValue = view.findViewById(R.id.realtivecalValue);

        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        btnCalculate.startAnimation(animation1);

        initlizeSpinnerEmiTIme();


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
            }
        });


        return  view;
    }

    public void initlizeSpinnerEmiTIme(){

        spinnerTime =  view.findViewById(R.id.spinnerTime);
        spinnerTime.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,time);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTime.setAdapter(aa);
    }

/*    public void initlizeSpinnerLoanTYpe(){

        spinnerLoanType =  view.findViewById(R.id.spinnerLoanType);
        spinnerLoanType.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,loanType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerLoanType.setAdapter(aa);
    }*/

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

     /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

        timeType = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();


    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void calculate() {

        principal =  etLoanamt.getText().toString().trim();
        tenureMonths =  etTenure.getText().toString().trim();
        interest =  etROI.getText().toString().trim();


        if (timeType.equals("Months")){

            float p = Float.parseFloat(principal);
            float i = Float.parseFloat(interest);
            float Months = Float.parseFloat(tenureMonths);
            // float y = Float.parseFloat(st3);
            float Principal = calPric(p);
            float Rate = calInt(i);
            // float Months = calMonth(y);
            float Dvdnt = calDvdnt(Rate, Months);
            float FD = calFinalDvdnt(Principal, Rate, Dvdnt);
            float D = calDivider(Dvdnt);
            emi = calEmi(FD, D);
            TA = calTa(emi, Months);
            ti = calTotalInt(TA, Principal);
        }else {


            float p = Float.parseFloat(principal);
            float i = Float.parseFloat(interest);
            float y = Float.parseFloat(tenureMonths);
          //  float Months = Float.parseFloat(y);
            float Principal = calPric(p);
            float Rate = calInt(i);
            float Months = calMonth(y);
            float Dvdnt = calDvdnt(Rate, Months);
            float FD = calFinalDvdnt(Principal, Rate, Dvdnt);
            float D = calDivider(Dvdnt);
            emi = calEmi(FD, D);
            TA = calTa(emi, Months);
            ti = calTotalInt(TA, Principal);

        }



        setupPieChart();
        realtivecalValue.setVisibility(View.VISIBLE);
        tvMonthlyEMi.setText("₹ "+emi);
        tvTotalpayble.setText("₹ "+TA);
        // result.setText(String.valueOf(emi));
        ///TI.setText(String.valueOf(ti));

    }

    private void setupPieChart() {

        earnings  = new Float[]{Float.valueOf(principal),ti};
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i< months.length ; i++){
            dataEntries.add(new ValueDataEntry(months[i],earnings[i]));

        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }



    public float calPric(float p) {
        return (float)(p);
    }
    public float calInt(float i) {
        return (float)(i / 12 / 100);
    }
    public float calMonth(float y) {
        return (float)(y * 12);
    }
    public float calDvdnt(float Rate, float Months) {
        return (float)(Math.pow(1 + Rate, Months));
    }
    public float calFinalDvdnt(float Principal, float Rate, float Dvdnt) {
        return (float)(Principal * Rate * Dvdnt);
    }
    public float calDivider(float Dvdnt) {
        return (float)(Dvdnt - 1);
    }
    public float calEmi(float FD, Float D) {
        return (float)(FD / D);
    }
    public float calTa(float emi, Float Months) {
        return (float)(emi * Months);
    }
    public float calTotalInt(float TA, float Principal) {
        return (float)(TA - Principal);
    }

}
