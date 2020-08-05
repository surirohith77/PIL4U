package com.octohub.pil4u.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Model.youtubeVideos;
import com.octohub.pil4u.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class YoutubePlayerAdapter extends RecyclerView.Adapter<YoutubePlayerAdapter.MYVIEWHOLDER> {

    List<youtubeVideos> list;

    public YoutubePlayerAdapter(List<youtubeVideos> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video,parent,false);

        return new MYVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYVIEWHOLDER holder, int position) {

        final youtubeVideos youtubeVideos =   list.get(position);

        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
             //   String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(youtubeVideos.getVideoid(), 0);
                youTubePlayer.pause();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        YouTubePlayerView youTubePlayerView;

        public MYVIEWHOLDER(@NonNull View itemView) {
            super(itemView);

            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        }
    }
}
