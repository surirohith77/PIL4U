package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.Features;
import com.octohub.pil4u.Model.RecentSearches;
import com.octohub.pil4u.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecentSearchesAdapter extends RecyclerView.Adapter<RecentSearchesAdapter.MYVIEWHOLDER> {

    List<RecentSearches> list;

    public RecentSearchesAdapter(List<RecentSearches> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_serarches_design,parent,false);
        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        RecentSearches recentSearches = list.get(position);
        Picasso.get().load(recentSearches.getImage()).into(holder.imageview);
        holder.tvTitle.setText(recentSearches.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageview;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
