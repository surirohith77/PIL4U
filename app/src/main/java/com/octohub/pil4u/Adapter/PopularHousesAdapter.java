package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularHousesAdapter extends RecyclerView.Adapter<PopularHousesAdapter.MYVIEWHOLDER> {

    List<PopularHouses> list;

    public PopularHousesAdapter(List<PopularHouses> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.properties_popular_rec,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {
        PopularHouses popularHouses = list.get(position);

        Picasso.get().load(popularHouses.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(popularHouses.getCost());
        holder.tvLocaiton.setText(popularHouses.getLocation());
        holder.tvBuildingType.setText(popularHouses.getBuildingType());
        holder.tvRating.setText(popularHouses.getRating());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvCost, tvLocaiton, tvBuildingType, tvRating;
        ImageView ivProperty;


        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);


            tvCost = itemView.findViewById(R.id.tvPrice);
            tvLocaiton = itemView.findViewById(R.id.tvLocatin);
            tvBuildingType = itemView.findViewById(R.id.tvBuildingType);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivProperty = itemView.findViewById(R.id.imageview);

        }
    }
}
