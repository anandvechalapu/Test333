
@RestController
@RequestMapping("/configure-jira-github")
public class ConfigureJiraGithubController {
    
    private ConfigureJiraGithubService configureJiraGithubService;

    @Autowired
    public ConfigureJiraGithubController(ConfigureJiraGithubService configureJiraGithubService) {
        this.configureJiraGithubService = configureJiraGithubService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getServices() {
        List<String> services = configureJiraGithubService.getServices();

        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<Void> configureJiraGithub(@RequestBody Credentials credentials) {
        configureJiraGithubService.configureJiraGithub(credentials);

        return ResponseEntity.ok().build();
    }
}

public class ConfigureJiraGithubService {
    
    private ConfigureJiraGithubRepository configureJiraGithubRepository;

    public ConfigureJiraGithubService(ConfigureJiraGithubRepository configureJiraGithubRepository) {
        this.configureJiraGithubRepository = configureJiraGithubRepository;
    }

    public List<String> getServices() {
        return configureJiraGithubRepository.getServices();
    }

    public void configureJiraGithub(Credentials credentials) {
        configureJiraGithubRepository.configureJiraGithub(credentials);
    }
}

public interface ConfigureJiraGithubRepository {

    List<String> getServices();

    void configureJiraGithub(Credentials credentials);
}