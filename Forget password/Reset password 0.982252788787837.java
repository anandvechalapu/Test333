

@RestController
public class ResetPasswordController {
  
    @Autowired
    private ResetPasswordService resetPasswordService;
  
    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        resetPasswordService.resetPassword(resetPasswordRequest);
    }
}

@Service
public class ResetPasswordService {

    @Autowired
    private ResetPasswordRepository resetPasswordRepository;

    public void resetPassword(ResetPasswordRequest resetPasswordRequest){
        // Generate token
        String token = generateToken();
        // Create request
        CreatePasswordResetRequest createPasswordResetRequest = new CreatePasswordResetRequest();
        createPasswordResetRequest.setToken(token);
        createPasswordResetRequest.setEmail(resetPasswordRequest.getEmail());
        // Save request
        resetPasswordRepository.save(createPasswordResetRequest);
        // Send mail
        sendResetPasswordEmail(resetPasswordRequest.getEmail(), token);
    }

    private void sendResetPasswordEmail(String email, String token) {
        // Send mail to the given email
    }

    private String generateToken() {
        // Generate random token
    }
}

@Repository
public interface ResetPasswordRepository extends JpaRepository<CreatePasswordResetRequest, Long> {

}

public class ResetPasswordRequest {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class CreatePasswordResetRequest {

    @Id
    @GeneratedValue
    private Long id;

    private String token;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}