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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.FloorPlansAdapter;
import com.octohub.pil4u.Adapter.NearByAdapter;
import com.octohub.pil4u.Adapter.ReviewAdapter;
import com.octohub.pil4u.Model.FloorPlans;
import com.octohub.pil4u.Model.NearBy;
import com.octohub.pil4u.Model.Reviews;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {

    View view ;
    Activity activity;

    ArrayList eduList, reviewList;
    RecyclerView rvEducation, rvTransport, rvHealth, rvReviews;
    NearByAdapter nearByAdapter;
    ReviewAdapter reviewAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.reviews_fragment,container,false);

        intializeEducationRecyclerview();
        initializeRvEducaitonData();

        initlaizeReviewREcyclerVIew();
        initializeRvReviewData();

        return  view;
    }




    private void intializeEducationRecyclerview() {

        rvEducation = view.findViewById(R.id.rvEducation);
        /*rvPlans.setItemAnimator(new DefaultItemAnimator());
        rvPlans.addItemDecoration(new DividerItemDecoration(rvPlans.getContext(), DividerItemDecoration.VERTICAL));*/
        rvEducation.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //  GridLayoutManager manager = new GridLayoutManager(activity,2);
        //rvPlans.setLayoutManager(manager);

        rvHealth = view.findViewById(R.id.rvHealth);
        rvHealth.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        rvTransport = view.findViewById(R.id.rvTransport);
        rvTransport.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


    }

    private void initializeRvEducaitonData() {


        eduList = new ArrayList();
        eduList.add(new NearBy("Eladia's kids(3.13 miles)","4.5", "8897 Reviews"));
        eduList.add(new NearBy("Gear up with ACLS(4.33 miles)","4.0", "7735 Reviews"));
        eduList.add(new NearBy("Brooklyn Brainery(4.56 miles)","4.2", "9015 Reviews"));



        nearByAdapter = new NearByAdapter(eduList);
        rvEducation.setAdapter(nearByAdapter);
        rvHealth.setAdapter(nearByAdapter);
        rvTransport.setAdapter(nearByAdapter);


    }

    private void initlaizeReviewREcyclerVIew() {

        rvReviews = view.findViewById(R.id.rvReviews);
        rvReviews.setItemAnimator(new DefaultItemAnimator());
        rvReviews.addItemDecoration(new DividerItemDecoration(rvReviews.getContext(), DividerItemDecoration.VERTICAL));
        rvReviews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void initializeRvReviewData() {


        reviewList = new ArrayList();
        reviewList.add(new Reviews("Diana Cooper","28th December 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d1));
        reviewList.add(new Reviews("Roberet","15th Jan 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d2));
        reviewList.add(new Reviews("Diana Cooper","28th December 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d1));
        reviewList.add(new Reviews("Roberet","15th Jan 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d2));
        reviewList.add(new Reviews("Diana Cooper","28th December 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d1));
        reviewList.add(new Reviews("Roberet","15th Jan 2019", "Beautiful home, very picturesque and close to everything in jtree! A little warm for a hot weekend, but would love to come back during the cooler seasons!",R.drawable.d2));





        reviewAdapter = new ReviewAdapter(reviewList);
        rvReviews.setAdapter(reviewAdapter);



    }
}
