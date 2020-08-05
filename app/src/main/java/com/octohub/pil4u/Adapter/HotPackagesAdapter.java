package com.octohub.pil4u.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.HotPackages;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HotPackagesAdapter extends RecyclerView.Adapter<HotPackagesAdapter.MYVIEWHOLDER> {

    List<HotPackages> list;

    public HotPackagesAdapter(List<HotPackages> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.properties_rec,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {
        HotPackages hotPackages = list.get(position);

        Picasso.get().load(hotPackages.getImages()).into(holder.ivProperty);

        holder.tvCost.setText(hotPackages.getCost());
        holder.tvLocaiton.setText(hotPackages.getLocation());
        holder.tvBuildingType.setText(hotPackages.getBuildingType());
       // holder.btnStatus.setText(hotPackages.getStatus());

      /*  if (hotPackages.getStatus().equals("Pending")){

            holder.btnStatus.setBackgroundColor(Color.parseColor("#9a0606"));
        }else if (hotPackages.getStatus().equals("Published")){

            holder.btnStatus.setBackgroundColor(Color.parseColor("#39da8a"));
        }
        else if (hotPackages.getStatus().equals("Processing")){

            holder.btnStatus.setBackgroundColor(Color.parseColor("#fd397a"));
        }*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {


        TextView tvCost, tvLocaiton, tvBuildingType;
        ImageView ivProperty;
        //AppCompatButton btnStatus;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvCost = itemView.findViewById(R.id.tvPrice);
            tvLocaiton = itemView.findViewById(R.id.tvLocatin);
            tvBuildingType = itemView.findViewById(R.id.tvBuildingType);
        //    btnStatus = itemView.findViewById(R.id.btnStatus);
            ivProperty = itemView.findViewById(R.id.imageview);
        }
    }
}
