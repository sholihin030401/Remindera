package com.project.gemastik.reminder.literasi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.project.gemastik.reminder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    RecyclerView rv_videoView;
    ArrayList<VideoItem> videoItemArrayList;
    ShimmerFrameLayout shimmerFrameLayout;
    Handler handler;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        rv_videoView = view.findViewById(R.id.rv_video);
        rv_videoView.setHasFixedSize(true);

        dataVideo();

        VideoAdapter videoAdapter = new VideoAdapter(this.getContext());
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_videoView.setLayoutManager(manager);
        videoAdapter.setVideoItems(videoItemArrayList);
        rv_videoView.setAdapter(videoAdapter);

        handler = new Handler();
        shimmerFrameLayout = view.findViewById(R.id.shimmer_load);
        shimmerFrameLayout.startShimmer();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.hideShimmer();
            }
        },3000);
        return view;
    }

    private void dataVideo(){
        videoItemArrayList = new ArrayList<>();
        videoItemArrayList.add(new VideoItem(R.drawable.thumbnail,
                "https://www.youtube.com/embed/ID2JlUoykXs",
                "Rahasia Kesuksesan Jack Ma",
                "Test","Pengembangan Diri"));
    }
}
