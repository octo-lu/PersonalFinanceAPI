package com.personal.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) {

		System.out.println("Running Personal Finance API");
		SpringApplication.run(FinanceApplication.class, args

		);
	}

}
