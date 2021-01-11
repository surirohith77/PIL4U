package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.octohub.pil4u.Adapter.LifeInsuranceAdapter;
import com.octohub.pil4u.Adapter.PopularHousesAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.LifeInsurance;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class LifeInsuranceFragment extends Fragment implements RvListener {


    View view;
    Activity activity;
    ArrayList<LifeInsurance> lifeInsuranceList;
    RecyclerView rvLifeInsurance;
    LifeInsuranceAdapter lifeInsuranceAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_life_insurance, container, false);

        intializLifeInsuranceRecyclerview();
        RvLifeInsurance();

        return view;
    }

    private void intializLifeInsuranceRecyclerview() {

     rvLifeInsurance = view.findViewById(R.id.rvLifeInsurance);
        rvLifeInsurance.setHasFixedSize(true);
        rvLifeInsurance.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void RvLifeInsurance() {


        lifeInsuranceList = new ArrayList();
        lifeInsuranceList.add(new LifeInsurance("whole life insurance","Risk cover life long + loan facility + money on maturity",R.drawable.whole_life));
        lifeInsuranceList.add(new LifeInsurance("Term Insurance","Risk cover (high) for selected Term",R.drawable.term_insurance));
        lifeInsuranceList.add(new LifeInsurance("Money Back Policy","Risk cover + money back on intervals + money on maturity",R.drawable.money_bac));
        lifeInsuranceList.add(new LifeInsurance("Child Plan","Risk cover + money for education, marriage or business",R.drawable.child_education));

        lifeInsuranceList.add(new LifeInsurance("Family insurance","Risk cover + money on maturity",R.drawable.family_insurance));
        lifeInsuranceList.add(new LifeInsurance("ULIP","Risk cover + investment in select shares + money back maturity",R.drawable.ulip));
        lifeInsuranceList.add(new LifeInsurance("Endowment or Pension Plan","pension plan source of pension + with or without coverage of risk",R.drawable.pension_plan));




        lifeInsuranceAdapter = new LifeInsuranceAdapter(lifeInsuranceList,this);
        rvLifeInsurance.setAdapter(lifeInsuranceAdapter);



    }

    @Override
    public void Rvclick(View view, int Position) {

        LifeInsurance lifeInsurance = lifeInsuranceList.get(Position);
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
        TextView tvInsType = bottomSheetDialog.findViewById(R.id.tvInsType);
        tvInsType.setText(title);

        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        tvInsType.startAnimation(animation1);


        bottomSheetDialog.show();

    }
}