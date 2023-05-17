package com.veterinaria.veterinaraback;

import com.veterinaria.veterinaraback.config.FilterCors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class VeterinaraBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaraBackApplication.class, args);
	}


}
