package com.project.gemastik.reminder.literasi;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoItem implements Parcelable {

    private String thumbnail;
    private String videoUrl;
    private String titleVideo;
    private String descVideo;
    private String katVideo;

    public VideoItem(String thumbnail, String videoUrl, String titleVideo, String descVideo, String katVideo) {
        this.thumbnail = thumbnail;
        this.videoUrl = videoUrl;
        this.titleVideo = titleVideo;
        this.descVideo = descVideo;
        this.katVideo = katVideo;
    }

    protected VideoItem(Parcel in) {
        thumbnail = in.readString();
        videoUrl = in.readString();
        titleVideo = in.readString();
        descVideo = in.readString();
        katVideo = in.readString();
    }

    public static final Creator<VideoItem> CREATOR = new Creator<VideoItem>() {
        @Override
        public VideoItem createFromParcel(Parcel in) {
            return new VideoItem(in);
        }

        @Override
        public VideoItem[] newArray(int size) {
            return new VideoItem[size];
        }
    };

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitleVideo() {
        return titleVideo;
    }

    public void setTitleVideo(String titleVideo) {
        this.titleVideo = titleVideo;
    }

    public String getDescVideo() {
        return descVideo;
    }

    public void setDescVideo(String descVideo) {
        this.descVideo = descVideo;
    }

    public String getKatVideo() {
        return katVideo;
    }

    public void setKatVideo(String katVideo) {
        this.katVideo = katVideo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(thumbnail);
        parcel.writeString(videoUrl);
        parcel.writeString(titleVideo);
        parcel.writeString(descVideo);
        parcel.writeString(katVideo);
    }
}
