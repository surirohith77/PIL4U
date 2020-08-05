package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Listener.RvListener;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeaturedPropertiesAdapter extends RecyclerView.Adapter<FeaturedPropertiesAdapter.MYVIEWHOLDER> {

   RvListener listener;
    List<FeaturedProperties> list;

    public FeaturedPropertiesAdapter(RvListener listener, List<FeaturedProperties> list) {
        this.listener = listener;
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_properties_design,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        FeaturedProperties featuredProperties = list.get(position);

        Picasso.get().load(featuredProperties.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(featuredProperties.getCost());
        holder.tvSqrt.setText(featuredProperties.getSqrt());
        holder.tvBeds.setText(featuredProperties.getBeds());
        holder.tvBaths.setText(featuredProperties.getBaths());
        holder.tvBuildingType.setText(featuredProperties.getBuildingType());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvCost, tvSqrt, tvBeds, tvBaths, tvBuildingType;
        ImageView ivProperty;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvCost = itemView.findViewById(R.id.tvMoney);
            tvSqrt = itemView.findViewById(R.id.tvSqrt);
            tvBeds = itemView.findViewById(R.id.tvBeds);
            tvBaths = itemView.findViewById(R.id.tvBaths);
            tvBuildingType = itemView.findViewById(R.id.tvBuildingType);
            ivProperty = itemView.findViewById(R.id.ivProperty);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.Rvclick(v,getAdapterPosition());
        }
    }
}
