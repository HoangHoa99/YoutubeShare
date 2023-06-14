package hoanghoa.dev.youtubeshare.model.dto.response;

import hoanghoa.dev.youtubeshare.model.dto.AbstractBaseResponse;

import java.io.Serializable;

public class BaseResponse extends AbstractBaseResponse implements Serializable {

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        super(message, false);
    }

    public BaseResponse(String message, Boolean error) {
        super(message, error);
    }
}
