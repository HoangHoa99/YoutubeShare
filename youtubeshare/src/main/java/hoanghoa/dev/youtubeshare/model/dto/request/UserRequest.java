package hoanghoa.dev.youtubeshare.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserRequest {

    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "Password us required")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
