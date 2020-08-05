package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.FeaturesAdapter;
import com.octohub.pil4u.Adapter.OffersAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapter;
import com.octohub.pil4u.Adapter.YoutubePlayerAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.Model.Features;
import com.octohub.pil4u.Model.Offers;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.Model.youtubeVideos;
import com.octohub.pil4u.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeaturesFragment extends Fragment implements RvListener {

    View view ;
    Activity activity;

    SliderView sliderView;
    private SmarateistSliderAdapter adapter;
    ArrayList sliderLIst;

    ArrayList   offerList, featuresList;
    OffersAdapter offersAdapter;
    RecyclerView rvOffers;
    RecyclerView rvFeatures;
    FeaturesAdapter featuresAdapter;

    ArrayList  propertiesList, youtubeList;
    FeaturedPropertiesAdapter propertiesAdapter;
    RecyclerView  rvPropertires, rvyoutube;
    YoutubePlayerAdapter youtubePlayerAdapter;

    ImageView ivNamaskar;
    LottieAnimationView animationView;
    TextView tvMsg;
    CircleImageView ivUser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.features_fragment,container,false);

        sliderView = view.findViewById(R.id.imageSlider);

        adapter = new SmarateistSliderAdapter(activity);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        intializeSLiderData();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });


        long postDelayTime =3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

             animationView = view.findViewById(R.id.animationView);
                 tvMsg = view.findViewById(R.id.tvMsg);
                ivNamaskar = view.findViewById(R.id.ivMan);
                ivUser = view.findViewById(R.id.ivUser);

                //  animationView.setVisibility(View.VISIBLE);
                //  ivNamaskar.setVisibility(View.VISIBLE);
                ivUser.setVisibility(View.VISIBLE);
               // ivNamaskar.setVisibility(View.VISIBLE);
                tvMsg.setVisibility(View.VISIBLE);

                Animation animation3 =
                        AnimationUtils.loadAnimation(activity, R.anim.lefttoright);
                tvMsg.startAnimation(animation3);

                Animation animation4 =
                        AnimationUtils.loadAnimation(activity, R.anim.shake);
                tvMsg.startAnimation(animation4);

            }
        }, postDelayTime);

        CardView cardviewOffers = view.findViewById(R.id.cardviewOffers);

        cardviewOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openBottomsheetview();
            }
        });


        intializeFeatureRecyclerview();
        initializeRvFeatures();

        intializePropertiesRecyclerview();
        initializeYoutubeRecylcerview();
        initializeRvProperties();
        initializeRvYoutube();

        /*ScrollView scrollview = view.findViewById(R.id.scrollview);
        Rect scrollBounds = new Rect();
        scrollview.getHitRect(scrollBounds);
        if (rvFeatures.getLocalVisibleRect(scrollBounds)) {
            // Any portion of the imageView, even a single pixel, is within the visible window
            intializeFeatureRecyclerview();
            initializeRvFeatures();
        } else {
            // NONE of the imageView is within the visible window
        }*/

        return  view;
    }

    private void intializeSLiderData() {

        sliderLIst = new ArrayList();
        sliderLIst.add(new SliderItem("Villa",R.drawable.p5));
        sliderLIst.add(new SliderItem("Villa",R.drawable.p6));
        sliderLIst.add(new SliderItem("Villa",R.drawable.p4));
        sliderLIst.add(new SliderItem("Villa",R.drawable.p7));

        adapter.renewItems(sliderLIst);
    }

    private void openBottomsheetview() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.category_bottomsheet);
        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        rvOffers = bottomSheetDialog.findViewById(R.id.rvOffers);
        TextView tvViewLess = bottomSheetDialog.findViewById(R.id.tvViewLess);

        assert rvOffers != null;
        rvOffers.setHasFixedSize(true);
        rvOffers.setItemAnimator(new DefaultItemAnimator());
        rvOffers.addItemDecoration(new DividerItemDecoration(rvOffers.getContext(), DividerItemDecoration.VERTICAL));
        rvOffers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //  rvOffers.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));

        offerList = new ArrayList();

        offerList.add(new Offers("7.5% Instant Discount Using SBI Credit Cards",R.drawable.sbi_logo));
        offerList.add(new Offers("10% Instant Discount Using ICICI Bank Debit Cards",R.drawable.icici));

        offersAdapter = new OffersAdapter(offerList);
        rvOffers.setAdapter(offersAdapter);

        tvViewLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();

    }

    private void intializeFeatureRecyclerview() {

        rvFeatures = view.findViewById(R.id.rvFeatures);
        rvFeatures.setHasFixedSize(true);
        //rvFeatures.setLayoutManager(new LinearLayoutManager(activity));
        rvFeatures.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
       // GridLayoutManager manager = new GridLayoutManager(activity,2);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false);
        rvFeatures.setLayoutManager(layoutManager);

    }

    private void initializeRvFeatures() {


        featuresList = new ArrayList();
        featuresList.add(new Features("Air Conditioning",2,R.drawable.air_conditioner));
        featuresList.add(new Features("Lawn",2,R.drawable.lawn));
        featuresList.add(new Features("Microwave",2,R.drawable.microwave));

        featuresList.add(new Features("Swimming Pool",2,R.drawable.swimmingpool));
        featuresList.add(new Features("Barbeque",3,R.drawable.barbeque));
        featuresList.add(new Features("TvCable",1,R.drawable.tvcable));

        featuresList.add(new Features("Dryer",5,R.drawable.dryer));
        featuresList.add(new Features("Outdoor Shower",2,R.drawable.shower));
        featuresList.add(new Features("Washer",2,R.drawable.washer));

        featuresList.add(new Features("Gym",2,R.drawable.gym));
        featuresList.add(new Features("Refrigerator",6,R.drawable.refrigerator));
        featuresList.add(new Features("Wifi",2,R.drawable.wifi));

        featuresList.add(new Features("Laundry",3,R.drawable.laundry));
        featuresList.add(new Features("Sauna",2,R.drawable.sauna));
        featuresList.add(new Features("Window Coverings",8,R.drawable.windowcoverings));



     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        featuresAdapter = new FeaturesAdapter(featuresList);
        rvFeatures.setAdapter(featuresAdapter);


    }

    private void initializeYoutubeRecylcerview() {

        rvyoutube = view.findViewById(R.id.rvYoutube);
        rvyoutube.setHasFixedSize(true);
        rvyoutube.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void intializePropertiesRecyclerview() {

        rvPropertires = view.findViewById(R.id.rvProperties);
        rvPropertires.setHasFixedSize(true);
        rvPropertires.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void initializeRvProperties() {

        propertiesList = new ArrayList();
        propertiesList.add(new FeaturedProperties("\u20B935000","Apartment","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p7));
        propertiesList.add(new FeaturedProperties("\u20B913000","Individual House","Beds: 4","Baths: 2","sq ft: 7200",R.drawable.p4));
        propertiesList.add(new FeaturedProperties("\u20B915000","Villa","Beds: 5","Baths: 3","sq ft: 10250",R.drawable.p5));

     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        propertiesAdapter = new FeaturedPropertiesAdapter(this,propertiesList);
        rvPropertires.setAdapter(propertiesAdapter);

    }


    private void initializeRvYoutube() {

        youtubeList = new ArrayList();
        youtubeList.add(new youtubeVideos("SHUJ_qZKo_I"));
        youtubeList.add(new youtubeVideos("SCJYbJBqDIo"));
        youtubeList.add(new youtubeVideos("DhBPFr3RRso"));

     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        youtubePlayerAdapter = new YoutubePlayerAdapter(youtubeList);
        rvyoutube.setAdapter(youtubePlayerAdapter);

    }


    @Override
    public void Rvclick(View view, int Position) {

    }

}
