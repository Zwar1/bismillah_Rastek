package Rastek_fix.demo;

import Rastek_fix.demo.Entity.UserEntity;
import Rastek_fix.demo.Repository.UserRepository;
import Rastek_fix.demo.Security.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private UserRepository userRepository;
	@Bean
	public CommandLineRunner initDatabase(UserRepository userRepository) {
		return args -> {
			// Cek apakah user dengan username "Admin" sudah ada
			if (userRepository.findByUsername("Admin").isEmpty()) {
				// Jika tidak ada, enkripsi password dan simpan user baru
				String password = "Lontongsayur@39";
				String salt = BCrypt.gensalt(); // Generate a salt
				String encodedPassword = BCrypt.hashpw(password, salt); // Encrypt the password
				userRepository.save(new UserEntity(null, "Admin", encodedPassword, "tetew39@gmail.com", true, false, null, null, null, null, null, null));
				System.out.println("Admin user created with encrypted password");
			} else {
				// Jika sudah ada, tidak melakukan apa-apa atau melakukan log
				System.out.println("Admin user already exists, no new user added");
			}
		};
	}

}