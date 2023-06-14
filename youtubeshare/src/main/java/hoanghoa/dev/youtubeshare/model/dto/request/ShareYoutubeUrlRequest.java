package hoanghoa.dev.youtubeshare.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ShareYoutubeUrlRequest {

    @NotNull(message = "Shared person must be required")
    private Long userId;
    @NotEmpty(message = "Video url must be required")
    private String youtubeVideoUrl;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getYoutubeVideoUrl() {
        return youtubeVideoUrl;
    }

    public void setYoutubeVideoUrl(String youtubeVideoUrl) {
        this.youtubeVideoUrl = youtubeVideoUrl;
    }

    public String getYoutubeVideoId() {
        int ytbPrefixLength = "https://youtu.be/".length();
        return this.youtubeVideoUrl.substring(ytbPrefixLength);
    }
}
