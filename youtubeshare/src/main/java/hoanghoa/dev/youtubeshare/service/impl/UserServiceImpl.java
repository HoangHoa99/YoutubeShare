package hoanghoa.dev.youtubeshare.service.impl;

import hoanghoa.dev.youtubeshare.model.dao.User;
import hoanghoa.dev.youtubeshare.model.dto.request.UserRequest;
import hoanghoa.dev.youtubeshare.model.dto.response.UserLoginResponse;
import hoanghoa.dev.youtubeshare.repository.UserRepository;
import hoanghoa.dev.youtubeshare.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserLoginResponse login(UserRequest request) {
        User existedUser = this.checkExistedUser(request.getEmail());
        if(Objects.nonNull(existedUser)) {
            boolean passMatch = encoder.matches(request.getPassword(), existedUser.getPassword());
            if(!passMatch) {
                UserLoginResponse response = new UserLoginResponse();
                response.setError(true);
                response.setMessage("Incorrect login info");

                return response;
            }
        }
        else {
            existedUser = this.saveUser(request);
        }
        UserLoginResponse response = new UserLoginResponse();
        response.setUser(existedUser);

        return response;
    }

    private User checkExistedUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        return userOptional.orElse(null);
    }

    private User saveUser(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return user;
    }
}
