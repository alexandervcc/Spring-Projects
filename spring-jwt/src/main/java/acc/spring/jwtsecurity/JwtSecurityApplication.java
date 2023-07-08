package acc.spring.jwtsecurity;

import acc.spring.jwtsecurity.model.AppUser;
import acc.spring.jwtsecurity.model.Role;
import acc.spring.jwtsecurity.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserServiceImpl userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(
				new AppUser(null,
					"mijotron",
					"mijotron",
					"mijotron@doggo.com",
					"mijotron",
						new ArrayList<>())
			);
			userService.saveUser(
				new AppUser(null,
					"mana",
					"mana",
					"mana@doggo.com",
					"mana",
					new ArrayList<>())
			);
			userService.saveUser(
				new AppUser(null,
					"kuki",
					"kuki",
					"kuki@doggo.com",
					"kuki",
					new ArrayList<>())
			);
			userService.saveUser(
				new AppUser(null,
					"babas",
					"babas",
					"babas@doggo.com",
					"babas",
					new ArrayList<>())
			);

			userService.addRoleToUser("mana","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("babas","ROLE_USER");
			userService.addRoleToUser("kuki","ROLE_MANAGER");
			userService.addRoleToUser("mijotron","ROLE_ADMIN");


		};
	}
}
