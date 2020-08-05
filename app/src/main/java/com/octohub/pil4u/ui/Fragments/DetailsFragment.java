package com.octohub.pil4u.ui.Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.octohub.pil4u.Adapter.FavoritesAdapter;
import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.OffersAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapter;
import com.octohub.pil4u.Adapter.YoutubePlayerAdapter;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.Model.FirstList;
import com.octohub.pil4u.Model.Offers;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.Model.youtubeVideos;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.MainActivity3;
import com.octohub.pil4u.ui.Activities.SplashLocationActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsFragment extends Fragment implements RvListener {

    View view ;
    Activity activity;

    SliderView sliderView;
    private SmarateistSliderAdapter adapter;
    ArrayList sliderLIst;

    ArrayList   offerList;
    OffersAdapter offersAdapter;
    RecyclerView rvOffers;

    ArrayList  propertiesList, youtubeList;
    FeaturedPropertiesAdapter propertiesAdapter;
    RecyclerView  rvPropertires, rvyoutube;
    YoutubePlayerAdapter youtubePlayerAdapter;
    TextView tvDescText, tvViewMore, tvMsg;

    CardView cardPropertyDetails, cardAdditionalDetails;

    ImageView ivNamaskar;
    LottieAnimationView animationView;
    CircleImageView ivUser;

    int counterr = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.details_fragment,container,false);


        intializeViews();

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


        intializePropertiesRecyclerview();
        initializeYoutubeRecylcerview();
        initializeRvProperties();
        initializeRvYoutube();

        intializeTextviewViewMore();

        return  view;
    }


    private void intializeViews() {

        sliderView = view.findViewById(R.id.imageSlider);
        tvDescText = view.findViewById(R.id.tvDescText);
        tvViewMore = view.findViewById(R.id.tvViewMore);

        cardPropertyDetails = view.findViewById(R.id.cardviewProperyDetails);
        cardAdditionalDetails = view.findViewById(R.id.cardviewAdditionalDetails);

        Animation animation2 =
                AnimationUtils.loadAnimation(activity, R.anim.enter_right);
        cardPropertyDetails.startAnimation(animation2);

        Animation animation3 =
                AnimationUtils.loadAnimation(activity, R.anim.lefttoright);
        cardAdditionalDetails.startAnimation(animation3);

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
        rvOffers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
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


    private void intializeTextviewViewMore() {


       // String text = "I tend to shy away from restaurant chains, but wherever I go, PF Chang&apos;s has solidly good food and, like Starbucks, they&apos;re reliable. We were staying in Boston for a week and after a long day and blah blah blah blah...";

     /*   if (text.length()>20) {
            text=text.substring(0,20)+"...";
            tvDescText.setText(Html.fromHtml(text+"<font color='red'> <u>View More</u></font>"));
            tvDescText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }*/

     final String text = "Evans Tower very high demand corner junior one bedroom plus a large balcony boasting full open NYC views. You need to see the views to believe them. Mint condition with new hardwood floors. Lots of closets plus washer and dryer.\n" +
            "Fully furnished. Elegantly appointed condominium unit situated on premier location. PS6. The wide entry hall leads to a large living room with dining area. This expansive 2 bedroom and 2 renovated marble bathroom apartment has great windows. Despite the interior views, the apartments Southern and Eastern exposures allow for lovely natural light to fill every room. The master suite is surrounded by handcrafted milkwork and features incredible walk-in closet and storage space.\n" +
            "Fully furnished. Elegantly appointed condominium unit situated on premier location. PS6. The wide entry hall leads to a large living room with dining area. This expansive 2 bedroom and 2 renovated marble bathroom apartment has great windows. Despite the interior views, the apartments Southern and Eastern exposures allow for lovely natural light to fill every room. The master suite is surrounded by handcrafted milkwork and features incredible walk-in closet and storage space.";

        String formattedText = text.replaceAll("\n", "\n\n");
        SpannableString spannableString = new SpannableString(formattedText);

        Matcher matcher = Pattern.compile("\n\n").matcher(formattedText);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(25, true), matcher.start() + 1, matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
     tvDescText.setText(formattedText);

        tvViewMore.setText(Html.fromHtml("<font color='red'> <u>View More</u></font>"));

     tvViewMore.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             counterr++;

             if (counterr == 1) {
                 tvDescText.setMaxLines(Integer.MAX_VALUE);
                 tvViewMore.setText(Html.fromHtml("<font color='red'> <u>View Less</u></font>"));
                // counterr++;
             } else  if (counterr == 2) {
                 tvDescText.setMaxLines(1);
                 tvViewMore.setText(Html.fromHtml("<font color='red'> <u>View More</u></font>"));
                 counterr = 0;
             }

         }
     });




    }
}
