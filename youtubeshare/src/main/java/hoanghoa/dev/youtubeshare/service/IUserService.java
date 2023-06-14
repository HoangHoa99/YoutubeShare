package hoanghoa.dev.youtubeshare.service;

import hoanghoa.dev.youtubeshare.model.dto.request.UserRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.UserLoginResponse;

public interface IUserService {

    UserLoginResponse login(UserRequest request);
}
