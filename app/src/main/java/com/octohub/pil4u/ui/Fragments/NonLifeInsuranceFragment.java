package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.octohub.pil4u.Adapter.LifeInsuranceAdapter;
import com.octohub.pil4u.Adapter.NonLifeInsuranceAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.LifeInsurance;
import com.octohub.pil4u.R;

import java.util.ArrayList;
import java.util.Calendar;


public class NonLifeInsuranceFragment extends Fragment implements RvListener {

    View view;
    Activity activity;
    ArrayList<LifeInsurance> nonlifeInsuranceList;
    RecyclerView rvnonLifeInsurance;
    NonLifeInsuranceAdapter nonLifeInsuranceAdapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view =  inflater.inflate(R.layout.fragment_non_life_insurance, container, false);

      TextView tvHealthIns = view.findViewById(R.id.tvHealthIns);
      tvHealthIns.setText("Health"+"\n"+"Insurance");
        intializNOnLifeInsuranceRecyclerview();
        RvNOnLifeInsurance();

        return view;
    }
    private void intializNOnLifeInsuranceRecyclerview() {

        rvnonLifeInsurance = view.findViewById(R.id.rvnonLifeInsurance);
        rvnonLifeInsurance.setHasFixedSize(true);
        rvnonLifeInsurance.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void RvNOnLifeInsurance() {


        nonlifeInsuranceList = new ArrayList();
        nonlifeInsuranceList.add(new LifeInsurance("Property/ Home insurance","Risk cover life long + loan facility + money on maturity",R.drawable.property_insurance));
        nonlifeInsuranceList.add(new LifeInsurance("Two / four wheeler ","Risk cover (high) for selected Term",R.drawable.four_wheeler));
        nonlifeInsuranceList.add(new LifeInsurance("Heavy Vehicle","Risk cover + money back on intervals + money on maturity",R.drawable.heavy_vechicle));
        nonlifeInsuranceList.add(new LifeInsurance("Cargo Insurance","Risk cover + money for education, marriage or business",R.drawable.cargo));

        nonlifeInsuranceList.add(new LifeInsurance("Disaster Insurance (Fire/ FLood, Earthquake / Mortage)","Risk cover + money on maturity",R.drawable.disaster));
        nonlifeInsuranceList.add(new LifeInsurance("Accidental","Risk cover + investment in select shares + money back maturity",R.drawable.accident));
        nonlifeInsuranceList.add(new LifeInsurance("Travel Insurance","pension plan source of pension + with or without coverage of risk",R.drawable.travel_insurance));


        nonLifeInsuranceAdapter = new NonLifeInsuranceAdapter(nonlifeInsuranceList,this);
        rvnonLifeInsurance.setAdapter(nonLifeInsuranceAdapter);

    }

    @Override
    public void Rvclick(View view, int Position) {

        LifeInsurance lifeInsurance = nonlifeInsuranceList.get(Position);
       String title = lifeInsurance.getTitle();

        //Toast.makeText(getContext(), ""+title, Toast.LENGTH_SHORT).show();

        openBottomInsEnquiry(title);

      /*  switch (view.getId()) {

            Toast.makeText(activity, ""+title, Toast.LENGTH_SHORT).show();

        }*/

    }

    private void openBottomInsEnquiry(String title) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.insurance_enquiry_bottom_sh);


        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        //   bottomSheetDialog.dismiss();
     TextView   tvInsType = bottomSheetDialog.findViewById(R.id.tvInsType);
     tvInsType.setText(title);

        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        tvInsType.startAnimation(animation1);



        bottomSheetDialog.show();

    }
}