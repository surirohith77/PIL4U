package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.octohub.pil4u.R;

public class AddFreeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnContinue;

    CardView cardRent, cardSell, cardPGCO,
            cardApartment, cardIndependentHouse, cardVilla, cardIndependentFloor, cardFlat,
            cardNewBooking,cardResale,
            cardReadyToMove,cardUnderConstruction,
            card1rm, card1bhk, card2bhk, card3bhk, card3pbhk,
            cardbath0, cardbath1, cardbath2, cardbath3, cardbath3p,
            cardbal0, cardbal1, cardbal2, cardbal3,cardbal3p,
            cardFullyFurnished, cardSemiFurnished, cardUnfurnished,
            cardCpark0, cardCpark1, cardCpark2, cardCpark3, cardCpark3p,
            cardOpark0, cardOpark1, cardOpark2, cardOpark3, cardOpark3p;



    TextView tvPGCO, tvSell, tvRent,
            tvApartment, tvIndependentHouse, tvVilla, tvIndependentFloor, tvFlat,
            tvNewBooking,tvResale,
            tvReadyToMove,tvUnderConstruction,
            tv1rm, tv1bhk, tv2bhk, tv3bhk, tv3pbhk,
            tvbath0, tvbath1, tvbath2, tvbath3, tvbath3p,
            tvbal0, tvbal1, tvbal2, tvbal3,tvbal3p,
            tvFullyFurnished, tvSemiFurnished, tvUnFurnished,
            tvCpark0, tvCpark1, tvCpark2, tvCpark3, tvCpark3p,
            tvOpark0, tvOpark1,tvOpark2, tvOpark3,  tvOpark3p;

    LinearLayout linearProperty;
    CardView cardProperty;
    int propertyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_free);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Add Free");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initialize();
    }

    private void initialize() {


        btnContinue = findViewById(R.id.btnContinue);
        cardProperty = findViewById(R.id.cardProperty);
        linearProperty = findViewById(R.id.linearProperty);


        cardRent = findViewById(R.id.cardRent);
        tvRent = findViewById(R.id.tvRent);
        cardSell = findViewById(R.id.cardSell);
        tvSell = findViewById(R.id.tvSell);
        cardPGCO = findViewById(R.id.cardPGCO);
        tvPGCO = findViewById(R.id.tvPGCO);

        cardApartment = findViewById(R.id.cardApartment);
        tvApartment = findViewById(R.id.tvApartment);
        cardIndependentHouse = findViewById(R.id.cardIndependentHouse);
        tvIndependentHouse = findViewById(R.id.tvIndependentHouse);
        cardVilla = findViewById(R.id.cardVilla);
        tvVilla = findViewById(R.id.tvVilla);
        cardIndependentFloor = findViewById(R.id.cardIndependentFloor);
        tvIndependentFloor = findViewById(R.id.tvIndependentFloor);
        cardFlat = findViewById(R.id.cardFlat);
        tvFlat = findViewById(R.id.tvFlat);


        cardNewBooking = findViewById(R.id.cardNewBooking);
        tvNewBooking = findViewById(R.id.tvNewBooking);
        cardResale = findViewById(R.id.cardResale);
        tvResale = findViewById(R.id.tvResale);

        cardReadyToMove = findViewById(R.id.cardReadyToMove);
        tvReadyToMove = findViewById(R.id.tvReadyToMove);
        cardUnderConstruction = findViewById(R.id.cardUnderConstruction);
        tvUnderConstruction = findViewById(R.id.tvUnderConstruction);

        card1rm = findViewById(R.id.card1rm);
        tv1rm = findViewById(R.id.tv1rm);
        card1bhk = findViewById(R.id.card1bhk);
        tv1bhk = findViewById(R.id.tv1bhk);
        card2bhk = findViewById(R.id.card2bhk);
        tv2bhk = findViewById(R.id.tv2bhk);
        card3bhk = findViewById(R.id.card3bhk);
        tv3bhk = findViewById(R.id.tv3bhk);
        card3pbhk = findViewById(R.id.card3pbhk);
        tv3pbhk = findViewById(R.id.tv3pbhk);


        cardbath0 = findViewById(R.id.cardbath0);
        tvbath0 = findViewById(R.id.tvbath0);
        cardbath1 = findViewById(R.id.cardbath1);
        tvbath1 = findViewById(R.id.tvbath1);
        cardbath2 = findViewById(R.id.cardbath2);
        tvbath2 = findViewById(R.id.tvbath2);
        cardbath3 = findViewById(R.id.cardbath3);
        tvbath3 = findViewById(R.id.tvbath3);
        cardbath3p = findViewById(R.id.cardbath3p);
        tvbath3p = findViewById(R.id.tvbath3p);

        cardbal0 = findViewById(R.id.cardbal0);
        tvbal0 = findViewById(R.id.tvbal0);
        cardbal1 = findViewById(R.id.cardbal1);
        tvbal1 = findViewById(R.id.tvbal1);
        cardbal2 = findViewById(R.id.cardbal2);
        tvbal2 = findViewById(R.id.tvbal2);
        cardbal3 = findViewById(R.id.cardbal3);
        tvbal3 = findViewById(R.id.tvbal3);
        cardbal3p = findViewById(R.id.cardbal3p);
        tvbal3p = findViewById(R.id.tvbal3p);

        cardFullyFurnished = findViewById(R.id.cardFullyFurnished);
        tvFullyFurnished = findViewById(R.id.tvFullyFurnished);
        cardSemiFurnished = findViewById(R.id.cardSemiFurnished);
        tvSemiFurnished = findViewById(R.id.tvSemiFurnished);
        cardUnfurnished = findViewById(R.id.cardUnfurnished);
        tvUnFurnished = findViewById(R.id.tvUnFurnished);


        cardCpark0 = findViewById(R.id.cardCpark0);
        tvCpark0 = findViewById(R.id.tvCpark0);
        cardCpark1 = findViewById(R.id.cardCpark1);
        tvCpark1 = findViewById(R.id.tvCpark1);
        cardCpark2 = findViewById(R.id.cardCpark2);
        tvCpark2 = findViewById(R.id.tvCpark2);
        cardCpark3 = findViewById(R.id.cardCpark3);
        tvCpark3 = findViewById(R.id.tvCpark3);
        cardCpark3p = findViewById(R.id.cardCpark3p);
        tvCpark3p = findViewById(R.id.tvCpark3p);


        cardOpark0 = findViewById(R.id.cardOpark0);
        tvOpark0 = findViewById(R.id.tvOpark0);
        cardOpark1 = findViewById(R.id.cardOpark1);
        tvOpark1 = findViewById(R.id.tvOpark1);
        cardOpark2 = findViewById(R.id.cardOpark2);
        tvOpark2 = findViewById(R.id.tvOpark2);
        cardOpark3 = findViewById(R.id.cardOpark3);
        tvOpark3 = findViewById(R.id.tvOpark3);
        cardOpark3p = findViewById(R.id.cardOpark3p);
        tvOpark3p = findViewById(R.id.tvOpark3p);



        btnContinue.setOnClickListener(this);
        cardProperty.setOnClickListener(this);

        cardRent.setOnClickListener(this);
        cardSell.setOnClickListener(this);
        cardPGCO.setOnClickListener(this);

        cardApartment.setOnClickListener(this);
        cardIndependentHouse.setOnClickListener(this);
        cardVilla.setOnClickListener(this);
        cardIndependentFloor.setOnClickListener(this);
        cardFlat.setOnClickListener(this);

        cardNewBooking.setOnClickListener(this);
        cardResale.setOnClickListener(this);

        cardReadyToMove.setOnClickListener(this);
        cardUnderConstruction.setOnClickListener(this);

        card1rm.setOnClickListener(this);
        card1bhk.setOnClickListener(this);
        card2bhk.setOnClickListener(this);
        card3bhk.setOnClickListener(this);
        card3pbhk.setOnClickListener(this);

        cardbath0.setOnClickListener(this);
        cardbath1.setOnClickListener(this);
        cardbath2.setOnClickListener(this);
        cardbath3.setOnClickListener(this);
        cardbath3p.setOnClickListener(this);

        cardbal0.setOnClickListener(this);
        cardbal1.setOnClickListener(this);
        cardbal2.setOnClickListener(this);
        cardbal3.setOnClickListener(this);
        cardbal3p.setOnClickListener(this);

        cardFullyFurnished.setOnClickListener(this);
        cardSemiFurnished.setOnClickListener(this);
        cardUnfurnished.setOnClickListener(this);


        cardCpark0.setOnClickListener(this);
        cardCpark1.setOnClickListener(this);
        cardCpark2.setOnClickListener(this);
        cardCpark3.setOnClickListener(this);
        cardCpark3p.setOnClickListener(this);

        cardOpark0.setOnClickListener(this);
        cardOpark1.setOnClickListener(this);
        cardOpark2.setOnClickListener(this);
        cardOpark3.setOnClickListener(this);
        cardOpark3p.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnContinue:
                startActivity(new Intent(this,AddFreePlacePickerActivity.class));
                break;

            case R.id.cardProperty:
                propertyCounter++;
                if (propertyCounter == 1){
                    linearProperty.setVisibility(View.VISIBLE);
                    Animation animation1 =
                            AnimationUtils.loadAnimation(this, R.anim.down_to_up3);
                    linearProperty.startAnimation(animation1);
                }
                else {
                    linearProperty.setVisibility(View.GONE);
                    propertyCounter = 0;
                }
                break;

            case R.id.cardRent:
                cardRent.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardSell.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardPGCO.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvRent.setTextColor(getResources().getColor(R.color.colorWhite));
                tvSell.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvPGCO.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                //ColorStateList oldColors =  textView.getTextColors();
                break;
            case R.id.cardSell:
                cardRent.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardSell.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardPGCO.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvRent.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvSell.setTextColor(getResources().getColor(R.color.colorWhite));
                tvPGCO.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardPGCO:
                cardRent.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardSell.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardPGCO.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvRent.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvSell.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvPGCO.setTextColor(getResources().getColor(R.color.colorWhite));
                break;





            case R.id.cardApartment:
                cardApartment.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardIndependentHouse.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardVilla.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentFloor.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardFlat.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvApartment.setTextColor(getResources().getColor(R.color.colorWhite));
                tvIndependentHouse.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvVilla.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentFloor.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvFlat.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                //ColorStateList oldColors =  textView.getTextColors();
                break;
            case R.id.cardIndependentHouse:
                cardApartment.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentHouse.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardVilla.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentFloor.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardFlat.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvApartment.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentHouse.setTextColor(getResources().getColor(R.color.colorWhite));
                tvVilla.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentFloor.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvFlat.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardVilla:
                cardApartment.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentHouse.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardVilla.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardIndependentFloor.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardFlat.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvApartment.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentHouse.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvVilla.setTextColor(getResources().getColor(R.color.colorWhite));
                tvIndependentFloor.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvFlat.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardIndependentFloor:
                cardApartment.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentHouse.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardVilla.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentFloor.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardFlat.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvApartment.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentHouse.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvVilla.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentFloor.setTextColor(getResources().getColor(R.color.colorWhite));
                tvFlat.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardFlat:
                cardApartment.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentHouse.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardVilla.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardIndependentFloor.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardFlat.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvApartment.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentHouse.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvVilla.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvIndependentFloor.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvFlat.setTextColor(getResources().getColor(R.color.colorWhite));
                break;



            case R.id.cardNewBooking:
                cardNewBooking.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardResale.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvNewBooking.setTextColor(getResources().getColor(R.color.colorWhite));
                tvResale.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardResale:
                cardNewBooking.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardResale.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvNewBooking.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvResale.setTextColor(getResources().getColor(R.color.colorWhite));
                break;


            case R.id.cardReadyToMove:
                cardReadyToMove.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardUnderConstruction.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvReadyToMove.setTextColor(getResources().getColor(R.color.colorWhite));
                tvUnderConstruction.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardUnderConstruction:
                cardReadyToMove.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardUnderConstruction.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvReadyToMove.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvUnderConstruction.setTextColor(getResources().getColor(R.color.colorWhite));
                break;



            case R.id.card1rm:
                card1rm.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                card1bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card2bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3pbhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv1rm.setTextColor(getResources().getColor(R.color.colorWhite));
                tv1bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv2bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3pbhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.card1bhk:
                card1rm.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card1bhk.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                card2bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3pbhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv1rm.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv1bhk.setTextColor(getResources().getColor(R.color.colorWhite));
                tv2bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3pbhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.card2bhk:
                card1rm.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card1bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card2bhk.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                card3bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3pbhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv1rm.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv1bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv2bhk.setTextColor(getResources().getColor(R.color.colorWhite));
                tv3bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3pbhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.card3bhk:
                card1rm.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card1bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card2bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3bhk.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                card3pbhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv1rm.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv1bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv2bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3bhk.setTextColor(getResources().getColor(R.color.colorWhite));
                tv3pbhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.card3pbhk:
                card1rm.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card1bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card2bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3bhk.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                card3pbhk.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv1rm.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv1bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv2bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3bhk.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tv3pbhk.setTextColor(getResources().getColor(R.color.colorWhite));
                break;






            case R.id.cardbath0:
                cardbath0.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbath1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbath0.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbath1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbath1:
                cardbath0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath1.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbath2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbath0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath1.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbath2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbath2:
                cardbath0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath2.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbath3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbath0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath2.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbath3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbath3:
                cardbath0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbath3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbath0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbath3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbath3p:
                cardbath0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbath3p.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvbath0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbath3p.setTextColor(getResources().getColor(R.color.colorWhite));
                break;



            case R.id.cardbal0:
                cardbal0.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbal1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbal0.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbal1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbal1:
                cardbal0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal1.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbal2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbal0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal1.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbal2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbal2:
                cardbal0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal2.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbal3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbal0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal2.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbal3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbal3:
                cardbal0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardbal3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvbal0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3.setTextColor(getResources().getColor(R.color.colorWhite));
                tvbal3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardbal3p:
                cardbal0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardbal3p.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvbal0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvbal3p.setTextColor(getResources().getColor(R.color.colorWhite));
                break;




            case R.id.cardFullyFurnished:
                cardFullyFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardSemiFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardUnfurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvFullyFurnished.setTextColor(getResources().getColor(R.color.colorWhite));
                tvSemiFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvUnFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardSemiFurnished:
                cardFullyFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardSemiFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardUnfurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvFullyFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvSemiFurnished.setTextColor(getResources().getColor(R.color.colorWhite));
                tvUnFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardUnfurnished:
                cardFullyFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardSemiFurnished.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardUnfurnished.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvFullyFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvSemiFurnished.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvUnFurnished.setTextColor(getResources().getColor(R.color.colorWhite));
                break;


            case R.id.cardCpark0:
                cardCpark0.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardCpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvCpark0.setTextColor(getResources().getColor(R.color.colorWhite));
                tvCpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardCpark1:
                cardCpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark1.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardCpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvCpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark1.setTextColor(getResources().getColor(R.color.colorWhite));
                tvCpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardCpark2:
                cardCpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark2.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardCpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvCpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark2.setTextColor(getResources().getColor(R.color.colorWhite));
                tvCpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardCpark3:
                cardCpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardCpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvCpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3.setTextColor(getResources().getColor(R.color.colorWhite));
                tvCpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardCpark3p:
                cardCpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardCpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvCpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvCpark3p.setTextColor(getResources().getColor(R.color.colorWhite));
                break;




            case R.id.cardOpark0:
                cardOpark0.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardOpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvOpark0.setTextColor(getResources().getColor(R.color.colorWhite));
                tvOpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardOpark1:
                cardOpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark1.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardOpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvOpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark1.setTextColor(getResources().getColor(R.color.colorWhite));
                tvOpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardOpark2:
                cardOpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark2.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardOpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvOpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark2.setTextColor(getResources().getColor(R.color.colorWhite));
                tvOpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardOpark3:
                cardOpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                cardOpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                tvOpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3.setTextColor(getResources().getColor(R.color.colorWhite));
                tvOpark3p.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                break;
            case R.id.cardOpark3p:
                cardOpark0.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark1.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark2.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                cardOpark3p.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvOpark0.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark1.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark2.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3.setTextColor(getResources().getColor(R.color.textColorPrimaryDark));
                tvOpark3p.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }
    }
}