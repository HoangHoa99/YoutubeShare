package hoanghoa.dev.youtubeshare.controller;

import hoanghoa.dev.youtubeshare.model.dto.request.UserRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.UserLoginResponse;
import hoanghoa.dev.youtubeshare.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public UserLoginResponse login(@Valid @RequestBody UserRequest request) {

        return userService.login(request);
    }
}
