package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Offers;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MYVIEWHOLDER> {

    List<Offers> list;

    public OffersAdapter(List<Offers> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_bank_rec,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Offers offers = list.get(position);

        holder.tvOffers.setText(""+offers.getOffers());
        Picasso.get().load(offers.getImage()).into(holder.ivOffers);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        TextView tvOffers;
        ImageView ivOffers;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvOffers = itemView.findViewById(R.id.tvOffers);
            ivOffers = itemView.findViewById(R.id.ivOffers);
        }
    }
}
