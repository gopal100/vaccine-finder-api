package com.covid.vaccineapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class VaccineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineApiApplication.class, args);
	}

	@Bean
	public RestTemplate crateRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(15);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("vaccine-reminder-");
		executor.initialize();
		return executor;
	}

	public static void main() {
		DCCaseAddressDetailsCargo dcCaseAddressDetailsCargo = new DCCaseAddressDetailsCargo();
		DCCaseAddressDetailsCargo[] results = {dcCaseAddressDetailsCargo};
		sortArr(results);
	}

	private static void sortArr(DCCaseAddressDetailsCargo[] results) {
		Arrays.sort(results,
				( cargo1, cargo2) -> cargo2.getEffBeginDt().compareTo(cargo1.getEffBeginDt()));
	}

}
