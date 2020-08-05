package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.FeaturedProperties;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MYVIEWHOLDER> {

    List<Favorites> list;
    Context context;

    public FavoritesAdapter(List<Favorites> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_sites_rec,parent,false);
      return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MYVIEWHOLDER holder, int position) {

        Favorites favorites = list.get(position);

        Picasso.get().load(favorites.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(favorites.getCost());
        holder.tvLocaiton.setText(favorites.getLocation());
        holder.tvBuildingType.setText(favorites.getBuildingType());


      //  holder.cardView.setBackgroundResource(R.drawable.cardview_topcorner_radius);

       /* Glide.with(context)
                .load(logout.getImages())
                .asBitmap()
                .into(new BitmapImageViewTarget(holder.ivProperty) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(),
                                Bitmap.createScaledBitmap(resource, 50, 50, false));
                        drawable.setCornerRadius(10); //drawable.setCircular(true);
                        holder.ivProperty.setImageDrawable(drawable);
                    }
                });
*/
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

        TextView tvCost, tvLocaiton, tvBuildingType;
        ImageView ivProperty;
        CardView cardView;


        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview);
            tvCost = itemView.findViewById(R.id.tvPrice);
            tvLocaiton = itemView.findViewById(R.id.tvLocatin);
            tvBuildingType = itemView.findViewById(R.id.tvBuildingType);
            ivProperty = itemView.findViewById(R.id.imageview);

        }
    }
}
