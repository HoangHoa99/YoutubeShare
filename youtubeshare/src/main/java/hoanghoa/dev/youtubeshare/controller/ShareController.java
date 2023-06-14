package hoanghoa.dev.youtubeshare.controller;

import hoanghoa.dev.youtubeshare.model.dto.request.ShareYoutubeUrlRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.BaseResponse;
import hoanghoa.dev.youtubeshare.model.dto.response.SharedVideoListResponse;
import hoanghoa.dev.youtubeshare.service.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private IShareService shareService;

    @PostMapping("youtube")
    public BaseResponse shareYoutubeUrl(@Valid @RequestBody ShareYoutubeUrlRequest request) {
        return shareService.share(request);
    }

    @GetMapping("youtube/list")
    public SharedVideoListResponse listSharedVideo() {
        return shareService.list();
    }
}
