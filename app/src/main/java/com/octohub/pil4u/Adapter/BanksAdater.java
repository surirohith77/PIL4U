package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.Ads;
import com.octohub.pil4u.Model.Banks;
import com.octohub.pil4u.Model.SliderItem;
import com.octohub.pil4u.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BanksAdater extends RecyclerView.Adapter<BanksAdater.MYVIEWHOLDER>{


    List<Banks> list;
    RvListener rvListener;
    Context context;

    public BanksAdater(List<Banks> list, RvListener listener) {
        this.list = list;
        this.rvListener = listener;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banks_rec_design,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Banks banks = list.get(position);

        holder.tvBankName.setText(banks.getBankName());
        holder.tvRateofInterest.setText(banks.getRateOfInterest());
        holder.tvProcessingFee.setText("\u20B9 "+banks.getProcessingFee()+" + GST");
        holder.tvTenure.setText("Tenure: "+banks.getTenure()+" Years");

        Picasso.get().load(banks.getBankLogos()).into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MYVIEWHOLDER extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvBankName, tvRateofInterest,tvProcessingFee, tvTenure;
        ImageView ivLogo;
        Button btnGet;
        CardView card1, card2;


        SliderView sliderView;
        private SmarateistSliderAdapter smarateistSliderAdapter;
        ArrayList sliderLIst;

        int counter = 0;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvBankName = itemView.findViewById(R.id.tvBankName);
            tvRateofInterest = itemView.findViewById(R.id.tvRateofInterest);
            tvProcessingFee = itemView.findViewById(R.id.tvProcessingFee);
            tvTenure = itemView.findViewById(R.id.tvTenure);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            btnGet = itemView.findViewById(R.id.btnGet);

            card1 = itemView.findViewById(R.id.card1);
            card2 = itemView.findViewById(R.id.cardImageSlieder);

            intializeSLiderData();


            itemView.setOnClickListener(this);
            btnGet.setOnClickListener(this);
         //   card1.setOnClickListener(this);

           card1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   counter++;
                   if (counter==1){

                       card2.setVisibility(View.VISIBLE);
                   }else {

                       card2.setVisibility(View.GONE);
                       counter = 0;
                   }
               }
           });


        }

        @Override
        public void onClick(View view) {

            rvListener.Rvclick(view,getAdapterPosition());

        }

        private void intializeSLiderData() {

            sliderView = itemView.findViewById(R.id.imageSlider);

            smarateistSliderAdapter = new SmarateistSliderAdapter(context);
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
           // sliderLIst.add(new SliderItem("Loan1",R.drawable.kotak_loan1));
            sliderLIst.add(new SliderItem("Loan2",R.drawable.kotak_loan2));
            sliderLIst.add(new SliderItem("Loan3",R.drawable.icici_loan1));
            sliderLIst.add(new SliderItem("Loan4",R.drawable.icici_loan2));



            smarateistSliderAdapter.renewItems(sliderLIst);
        }
    }
}
