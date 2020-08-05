package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Bottom_main;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BottomMainAdapter extends RecyclerView.Adapter<BottomMainAdapter.MYVIEWHODER>{

    List<Bottom_main> list;
    Context context;

    public BottomMainAdapter(List<Bottom_main> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHODER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_rec_main_design,parent,false);
        return new MYVIEWHODER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHODER holder, int position) {

        Bottom_main bottom_main = list.get(position);

        holder.tvBEds.setText(bottom_main.getBeds());
        holder.tvBath.setText(bottom_main.getBathtubs());
        holder.tvSqft.setText(bottom_main.getSqft()+" Sqft");
        holder.tvPrice.setText("\u20B9 "+bottom_main.getRate());
        holder.tvBudiltype.setText(bottom_main.getBuildtype());

            Picasso.get().load(bottom_main.getImage()).into(holder.imageView);

       // animate(holder);
    }

    private void animate(MYVIEWHODER holder) {

        holder.itemView.setAnimation(AnimationUtils.loadAnimation(this.context, R.anim.anticipate_overshoot_interpolator));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHODER extends RecyclerView.ViewHolder {

        TextView tvBEds, tvBath, tvSqft, tvPrice, tvBudiltype;

        ImageView imageView;

        public MYVIEWHODER(@NonNull View itemView) {
            super(itemView);
            tvBEds = itemView.findViewById(R.id.tvBed);
            tvBath = itemView.findViewById(R.id.tvBath);
            tvSqft = itemView.findViewById(R.id.tvSqft);
            tvPrice = itemView.findViewById(R.id.tvCost);
            tvBudiltype = itemView.findViewById(R.id.tvBuildingType);
            imageView = itemView.findViewById(R.id.ivImage);
        }
    }
}
