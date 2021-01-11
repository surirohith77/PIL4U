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

public class NonLifeInsuranceAdapter extends RecyclerView.Adapter<NonLifeInsuranceAdapter.MYVIEWHOLDER> {

    List<LifeInsurance> list;
    RvListener listener;

    public NonLifeInsuranceAdapter(List<LifeInsurance> list, RvListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.non_life_insurance_rec,parent,false);

        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        LifeInsurance lifeInsurance = list.get(position);

        holder.tvTitle.setText(lifeInsurance.getTitle());
        Picasso.get().load(lifeInsurance.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle, tvDesc;
        ImageView imageView;
        CardView cardView;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
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
