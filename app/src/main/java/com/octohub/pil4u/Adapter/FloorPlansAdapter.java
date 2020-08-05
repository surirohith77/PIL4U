package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.FloorPlans;
import com.octohub.pil4u.R;

import java.util.List;

public class FloorPlansAdapter extends RecyclerView.Adapter<FloorPlansAdapter.MYVIEWHOLDER> {

    List<FloorPlans> list;

    public FloorPlansAdapter(List<FloorPlans> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.floor_plans_rec_design,parent,false);
       return new MYVIEWHOLDER(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        FloorPlans floorPlans = list.get(position);

        holder.tvFLoors.setText(floorPlans.getFloor());
        holder.tvSize.setText("Size : "+floorPlans.getSize());
        holder.tvROoms.setText("Rooms : "+floorPlans.getRooms());
        holder.tvBaths.setText("Baths : "+floorPlans.getBaths());
        holder.tvPrice.setText("Price \u20B9 "+floorPlans.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        TextView tvSize, tvROoms, tvBaths, tvFLoors, tvPrice;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);
            tvFLoors = itemView.findViewById(R.id.tvFloor);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvROoms = itemView.findViewById(R.id.tvRooms);
            tvBaths = itemView.findViewById(R.id.tvBath);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
