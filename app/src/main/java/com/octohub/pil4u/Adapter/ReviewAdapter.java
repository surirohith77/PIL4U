package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.NearBy;
import com.octohub.pil4u.Model.Reviews;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MYVIEWHOLDER> {

    List<Reviews> list;

    public ReviewAdapter(List<Reviews> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_design_rec,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Reviews reviews = list.get(position);

        holder.tvName.setText(reviews.getName());
        holder.tvReview.setText(reviews.getReview());
        holder.tvDate.setText(reviews.getDate());

        Picasso.get().load(reviews.getImage()).into(holder.ivUser);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvReview;
        ImageView ivUser;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvReview = itemView.findViewById(R.id.tvReview);
            ivUser = itemView.findViewById(R.id.ivUser);
        }
    }
}
