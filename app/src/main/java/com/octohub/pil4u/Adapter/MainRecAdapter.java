package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.FirstList;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainRecAdapter extends RecyclerView.Adapter<MainRecAdapter.MYVIEWHOLDER> {

    Context context;
    List<FirstList> list;

    public MainRecAdapter(Context context, List<FirstList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_display_layout,parent,false);

        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {
        FirstList firstList = list.get(position);

        Picasso.get().load(firstList.getImage()).into(holder.iv);
        holder.tvName.setText(firstList.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tvName;
        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.ivicon);
            tvName = itemView.findViewById(R.id.tvHint);
        }
    }
}
