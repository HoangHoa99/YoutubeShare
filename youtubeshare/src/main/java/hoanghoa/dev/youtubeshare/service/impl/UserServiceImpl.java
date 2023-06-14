package hoanghoa.dev.youtubeshare.service.impl;

import hoanghoa.dev.youtubeshare.model.dao.User;
import hoanghoa.dev.youtubeshare.model.dto.request.UserRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.UserLoginResponse;
import hoanghoa.dev.youtubeshare.model.dto.response.UserRegisterResponse;
import hoanghoa.dev.youtubeshare.repository.UserRepository;
import hoanghoa.dev.youtubeshare.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResponse saveUser(UserRequest request) {
        UserRegisterResponse response;
        try {
            User existedUser = this.checkExistedUser(request.getEmail());
            if(Objects.nonNull(existedUser)) {
                String message = "User has already existed!";
                return new UserRegisterResponse(message, true);
            }

            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            userRepository.save(user);

            response = new UserRegisterResponse();
            response.setMessage("User register successfully!");
        }
        catch (Exception e) {
            LOGGER.error("Error occur while saving new user. Message: {}", e.getMessage());

            String message = "User register failure!";
            response = new UserRegisterResponse(message, true);
        }

        return response;
    }

    @Override
    public UserLoginResponse login(UserRequest request) {
        User existedUser = this.checkExistedUser(request.getEmail());
        if(Objects.isNull(existedUser)) {
            String message = "User has not existed!";
            return new UserLoginResponse(message, true);
        }
        UserLoginResponse response = new UserLoginResponse();
        response.setUser(existedUser);

        return response;
    }

    private User checkExistedUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        return userOptional.orElse(null);
    }
}
