package com.project.gemastik.reminder.literasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.gemastik.reminder.R;

public class VideoDetailActivity extends AppCompatActivity {

    public static final String EXTRA_VIDEO = "ExtraVideo";
    WebView videoView;
    TextView tlVideo, dsVideo;
    ProgressBar bar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        videoView = findViewById(R.id.video_view);
        tlVideo = findViewById(R.id.title_video);
        dsVideo = findViewById(R.id.desk_video);
        bar = findViewById(R.id.progress_detail);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e){ }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        VideoItem item = getIntent().getParcelableExtra(EXTRA_VIDEO);

                        videoView.loadUrl(item.getVideoUrl());
                        videoView.setWebViewClient(new WebViewClient());
                        videoView.setWebChromeClient(new WebChromeClient());
                        videoView.getSettings().setJavaScriptEnabled(true);
                        tlVideo.setText(item.getTitleVideo());
                        dsVideo.setText(item.getDescVideo());
                    }
                });
            }
        }).start();

    }
}
