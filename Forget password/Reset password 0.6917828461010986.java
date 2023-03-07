
Controller class:

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ResetPasswordController {
    
    @RequestMapping("/reset-password")
    public void resetPassword() {
        // code to reset the password
    }
}

Service class:

import org.springframework.stereotype.Service;

@Service
public class ResetPasswordService {

    public void resetPasswordRequest(String email) {
        // code to send the reset password request
    }

    public void resetPassword(String email, String newPassword) {
        // code to reset the password
    }
}

Repository class:

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}