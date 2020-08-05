package com.octohub.pil4u.ui.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.octohub.pil4u.Adapter.BottomMainAdapter;
import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.MainRecAdapter;
import com.octohub.pil4u.Adapter.PopularHousesAdapter;
import com.octohub.pil4u.Adapter.SliderPagerAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapterBottomFrag;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.Bottom_main;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.Model.FirstList;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.FavoritesActivity;
import com.octohub.pil4u.ui.Activities.LocationPreferenceActivities;
import com.octohub.pil4u.ui.Activities.Login_Voda_Activity;
import com.octohub.pil4u.utils.AccoutUtils;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Timer;

public class BottomHomeFragment extends Fragment implements RvListener {

    Activity activity;
    View view;
    ArrayList iconVillas, propertiesList;
    MainRecAdapter adapter;
    FeaturedPropertiesAdapter propertiesAdapter;
    TextView tvTool1, tvTool2, tvTool3;
    RelativeLayout relativeToolbar;

    //using for ads
    PopularHousesAdapter popularHousesAdapter;
    ArrayList  popularHousesList, bottomMainList;

    BottomMainAdapter bottomMainAdapter;

    RecyclerView rv, rvPropertires, rvPopularHOuses, rvRecents, rvBottomdata;
    Toolbar toolbar;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    final int duration = 10;
    final int pixelsToMove = 30;
    LinearLayoutManager layoutManager;

    private ViewPager sliderpager;
    private TabLayout indicator;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList lstSlides;
    Timer timer;

    SliderView sliderView;
    private SmarateistSliderAdapterBottomFrag smarateistSliderAdapter;
    ArrayList sliderLIst;
    int seekbarCounter = 0;
  //  private SeekBar seekBar;
  TextView tvResidential,tvCommercial;
    LinearLayout linearResidential, linearCommercial;
    RelativeLayout relativeMoreProperties;
    TextView tvMoreProperties;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    private final Runnable SCROLLING_RUNNABLE = new Runnable() {

        @Override
        public void run() {
            rv.smoothScrollBy(pixelsToMove, 0);
            mHandler.postDelayed(this, duration);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.bottom_home_fragment,container,false);

        //Toolbar();
     //  initializeToolbar();


        // for slider view
      /*  sliderpager = view.findViewById(R.id.slider_pager) ;
        indicator = view.findViewById(R.id.indicator);
        lstSlides = new ArrayList<>() ;*/

        // prepare a list of slides ..

       /* lstSlides.add(new Slide(R.drawable.p7,"Slide Title 1"));
        lstSlides.add(new Slide(R.drawable.p6,"Slide Title 2"));
        lstSlides.add(new Slide(R.drawable.p5,"Slide Title 3"));
        lstSlides.add(new Slide(R.drawable.p4,"Slide Title 4"));*/


       // for sliderview
      /*  lstSlides.add(new Slide(R.drawable.p5,"Villa"));
        lstSlides.add(new Slide(R.drawable.p4,"Villa with swimming pool"));
        lstSlides.add(new Slide(R.drawable.p7,"Affordable villas for middle class"));
        lstSlides.add(new Slide(R.drawable.insidehouse3,"With 4 bed rooms"));
        sliderPagerAdapter = new SliderPagerAdapter(getContext(),lstSlides);
        sliderpager.setAdapter(sliderPagerAdapter);
        timer();*/
        /*ImageView ivFilter = view.findViewById(R.id.ivmagnifier);
      final RelativeLayout relativeSeek = view.findViewById(R.id.relativeSeek);

      ivFilter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              seekbarCounter++;

              if (seekbarCounter == 1) {

                  relativeSeek.setVisibility(View.VISIBLE);

              }
              else {

                  relativeSeek.setVisibility(View.GONE);
                  seekbarCounter =0;
              }
          }
      });*/


     // intializeSeekbar();

        initialzeResiAndCommercial();

      intializeSLiderData();
       initializeRecyclerview();
       intializeFeatureRecyclerview();

     intializRecentsRecyclerview();
        intializePopularHousesRecyclerview();
        RvPOpularHouses();

       initilazeRvMain();
       initializeRvProperties();

        intializBottomMainRecyclerview();
       setRvBottomdata();



       return  view;
    }

