package com.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.RestApi.binding.Passenger;
import com.RestApi.service.MTMserviceImpl;

@SpringBootApplication
public class MakeMyTrip1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MakeMyTrip1Application.class, args);

		/*
		 * Passenger p = new Passenger(); p.setName("Harsha"); p.setSource("HYD");
		 * p.setDestination("VIZAG"); p.setTrainNum(2345);
		 * 
		 * MTMserviceImpl bean = context.getBean(MTMserviceImpl.class);
		 * 
		 * ResponseEntity<String> bookTicket = bean.bookTicket(p); String body =
		 * bookTicket.getBody(); System.out.println(body);
		 */
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}