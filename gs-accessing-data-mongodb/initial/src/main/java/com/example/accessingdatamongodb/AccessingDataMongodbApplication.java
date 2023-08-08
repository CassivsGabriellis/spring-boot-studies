package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// Save a couple of customers;
		repository.save(new Customer("Cássio", "Gabriel"));
		repository.save(new Customer("Ronald", "Davy"));

		//fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Cássio'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Cássio"));

		System.out.println("Customers found with findByLastName('Gabriel'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Gabriel")) {
			System.out.println(customer);
		}
	}

}
