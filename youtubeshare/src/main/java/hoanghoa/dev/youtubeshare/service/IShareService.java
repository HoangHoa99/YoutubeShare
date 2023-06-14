package hoanghoa.dev.youtubeshare.service;

import hoanghoa.dev.youtubeshare.model.dto.request.ShareYoutubeUrlRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.BaseResponse;
import hoanghoa.dev.youtubeshare.model.dto.response.SharedVideoListResponse;

public interface IShareService {
    BaseResponse share(ShareYoutubeUrlRequest request);

    SharedVideoListResponse list();
}
