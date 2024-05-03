package com.restapp.ticketmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class TicketManagementApplication {

	@ResponseBody
	@RequestMapping("/")
	public String testSetup() {
		return "Test 12345";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TicketManagementApplication.class, args);
	}

}
