package com.serdev.account;

import com.serdev.account.model.Customer;
import com.serdev.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer=customerRepository.save(new Customer("","Huseyin","Beler",new HashSet<>()));
		System.out.println(customer);
	}
}
