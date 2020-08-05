package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.BanksAdater;
import com.octohub.pil4u.Adapter.MyNotificationAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.Banks;
import com.octohub.pil4u.Model.MyNotification;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.GetMeThisDealActivity;
import com.octohub.pil4u.utils.SharedViewModel;

import java.util.ArrayList;

public class BanksFragment extends Fragment implements RvListener,
        AdapterView.OnItemSelectedListener {

    Activity activity;
    View view;

    RecyclerView rvBanks;
    ArrayList banksList;
    BanksAdater banksAdater;

    private String[] loanType = { "Select Loan Type","Home Loan","Business Loan","Personal Loan","Car Loan","Insurance"};
    Spinner spinnerTime,spinnerLoanType;

   // private FragmentBankListener listener;
    TextView tvLoanType;
    private SharedViewModel viewModel;


    /*public interface FragmentBankListener {
        void onInputBSent(CharSequence input);
    }*/

    public static BanksFragment newInstance(){
        return new BanksFragment();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
       /* if (context instanceof FragmentBankListener) {
            listener = (FragmentBankListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }*/
    }

 /*   @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
         //   mUserList = getArguments().getString("loan");
            String heading = getArguments().getString("loan");
            Toast.makeText(activity, "" + heading, Toast.LENGTH_SHORT).show();
            tvLoanType.setText(heading);
        }
    }*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.banks_fragment,container,false);

       tvLoanType = view.findViewById(R.id.tvLoanTypeeee);

        initlizeSpinnerLoanTYpe();
        intializebankRecyclerview();
        initializeDataRvBanks();

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                tvLoanType.setText("("+charSequence+")");
            }
        });
    }

    public void initlizeSpinnerLoanTYpe(){

        spinnerLoanType =  view.findViewById(R.id.spinnerLoanType);
        spinnerLoanType.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(activity,android.R.layout.simple_spinner_item,loanType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerLoanType.setAdapter(aa);
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

    private void intializebankRecyclerview() {

        rvBanks = view.findViewById(R.id.rvBanks);
        rvBanks.setHasFixedSize(true);
     //   rvNotify.addItemDecoration(new DividerItemDecoration(rvNotify.getContext(), DividerItemDecoration.VERTICAL));
        rvBanks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


    }

    private void initializeDataRvBanks() {

        banksList = new ArrayList();
        banksList.add(new Banks("8.90 %","10000","3.000 - 20.000","Kotak Mahindra Bank",R.drawable.kotak));
        banksList.add(new Banks("8.40 %","10000","3.000 - 30.000","SBI Home Loans",R.drawable.sbi));
        banksList.add(new Banks("9.25 %","10000","0.000 - 30.000","PNB Housing Finance",R.drawable.pnb));
        banksList.add(new Banks("8.90 %","10000","3.000 - 30.000","Axis Bank",R.drawable.axis));
        banksList.add(new Banks("8.45 %","15000","3.000 - 30.000","HDFC BANK",R.drawable.hdfc));
        banksList.add(new Banks("9.05 %","7500","0.000 - 30.000","ICICI Bank",R.drawable.icici2));

        banksAdater = new BanksAdater(banksList,this);
        rvBanks.setAdapter(banksAdater);

    }

    @Override
    public void Rvclick(View view, int Position) {

        switch (view.getId()){
            case R.id.btnGet:
                startActivity(new Intent(activity, GetMeThisDealActivity.class));

        }

    }



  /*  public void getLoanName(CharSequence newText) {


      //  tvLoanType.setText("("+newText+")");
        //tvLoanType.setText(newText);

        if (newText!=null) {
            Toast.makeText(activity, "" + newText, Toast.LENGTH_SHORT).show();
        }

        //editText.setText(newText);
    }*/

    /*@Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }*/
}
