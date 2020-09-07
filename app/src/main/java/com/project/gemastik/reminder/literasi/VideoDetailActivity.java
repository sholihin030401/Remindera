package com.project.gemastik.reminder.literasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.project.gemastik.reminder.R;

public class VideoDetailActivity extends AppCompatActivity {

    public static final String EXTRA_VIDEO = "ExtraVideo";
    WebView videoView;
    TextView tlVideo, dsVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        videoView = findViewById(R.id.video_view);
        tlVideo = findViewById(R.id.title_video);
        dsVideo = findViewById(R.id.desk_video);

        VideoItem item = getIntent().getParcelableExtra(EXTRA_VIDEO);

        videoView.loadUrl(item.getVideoUrl());
        tlVideo.setText(item.getTitleVideo());
        dsVideo.setText(item.getDescVideo());
    }
}
