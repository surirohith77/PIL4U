package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.FeaturesAdapter;
import com.octohub.pil4u.Adapter.FloorPlansAdapter;
import com.octohub.pil4u.Model.Features;
import com.octohub.pil4u.Model.FloorPlans;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class PlansFragment extends Fragment {

    View view ;
    Activity activity;


    ArrayList plansList;
    RecyclerView rvPlans;
    FloorPlansAdapter  floorPlansAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity)context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.plans_fragment,container,false);


        intializeFloorpLansRecyclerview();
        initializeRvFLoorPlans();

        return  view;
    }

    private void intializeFloorpLansRecyclerview() {

        rvPlans = view.findViewById(R.id.rvFLoorPlans);
        /*rvPlans.setItemAnimator(new DefaultItemAnimator());
        rvPlans.addItemDecoration(new DividerItemDecoration(rvPlans.getContext(), DividerItemDecoration.VERTICAL));*/
        rvPlans.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
      //  GridLayoutManager manager = new GridLayoutManager(activity,2);
        //rvPlans.setLayoutManager(manager);

    }

    private void initializeRvFLoorPlans() {


        plansList = new ArrayList();
        plansList.add(new FloorPlans("First floor","1267 Sqft", "670 Sqft", "530 Sqft","250000"));
        plansList.add(new FloorPlans("Second floor","1267 Sqft", "670 Sqft", "530 Sqft","250000"));
        plansList.add(new FloorPlans("Third floor","1267 Sqft", "670 Sqft", "530 Sqft","250000"));


        floorPlansAdapter = new FloorPlansAdapter(plansList);
        rvPlans.setAdapter(floorPlansAdapter);


    }
}
