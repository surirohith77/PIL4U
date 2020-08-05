package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Features;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.MYVIEWHOLDER> {

    List<Features> list;

    public FeaturesAdapter(List<Features> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.features_rec_design,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Features features = list.get(position);
        Picasso.get().load(features.getImages()).into(holder.ivCheckMark);
        holder.tvFeatures.setText(features.getFeatures());
        holder.tvBadge.setText(""+features.getBadge());
        if (features.getBadge() == 1){

            holder.tvBadge.setVisibility(View.GONE);
        }else {

            holder.tvBadge.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvFeatures, tvBadge;
        ImageView ivCheckMark;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);
            tvFeatures = itemView.findViewById(R.id.tvFeatures);
            tvBadge = itemView.findViewById(R.id.tvBadge);
            ivCheckMark = itemView.findViewById(R.id.ivCheckMark);

        }
    }
}
