package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.NearBy;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NearByAdapter extends RecyclerView.Adapter<NearByAdapter.MYVIEWHOLDER> {

    List<NearBy> list;

    public NearByAdapter(List<NearBy> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_design_rec,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        NearBy nearBy = list.get(position);

        holder.tvNameDistance.setText(nearBy.getNameDistance());
        holder.tvReview.setText(nearBy.getReview());
        holder.tvRating.setText(nearBy.getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvNameDistance, tvRating, tvReview;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvNameDistance = itemView.findViewById(R.id.tvNameDistance);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvReview = itemView.findViewById(R.id.tvReview);
        }
    }
}
