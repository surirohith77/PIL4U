package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.octohub.pil4u.Adapter.ContentTabPagerAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Activities.KYCRegisterationActivity;
import com.octohub.pil4u.ui.Activities.SearchviewActivity;
import com.octohub.pil4u.utils.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

public class LoanFragment extends Fragment implements View.OnClickListener{

    Activity activity;
    View view;

    LinearLayout linearLayout2;
    CardView cardOthers,cardMedicalLoan, cardVacationLoan, cardPersonalLoan, cardBusinessLoan, cardHomeLoan, cardSearch;
    ImageView ivicon4;
    int counter = 0;
    TextView tvLoanheading, tvLoanDesc, tvHide;
    RelativeLayout relativeLoanDeatils;

    int seekbarCounter = 0;

    SharedViewModel viewModel;
   // private FragmentLoanListener listener;


  /*  public interface FragmentLoanListener {
        void onInputASent(CharSequence  input);
    }
*/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
/*
        if (context instanceof FragmentLoanListener) {
            listener = (FragmentLoanListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.loans_fragment,container,false);


     initialize();
       //initializeSearchbarSeekbar();

        Button btnCheckCivil = view.findViewById(R.id.btnCheckCivil);
        btnCheckCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(activity, KYCRegisterationActivity.class));
            }
        });

       //openBottomsheetview();

        String[] inner_search_loan = getResources().getStringArray(R.array.inner_search_loan);
        AutoCompleteTextView editText = view.findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                R.layout.custom_inner_search_item, R.id.text_view_list_item, inner_search_loan);
        editText.setAdapter(adapter);


       return  view;
    }

  /*  private void initializeSearchbarSeekbar() {

        ImageView ivFilter = view.findViewById(R.id.ivmagnifier);
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

        intializeSeekbar();
    }*/
/*

    private void intializeSeekbar() {

      */
/*  seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              *//*
*/
/*  progressBar.setProgress(progress);*//*
*/
/*
             //   textView.setText("" + progress + "%");
                Toast.makeText(activity, "" + progress + "%", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });*//*



      */
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
        });*//*


        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) view.findViewById(R.id.rangeSeekbar6);

        // get min and max text view
        final TextView tvMin = (TextView) view.findViewById(R.id.textMin6);
        final TextView tvMax = (TextView) view.findViewById(R.id.textMax6);

        // set properties
        rangeSeekbar
                .setCornerRadius(10f)
                */
/* .setBarColor(Color.parseColor("#93F9B5"))
                 .setBarHighlightColor(Color.parseColor("#16E059"))*//*

                .setMinValue(4000)
                .setMaxValue(8000)
                .setMinStartValue(5000)
                .setMaxStartValue(7500)
                .setSteps(100)
                */
