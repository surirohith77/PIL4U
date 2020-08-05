package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Ads;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdssAdapter extends RecyclerView.Adapter<AdssAdapter.MYVIEWHOLDER>{

    List<Ads> list;

    public AdssAdapter(List<Ads> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_rec_design,parent,false);
       return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        Ads myAdds = list.get(position);

        Picasso.get().load(myAdds.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(myAdds.getCost());
        holder.tvLocaiton.setText(myAdds.getLocation());
        holder.tvSqrt.setText(myAdds.getSqft());
        holder.tvBaths.setText(myAdds.getBaths());
        holder.tvBeds.setText(myAdds.getBeds());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvCost, tvLocaiton, tvSqrt, tvBaths, tvBeds;
        ImageView ivProperty;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvCost = itemView.findViewById(R.id.tvPrice);
            tvLocaiton = itemView.findViewById(R.id.tvLocatin);
            tvSqrt = itemView.findViewById(R.id.tvSqrt);
            tvBaths = itemView.findViewById(R.id.tvBaths);
            tvBeds = itemView.findViewById(R.id.tvBeds);
            ivProperty = itemView.findViewById(R.id.imageview);
        }
    }
}
