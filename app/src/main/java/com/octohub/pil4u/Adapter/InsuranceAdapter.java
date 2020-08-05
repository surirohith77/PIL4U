package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Insurance;
import com.octohub.pil4u.Model.MyNotification;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.MYVIEWHOLDER> {

    List<Insurance> list;
    Context context;

    public InsuranceAdapter(List<Insurance> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_rec_design, parent, false);
        return new MYVIEWHOLDER(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {



        Insurance insurance = list.get(position);


        holder.tvDate.setText(insurance.getPaymentDate());
        holder.tvPolicyNo.setText(insurance.getPolicyNo());
        holder.btnPremium.setText("Premium: ₹ "+insurance.getPremium());

        animate(holder);
    }

    private void animate(MYVIEWHOLDER holder) {

        holder.itemView.setAnimation(AnimationUtils.loadAnimation(this.context, R.anim.anticipate_overshoot_interpolator));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        Button btnPremium;
        TextView tvDate, tvPolicyNo;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvPaymentDueDate);
            tvPolicyNo = itemView.findViewById(R.id.tvPolicyNO);
            btnPremium = itemView.findViewById(R.id.btnPremium);

        }
    }
}
