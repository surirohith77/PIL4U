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

public class FavoriteTilesAdapter extends RecyclerView.Adapter<FavoriteTilesAdapter.MYVIEWHOLDER> {

    List<Favorites> list;

    public FavoriteTilesAdapter(List<Favorites> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_tiles_layout_design,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Favorites favorites = list.get(position);

        Picasso.get().load(favorites.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(favorites.getCost());
        holder.tvLocaiton.setText(favorites.getLocation());
        holder.tvBuildingType.setText(favorites.getBuildingType());

       // holder.tvRating.setText(popularHouses.getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Favorites item, int position) {
        list.add(position, item);
        notifyItemInserted(position);
    }

    public List<Favorites> getData() {
        return list;
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvCost, tvLocaiton, tvBuildingType, tvRating;
        ImageView ivProperty;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvCost = itemView.findViewById(R.id.tvPrice);
            tvLocaiton = itemView.findViewById(R.id.tvLocatin);
            tvBuildingType = itemView.findViewById(R.id.tvBuildingType);
         //   tvRating = itemView.findViewById(R.id.tvRating);
            ivProperty = itemView.findViewById(R.id.imageview);
        }
    }
}
