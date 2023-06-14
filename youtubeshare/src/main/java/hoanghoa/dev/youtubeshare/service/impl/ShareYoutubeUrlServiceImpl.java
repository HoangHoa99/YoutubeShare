package hoanghoa.dev.youtubeshare.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import hoanghoa.dev.youtubeshare.constant.APIKey;
import hoanghoa.dev.youtubeshare.constant.VideoPlatform;
import hoanghoa.dev.youtubeshare.model.dao.SharedVideo;
import hoanghoa.dev.youtubeshare.model.dao.User;
import hoanghoa.dev.youtubeshare.model.dto.request.ShareYoutubeUrlRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.BaseResponse;
import hoanghoa.dev.youtubeshare.model.dto.response.SharedVideoListResponse;
import hoanghoa.dev.youtubeshare.repository.SharedVideoRepository;
import hoanghoa.dev.youtubeshare.repository.UserRepository;
import hoanghoa.dev.youtubeshare.service.IShareService;
import hoanghoa.dev.youtubeshare.util.ExternalAPICallUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ShareYoutubeUrlServiceImpl implements IShareService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShareYoutubeUrlServiceImpl.class);

    @Autowired
    private SharedVideoRepository sharedVideoRepository;
    @Autowired
    private UserRepository userRepository;

    @Value("${google.api.key}")
    private String googleAPIKey;
    @Value("${google.api.host}")
    private String googleAPIHost;
    @PostConstruct
    private void initAPIKey() {
        APIKey.GOOGLE_API_KEY = this.googleAPIKey;
        APIKey.GOOGLE_API_HOST = this.googleAPIHost;
    }

    @Override
    public BaseResponse share(ShareYoutubeUrlRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            // check existed user
            Optional<User> userOptional = userRepository.findById(request.getUserId());
            if(userOptional.isEmpty()) {
                LOGGER.error("Error occur while sharing video. User not found");

                String message  = "User not found!";
                return new BaseResponse(message, true);
            }
            // build share video record
            SharedVideo sharedVideo = this.initSharedVideo(request.getYoutubeVideoId(), userOptional.get().getEmail());

            sharedVideoRepository.save(sharedVideo);

            String message = "Video has shared successfully!";
            baseResponse.setMessage(message);
        }
        catch (Exception e) {
            LOGGER.error("Error occur while sharing video. Message: {}", e.getMessage());

            String message = "Video has shared failure!";
            baseResponse.setMessage(message);
            baseResponse.setError(true);
        }
        return baseResponse;
    }

    @Override
    public SharedVideoListResponse list() {
        SharedVideoListResponse response = new SharedVideoListResponse();
        try {
            List<SharedVideo> sharedVideoList = sharedVideoRepository.findAll();

            response.setSharedVideoList(sharedVideoList);
        }
        catch (Exception e) {
            LOGGER.error("Error occur while getting list of shared video. Message: {}", e.getMessage());
            String message = "Get shared video list failure!";
            response.setMessage(message);
            response.setError(true);
        }

        return response;
    }

    private SharedVideo initSharedVideo(String videoId, String email) {
        JsonNode res = ExternalAPICallUtil.call(videoId);

        JsonNode items = res.get("items");
        JsonNode snippet = items.get(0).get("snippet");
        String title = snippet.get("title").asText();
        String desc = snippet.get("description").asText();

        SharedVideo sharedVideo = new SharedVideo();
        sharedVideo.setVideoId(videoId);
        sharedVideo.setVideoTitle(title);
        sharedVideo.setVideoDescription(desc);
        sharedVideo.setPlatform(VideoPlatform.YOUTUBE);
        sharedVideo.setEmail(email);

        return sharedVideo;
    }
}
