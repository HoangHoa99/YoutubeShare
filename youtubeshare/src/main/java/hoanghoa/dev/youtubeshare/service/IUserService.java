package hoanghoa.dev.youtubeshare.service;

import hoanghoa.dev.youtubeshare.model.dto.request.UserRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.UserLoginResponse;
import hoanghoa.dev.youtubeshare.model.dto.response.UserRegisterResponse;

public interface IUserService {

    UserRegisterResponse saveUser(UserRequest request);

    UserLoginResponse login(UserRequest request);
}
