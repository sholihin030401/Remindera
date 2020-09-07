package com.project.gemastik.reminder.literasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.gemastik.reminder.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

    private ArrayList<VideoItem> videoItems;
    private Context context;

    public ArrayList<VideoItem> getVideoItems() {
        return videoItems;
    }

    public void setVideoItems(ArrayList<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    public VideoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);

        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoHolder holder, int position) {
        VideoItem item = videoItems.get(position);

        String url_thumbnail = "https://www.google.com/"+item.getThumbnail();
        holder.titleVideo.setText(item.getTitleVideo());
        holder.katVideo.setText(item.getKatVideo());
        Glide.with(holder.itemView.getContext())
                .load(url_thumbnail)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView thumbnail;
        TextView titleVideo, katVideo;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.image_thumbnail);
            titleVideo = itemView.findViewById(R.id.title_video);
            katVideo = itemView.findViewById(R.id.kat_video);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            VideoItem videoItem = getVideoItems().get(pos);
            videoItem.setTitleVideo(videoItem.getTitleVideo());

            Intent moveIntent = new Intent(itemView.getContext(), VideoDetailActivity.class);
            moveIntent.putExtra(VideoDetailActivity.EXTRA_VIDEO, videoItem);
            context.startActivity(moveIntent);
        }
    }
}
