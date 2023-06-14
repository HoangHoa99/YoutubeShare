package hoanghoa.dev.youtubeshare.model.dto.response;

import hoanghoa.dev.youtubeshare.model.dao.User;

public class UserLoginResponse extends BaseResponse {
    public UserLoginResponse(String message) {
        super(message, false);
    }
    public UserLoginResponse(String message, Boolean error) {
        super(message, error);
    }
    public UserLoginResponse() {}

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
