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
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.material.tabs.TabLayout;
import com.octohub.pil4u.Adapter.BottomMainAdapter;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.Adapter.FeaturedPropertiesAdapter;
import com.octohub.pil4u.Adapter.MainRecAdapter;
import com.octohub.pil4u.Adapter.PopularHousesAdapter;
import com.octohub.pil4u.Adapter.SliderPagerAdapter;
import com.octohub.pil4u.Adapter.SmarateistSliderAdapterBottomFrag;
import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.SearchviewActivity;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class BottomSearchFragment extends Fragment implements RvListener {

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

    CardView cardSearch;




    int commercialCounter = 0, residentialCounter = 0;

    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola"
    };

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
       view = inflater.inflate(R.layout.bottom_search_fragment,container,false);

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



      /*  ImageView ivFilter = view.findViewById(R.id.ivmagnifier);
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
      });
*/



      //  initialzeResiAndCommercial();

        cardSearch = view.findViewById(R.id.cardSearch);
       /* cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(activity, SearchviewActivity.class));
            }
        });*/


        String[] countries = getResources().getStringArray(R.array.inner_search_property);
        AutoCompleteTextView editText = view.findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                R.layout.custom_inner_search_item, R.id.text_view_list_item, countries);
        editText.setAdapter(adapter);

      intializeSeekbar();
     // initializeFragmentsRESCOm();
        initializeFragments();




       return  view;
    }



    private void initializeFragments(){


        ViewPager viewPager = view.findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Home");
       /* tabName.add("Faqs");
        tabName.add("Reviews");*/


        List<Fragment> tabFragment = new ArrayList<>();
        BottomHomeFragment bottomHomeFragment2 = new BottomHomeFragment();


        tabFragment.add(bottomHomeFragment2);


        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id .tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
        //  tabLayout.setSelectedTabIndicator(null);

        //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
        //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));



    }

   /* private void initializeFragmentsRESCOm(){


        ViewPager viewPager = view.findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Residential");
        tabName.add("Commercial");
       *//* tabName.add("Faqs");
        tabName.add("Reviews");*//*


        List<Fragment> tabFragment = new ArrayList<>();
        ResidentialFragment residentialFragment  = new ResidentialFragment();
        CommercialFragment commercialFragment  = new CommercialFragment();


        tabFragment.add(residentialFragment);
        tabFragment.add(commercialFragment);


        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id .tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
        //  tabLayout.setSelectedTabIndicator(null);

        //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
        //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));



    }*/


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

        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) view.findViewById(R.id.rangeSeekbar6);

        // get min and max text view
        final TextView tvMin = (TextView) view.findViewById(R.id.textMin6);
        final TextView tvMax = (TextView) view.findViewById(R.id.textMax6);

        // set properties
        rangeSeekbar
                .setCornerRadius(10f)
               /* .setBarColor(Color.parseColor("#93F9B5"))
                .setBarHighlightColor(Color.parseColor("#16E059"))*/
                .setMinValue(4000)
                .setMaxValue(8000)
                .setMinStartValue(5000)
                .setMaxStartValue(7500)
                .setSteps(100)
               /* .setLeftThumbDrawable(R.drawable.pil4u_logo5_24dp)
                .setLeftThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)
                .setRightThumbDrawable(R.drawable.pil4u_logo5_24dp)
                .setRightThumbHighlightDrawable(R.drawable.pil4u_logo5_24dp)*/
                .setDataType(CrystalRangeSeekbar.DataType.INTEGER)
                .apply();

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue)+"\u20B9");
                tvMax.setText(String.valueOf(maxValue)+"\u20B9");
            }
        });

    }


    @Override
    public void Rvclick(View view, int Position) {

    }



}
