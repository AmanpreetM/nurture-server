package com.bal.asha.nurture.server;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableEncryptableProperties
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class NurtureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurtureServerApplication.class, args);
	}

}
