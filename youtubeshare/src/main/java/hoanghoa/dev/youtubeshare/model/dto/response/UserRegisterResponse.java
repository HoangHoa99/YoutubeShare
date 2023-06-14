package hoanghoa.dev.youtubeshare.model.dto.response;

public class UserRegisterResponse extends BaseResponse {

    public UserRegisterResponse(String message) {
        super(message, false);
    }
    public UserRegisterResponse(String message, Boolean error) {
        super(message, error);
    }
    public UserRegisterResponse() {}
}
