package br.com.projeto.ecommerce;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Map<String, PasswordEncoder> encoders = new HashedMap<>();
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());

		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());

		String result = passwordEncoder.encode("admin234");
		System.out.println("My hash " + result);
	}

}
