package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.LifeInsurance;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LifeInsuranceAdapter extends RecyclerView.Adapter<LifeInsuranceAdapter.MYVIEHWOLDER> {

    List<LifeInsurance> list;
    RvListener listener;

    public LifeInsuranceAdapter(List<LifeInsurance> list, RvListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MYVIEHWOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.life_insurance_rec,parent,false);

       return new MYVIEHWOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEHWOLDER holder, int position) {

         LifeInsurance lifeInsurance = list.get(position);

         holder.tvDesc.setText(lifeInsurance.getDesc());
         holder.tvTitle.setText(lifeInsurance.getTitle());
         Picasso.get().load(lifeInsurance.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEHWOLDER extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvDesc;
        ImageView imageView;
        CardView cardView;

        public MYVIEHWOLDER(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);

            itemView.setOnClickListener(this);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            listener.Rvclick(view,getAdapterPosition());
        }
    }
}