    private void intializeSeekbar() {

      /*  seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              *//*  progressBar.setProgress(progress);*//*
             //   textView.setText("" + progress + "%");
                Toast.makeText(activity, "" + progress + "%", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });*/


      /*  RangeSeekBar rangeSeekBar ;
        rangeSeekBar = view.findViewById(R.id.rangeseekabr);
        rangeSeekBar.setRangeValues(3000, 15000);
        rangeSeekBar.setSelectedMinValue(3000);
        rangeSeekBar.setSelectedMaxValue(15000);
        
        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {
                
                Number min_value = bar.getSelectedMinValue();
                Number max_value = bar.getSelectedMaxValue();
                
                int min =(int) min_value;
                int max =(int) max_value;

                Toast.makeText(activity, "min"+min+"  max"+max, Toast.LENGTH_SHORT).show();
                
            }
        });*/

        /*// get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) view.findViewById(R.id.rangeSeekbar6);

        // get min and max text view
        final TextView tvMin = (TextView) view.findViewById(R.id.textMin6);
        final TextView tvMax = (TextView) view.findViewById(R.id.textMax6);

        // set properties
        rangeSeekbar
                .setCornerRadius(10f)
               *//* .setBarColor(Color.parseColor("#93F9B5"))
                .setBarHighlightColor(Color.parseColor("#16E059"))*//*
                .setMinValue(4000)
                .setMaxValue(8000)
                .setMinStartValue(5000)
                .setMaxStartValue(7500)
                .setSteps(100)
               *//* .setLeftThumbDrawable(R.drawable.pil4u_logo5_24dp)
                .setLeftThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)
                .setRightThumbDrawable(R.drawable.pil4u_logo5_24dp)
                .setRightThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)*//*
                .setDataType(CrystalRangeSeekbar.DataType.INTEGER)
                .apply();

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue)+"\u20B9");
                tvMax.setText(String.valueOf(maxValue)+"\u20B9");
            }
        });*/
        
    }


