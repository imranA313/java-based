package c2m.security;

import c2m.security.entity.Role;
import c2m.security.entity.User;
import c2m.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

    public SecurityApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		User adminAcc = userRepository.findByRole(Role.ADMIN);

		if(adminAcc == null) {
			User user = new User("imran", "ansari", "imran@gmail.com",
					new BCryptPasswordEncoder().encode("admin"), Role.ADMIN);
			userRepository.save(user);
		}
	}
}
