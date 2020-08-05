package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.MyNotification;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyNotificationAdapter extends RecyclerView.Adapter<MyNotificationAdapter.MYVIEWHOLDER> {

    List<MyNotification> list;

    public MyNotificationAdapter(List<MyNotification> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_notificatioin_desgin,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {


        MyNotification myNotification = list.get(position);

        Picasso.get().load(myNotification.getImages()).into(holder.ivUser);

        holder.tvName.setText(myNotification.getName());
        holder.tvMsg.setText(myNotification.getMsg());

      String onlineStatus =  myNotification.getOnlineStatus();
        String unReadMsgs =  myNotification.getUnReadMsgs();

        if (onlineStatus.equals("Offline")){

            holder.ivUserStatus.setImageResource(R.drawable.ic_red_dot);
        }else  if (onlineStatus.equals("Pending")){

            holder.ivUserStatus.setImageResource(R.drawable.ic_yellow_dot);
        }


        if (!unReadMsgs.equals("0")){

            holder.btnUnread.setText(unReadMsgs);
        } else {

            holder.btnUnread.setVisibility(View.GONE);
        }

       // holder.tvBuildingType.setText(myNotification.getBuildingType());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        TextView tvName, tvMsg;
        ImageView ivUser, ivUserStatus;
        AppCompatButton btnUnread;
        CardView cardView;


        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);


             /*  cardView = itemView.findViewById(R.id.cardview);
            cardView.setBackgroundResource(R.drawable.cardview_corner_radius);*/

            tvName = itemView.findViewById(R.id.tvName);
            tvMsg = itemView.findViewById(R.id.tvMsg);
            ivUser = itemView.findViewById(R.id.ivUser);
            ivUserStatus = itemView.findViewById(R.id.ivUserStatus);
            btnUnread = itemView.findViewById(R.id.btnUnread);

        }
    }
}