    private void intializeSLiderData() {

        sliderView = view.findViewById(R.id.imageSlider);

        smarateistSliderAdapter = new SmarateistSliderAdapterBottomFrag(activity);
        sliderView.setSliderAdapter(smarateistSliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderLIst = new ArrayList();
        sliderLIst.add(new SliderItem("Villa",R.drawable.p5));
        sliderLIst.add(new SliderItem("Villa with swimming pool",R.drawable.p4));
        sliderLIst.add(new SliderItem("Affordable villas for middle class",R.drawable.p7));
        sliderLIst.add(new SliderItem("With 4 bed rooms",R.drawable.insidehouse3));



        smarateistSliderAdapter.renewItems(sliderLIst);
    }

    private void initialzeResiAndCommercial() {

        tvResidential = view.findViewById(R.id.tvResidential);
        tvCommercial = view.findViewById(R.id.tvCommercial);

        linearResidential = view.findViewById(R.id.linearResidential);
        linearCommercial = view.findViewById(R.id.linearCommercial);


        tvMoreProperties = view.findViewById(R.id.tvMoreProperties);
        relativeMoreProperties = view.findViewById(R.id.relativeMoreProperties);


        tvResidential.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                linearCommercial.setVisibility(View.GONE);
                linearResidential.setVisibility(View.VISIBLE);
              /*  tvResidential.setTextColor(R.color.color_site);
                tvCommercial.setTextColor(R.color.color_text_bg);*/

                tvResidential.setTextColor(Color.parseColor("#ff5a5f"));
                tvCommercial.setTextColor(Color.parseColor("#d5d5d6"));

            }
        });

        tvCommercial.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                linearCommercial.setVisibility(View.VISIBLE);
                linearResidential.setVisibility(View.GONE);

                tvResidential.setTextColor(Color.parseColor("#d5d5d6"));
                tvCommercial.setTextColor(Color.parseColor("#ff5a5f"));


            }
        });

      /*  tvMoreProperties.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                relativeMoreProperties.setVisibility(View.VISIBLE);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(15,15,15,0);
                tvMoreProperties.setLayoutParams(params);


            }
        });*/
    }
    private void initializeToolbar() {




        ImageView ivHeart = view.findViewById(R.id.ic_heart);


        tvTool1 = view.findViewById(R.id.tvTool1);
        tvTool2 = view.findViewById(R.id.tvTool2);
        tvTool3 = view.findViewById(R.id.tvTool3);

        String subLocality = AccoutUtils.getSubLocality(activity);
        String address = AccoutUtils.getAddress(activity);

        if (!address.equals("")) {

            tvTool1.setVisibility(View.VISIBLE);
            tvTool2.setVisibility(View.VISIBLE);
            tvTool3.setVisibility(View.GONE);

            tvTool1.setText(subLocality);
            tvTool2.setText(address);

        }
        else {

            //   tvTool1.setText("Click here to set address");
            tvTool1.setVisibility(View.GONE);
            tvTool2.setVisibility(View.GONE);

            tvTool3.setVisibility(View.VISIBLE);


        }

        relativeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(activity, LocationPreferenceActivities.class));
            }
        });

        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, FavoritesActivity.class));
            }
        });

    }


    private void Toolbar(){


        toolbar = view.findViewById(R.id.toolbar);
     /*   ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        relativeToolbar = view.findViewById(R.id.relative_toolbar);*/
        relativeToolbar = view.findViewById(R.id.relative_toolbar);
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar();
        /*.setDisplayHomeAsUpEnabled(true);*/
    }
    private void initializeRecyclerview() {

        rv = view.findViewById(R.id.rvmain);
     /*   rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));*/

        layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);

        // to automatically scroll the recyclerview
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                if (lastItem == layoutManager.getItemCount() - 1) {
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();
                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rv.setAdapter(null);
                            rv.setAdapter(adapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 5000);
                        }
                    }, 5000);
                }
            }
        });
        mHandler.postDelayed(SCROLLING_RUNNABLE, 5000);

    }

    private void intializeFeatureRecyclerview() {

        rvPropertires = view.findViewById(R.id.rvProperties);
        rvPropertires.setHasFixedSize(true);
        rvPropertires.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    private void initilazeRvMain() {


        iconVillas = new ArrayList();
        iconVillas.add(new FirstList(R.drawable.p5,"Villa"));
        iconVillas.add(new FirstList(R.drawable.p4,"Villa with swimming pool"));
        iconVillas.add(new FirstList(R.drawable.p7,"Affordable villas for middle class"));
     /*   iconFoods.add(new iconslider(R.drawable.cake,"Great Offers"));
        iconFoods.add(new iconslider(R.drawable.food1,"Express Delivery"));
        iconFoods.add(new iconslider(R.drawable.food2,"Rohith Suri"));*/
        adapter = new MainRecAdapter(getContext(),iconVillas);
        rv.setAdapter(adapter);

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

    @Override
    public void Rvclick(View view, int Position) {
      // startActivity(new Intent(activity, FeaturedPropertiesActivity.class));

        startActivity(new Intent(activity, Login_Voda_Activity.class));
    }

    private void intializePopularHousesRecyclerview() {

        rvPopularHOuses = view.findViewById(R.id.rvAds);
        rvPopularHOuses.setHasFixedSize(true);
        rvPopularHOuses.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void intializBottomMainRecyclerview() {

        rvBottomdata = view.findViewById(R.id.rvBottomdata);
        rvBottomdata.setHasFixedSize(true);
        rvBottomdata.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));

    }



    private void intializRecentsRecyclerview() {

        rvRecents = view.findViewById(R.id.rvRecents);
        rvRecents.setHasFixedSize(true);
        rvRecents.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void RvPOpularHouses() {


        popularHousesList = new ArrayList();
        popularHousesList.add(new PopularHouses("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p7));
        popularHousesList.add(new PopularHouses("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p4));
        popularHousesList.add(new PopularHouses("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p5));
        popularHousesList.add(new PopularHouses("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.insidehouse2));

        popularHousesList.add(new PopularHouses("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p7));
        popularHousesList.add(new PopularHouses("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p4));
        popularHousesList.add(new PopularHouses("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p5));
        popularHousesList.add(new PopularHouses("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.insidehouse2));


        popularHousesAdapter = new PopularHousesAdapter(popularHousesList);
        rvPopularHOuses.setAdapter(popularHousesAdapter);

        rvRecents.setAdapter(popularHousesAdapter);

    }

    private void setRvBottomdata() {


        bottomMainList = new ArrayList();
        bottomMainList.add(new Bottom_main("35000","Renovated Apartment","1","2","1200",R.drawable.p7));
        bottomMainList.add(new Bottom_main("13000","Luxury Family Home ","2","4","1200",R.drawable.p4));
        bottomMainList.add(new Bottom_main("35000","Renovated Apartment","1","2","1200",R.drawable.p6));
        bottomMainList.add(new Bottom_main("13000","Luxury Family Home ","2","4","1200",R.drawable.p5));

        bottomMainList.add(new Bottom_main("35000","Renovated Apartment","1","2","1200",R.drawable.p3));
        bottomMainList.add(new Bottom_main("13000","Luxury Family Home ","2","4","1200",R.drawable.insidehouse3));
        bottomMainList.add(new Bottom_main("35000","Renovated Apartment","1","2","1200",R.drawable.insidehouse2));
        bottomMainList.add(new Bottom_main("13000","Luxury Family Home ","2","4","1200",R.drawable.p4));


        bottomMainAdapter = new BottomMainAdapter(bottomMainList);
        rvBottomdata.setAdapter(bottomMainAdapter);



    }

    /*@Override
    public void onResume() {
        super.onResume();

        Toolbar();
    }*/

   /* @Override
    public void onPause() {
        super.onPause();

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }*/

 /*   private  void timer(){

        // setup timer
        timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),3000,5000);
        indicator.setupWithViewPager(sliderpager,true);
    }

    class SliderTimer extends TimerTask {


        @Override
        public void run() {

            Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }


    @Override
    public void onPause() {
        super.onPause();

        sliderpager.setCurrentItem(0);
        timer.cancel();    }

    @Override
    public void onResume() {
        super.onResume();

        timer();
    }*/
}
