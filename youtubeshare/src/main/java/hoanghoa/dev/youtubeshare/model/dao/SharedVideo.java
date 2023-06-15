package hoanghoa.dev.youtubeshare.model.dao;

import hoanghoa.dev.youtubeshare.constant.VideoPlatform;
import hoanghoa.dev.youtubeshare.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "shared_video")
public class SharedVideo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "video_id")
    private String videoId;
    @Column(name = "video_title")
    private String videoTitle;
    @Column(name = "video_desc", columnDefinition = "text")
    private String videoDescription;
    @Column(name = "video_platform")
    @Enumerated(value = EnumType.STRING)
    private VideoPlatform platform;
    @Column(name = "user_email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public VideoPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(VideoPlatform platform) {
        this.platform = platform;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
