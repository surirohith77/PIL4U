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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.AdssAdapter;
import com.octohub.pil4u.Model.Ads;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class MyaddsFragment extends Fragment {

    Activity activity;
    View view;
    RecyclerView rvAds;
    ArrayList adsList;
    AdssAdapter adssAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.myadds_fragment,container,false);

        intializeAdsRecyclerview();
        initializeRvAds();
        return  view;
    }

    private void intializeAdsRecyclerview() {

        rvAds = view.findViewById(R.id.rvAdds);
        rvAds.setHasFixedSize(true);
        rvAds.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void initializeRvAds() {


        adsList = new ArrayList();
        adsList.add(new Ads("\u20B935000","Sainkpuri","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p4));
        adsList.add(new Ads("\u20B913000","Tirumalagiri House","Beds: 4","Baths: 2","sq ft: 7200",R.drawable.insidehouse3));
        adsList.add(new Ads("\u20B915000","Hitec city","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.insidehouse1));
        adsList.add(new Ads("\u20B935000","Sainkpuri","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p5));
        adsList.add(new Ads("\u20B913000","Tirumalagiri House","Beds: 4","Baths: 2","sq ft: 7200",R.drawable.p6));
        adsList.add(new Ads("\u20B915000","Hitec city","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p2));

     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        adssAdapter = new AdssAdapter(adsList);
        rvAds.setAdapter(adssAdapter);



    }
}
