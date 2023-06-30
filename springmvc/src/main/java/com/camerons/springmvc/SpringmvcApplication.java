package com.camerons.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}
	@GetMapping("/")
	public String rootRedirect() {
		return "redirect:/tweet";
	}
}
