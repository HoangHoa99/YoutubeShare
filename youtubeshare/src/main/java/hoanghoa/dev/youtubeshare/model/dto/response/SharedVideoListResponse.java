package hoanghoa.dev.youtubeshare.model.dto.response;

import hoanghoa.dev.youtubeshare.model.dao.SharedVideo;

import java.util.List;

public class SharedVideoListResponse extends BaseResponse {

    private List<SharedVideo> sharedVideoList;

    public List<SharedVideo> getSharedVideoList() {
        return sharedVideoList;
    }

    public void setSharedVideoList(List<SharedVideo> sharedVideoList) {
        this.sharedVideoList = sharedVideoList;
    }
}