/* .setLeftThumbDrawable(R.drawable.pil4u_logo5_24dp)
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
        });

    }
*/

    private void initialize(){

        linearLayout2 = view.findViewById(R.id.linear2);
        tvLoanheading = view.findViewById(R.id.tvLoanHeading);
        tvLoanDesc = view.findViewById(R.id.tvLoanDesc);
        tvHide = view.findViewById(R.id.tvHide);
        relativeLoanDeatils = view.findViewById(R.id.relativeLoanDeatils);

        cardSearch = view.findViewById(R.id.cardSearch);

        cardPersonalLoan = view.findViewById(R.id.cardPersonalLoan);
        cardBusinessLoan = view.findViewById(R.id.cardBusinessLoan);
        cardHomeLoan = view.findViewById(R.id.cardHomeLoan);

        cardOthers = view.findViewById(R.id.cardOthers);
        cardMedicalLoan = view.findViewById(R.id.cardMedicalLoan);
        cardVacationLoan = view.findViewById(R.id.cardVacationLoan);

        ivicon4 = view.findViewById(R.id.ivicon4);

        ViewPager viewPager = view.findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Banks");
        tabName.add("Calculate EMI");
        tabName.add("Check CIBIL");
        tabName.add("Check eligibility");
        tabName.add("Request Callback");



        List<Fragment> tabFragment = new ArrayList<>();
        BanksFragment banksFragment = new BanksFragment();
        CalculateEmiFragment calculateEmiFragment = new CalculateEmiFragment();
        CivilScoreCheckFragment civilScoreCheckFragment = new CivilScoreCheckFragment();
        CheckEligibiltyFragment checkEligibiltyFragment = new CheckEligibiltyFragment();
        RequestCallbackFragment requestCallbackFragment = new RequestCallbackFragment();


        tabFragment.add(banksFragment);
        tabFragment.add(calculateEmiFragment);
        tabFragment.add(civilScoreCheckFragment);
        tabFragment.add(checkEligibiltyFragment);
        tabFragment.add(requestCallbackFragment);



        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
        //  tabLayout.setSelectedTabIndicator(null);

        //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
        //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));


    //    cardSearch.setOnClickListener(this);

        cardPersonalLoan.setOnClickListener(this);
        cardBusinessLoan.setOnClickListener(this);
        cardHomeLoan.setOnClickListener(this);

        cardMedicalLoan.setOnClickListener(this);
        cardVacationLoan.setOnClickListener(this);

        cardOthers.setOnClickListener(this);
        tvHide.setOnClickListener(this);

    }

    public static BanksFragment newInstance(String heading) {
        BanksFragment myFragment = new BanksFragment();

        Bundle args = new Bundle();
        args.putString("loan", heading);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onClick(View view) {

        String heading, desc;

        switch (view.getId()){

          /*  case R.id.cardSearch:
                startActivity(new Intent(activity, SearchviewActivity.class));
                break;*/


            case R.id.cardHomeLoan:


             heading = "Home Loan";

                 desc= "A house loan or home loan simply means a sum of money borrowed from a financial institution or bank to purchase a house. Home loans consist of an adjustable or fixed interest rate and payment terms.";
                setDescription( heading, desc);


                viewModel.setText(heading);

                //openBottomsheetview();

               // newInstance(heading);

              /*  CharSequence charSequence = heading;
                listener.onInputASent(charSequence);*/

             /*   BanksFragment fragment = BanksFragment.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("loan",heading);
                fragment.setArguments(bundle);*/

                break;
            case R.id.cardBusinessLoan:

             heading = "Business Loan";
                desc= "A business loan is a loan specifically intended for business purposes. As with all loans, it involves the creation of a debt, which will be repaid with added interest.";
                setDescription( heading, desc);
                viewModel.setText(heading);

                break;
            case R.id.cardPersonalLoan:

                heading = "Personal Loan";
                desc= "A personal loan is an installment loan that provides funds borrowers can use for any purpose, unlike an auto loan or a mortgage, which are reserved solely for the purchase of certain property that is then used as collateral for the loan.";
                setDescription( heading, desc);
                viewModel.setText(heading);

                break;

            case R.id.cardMedicalLoan:

                heading = "Medical Loan";
                desc= "It covers your expenses for treatments, surgeries, paying prescription and hospital bills etc. Your insurance may or may not cover all kinds of ailments or treatments. A medical loan can be used for any kind. or ailment or treatment as it is based on the amount of money you want to take as a personal loan.";
                setDescription( heading, desc);
                viewModel.setText(heading);

                break;

            case R.id.cardVacationLoan:

                heading = "Vacation Loan";
                desc= "Vacation loans. A vacation loan is typically an unsecured personal loan you use for travel. These loans require no property or assets as collateral, and you repay the loan in fixed monthly installments over a period of time. Your eligibility and interest rate depend on factors like your creditworthiness and income.";
                setDescription( heading, desc);
                viewModel.setText(heading);

                break;

            case R.id.tvHide:
/*
                tvHide.setVisibility(View.GONE);
                tvLoanheading.setVisibility(View.GONE);
                tvLoanDesc.setVisibility(View.GONE);*/
                relativeLoanDeatils.setVisibility(View.GONE);

                break;


            case R.id.cardOthers:
                counter++;

                if (counter == 1) {
                    linearLayout2.setVisibility(View.VISIBLE);

                  /*  Animation animation3 =
                            AnimationUtils.loadAnimation(activity, R.anim.rotate);
                    ivicon4.startAnimation(animation3);*/


                    ivicon4.setImageResource(R.drawable.up_arrow_blue);


                  /*  Animation animation1 =
                            AnimationUtils.loadAnimation(activity, R.anim.down_to_up);
                    cardCarLoan.startAnimation(animation1);

                    Animation animation2 =
                            AnimationUtils.loadAnimation(activity, R.anim.down_to_up);
                    cardInsurance.startAnimation(animation2);*/

                }else {

                    ivicon4.setImageResource(R.drawable.down_arrow_blue);
                    counter = 0;
                    linearLayout2.setVisibility(View.GONE);
/*
                    Animation animation1 =
                            AnimationUtils.loadAnimation(activity, R.anim.up_to_down);
                    cardCarLoan.startAnimation(animation1);*/

                  /*  Animation animation2 =
                            AnimationUtils.loadAnimation(activity, R.anim.up_to_down);
                    cardInsurance.startAnimation(animation2);

                    Animation animation3 =
                            AnimationUtils.loadAnimation(activity, R.anim.rotate);
                    ivicon4.startAnimation(animation3);

                    long postDelayTime = 1000;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            linearLayout2.setVisibility(View.GONE);
                            ivicon4.setImageResource(R.drawable.down_arrow_blue);
                            counter = 0;

                        }
                    }, postDelayTime);*/

                }

        }


    }

    private void setDescription(String heading, String desc){
/*
        tvLoanheading.setVisibility(View.VISIBLE);
        tvLoanDesc.setVisibility(View.VISIBLE);
        tvHide.setVisibility(View.VISIBLE);*/

        relativeLoanDeatils.setVisibility(View.VISIBLE);

        tvHide.setText(Html.fromHtml("<font color='red'> <u>Hide</u></font>"));

       /* Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        tvLoanheading.startAnimation(animation1);

        Animation animation3 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        tvHide.startAnimation(animation3);
*/
        /*Animation animation2 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        relativeLoanDeatils.startAnimation(animation2);*/

        tvLoanDesc.setText(desc);
        tvLoanheading.setText(heading);
    }

  /*  @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                //editText.setText(charSequence);
            }
        });
    }


    private void openBottomsheetview() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.loans_bottomsheer);
        //  bottomSheetDialog.setCanceledOnTouchOutside(false);

        //initialzeViewPager(bottomSheetDialog);
/*
        ViewPager viewPager = bottomSheetDialog.findViewById(R.id.vp_content);

        List<String> tabName = new ArrayList<>();
        tabName.add("Banks");
        tabName.add("Calculate EMI");
        tabName.add("Check eligibility");
        tabName.add("Request Callback");
        tabName.add("Check CIBIL Score");


        List<Fragment> tabFragment = new ArrayList<>();
        BanksFragment banksFragment = new BanksFragment();
        CalculateEmiFragment calculateEmiFragment = new CalculateEmiFragment();
        CheckEligibiltyFragment checkEligibiltyFragment = new CheckEligibiltyFragment();
        RequestCallbackFragment requestCallbackFragment = new RequestCallbackFragment();
        CibilScoreCheckFragment cibilScoreCheckFragment = new CibilScoreCheckFragment();



        tabFragment.add(banksFragment);
        tabFragment.add(calculateEmiFragment);
        tabFragment.add(checkEligibiltyFragment);
        tabFragment.add(requestCallbackFragment);
        tabFragment.add(cibilScoreCheckFragment);


        ContentTabPagerAdapter adapter = new ContentTabPagerAdapter(
                getFragmentManager(),
                tabFragment,
                tabName);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = bottomSheetDialog.findViewById(R.id.tabs_content);
        tabLayout.setupWithViewPager(viewPager);

        // to disable indicator line
        //  tabLayout.setSelectedTabIndicator(null);

        //   tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        //tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));


        // to change the color of selected tab
        //  tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#01203a"));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ff5a5f"));*/


     /*   tvViewLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });*/


        Fragment someFragment = new BanksFragment();

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            // transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            transaction.replace(R.id.user_list_container, someFragment ); // give your fragment container id in first parameter
            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
            transaction.commit();




        bottomSheetDialog.show();

    }


}
