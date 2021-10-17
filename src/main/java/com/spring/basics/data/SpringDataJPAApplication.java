package com.spring.basics.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.basics.data.entity.Person;
import com.spring.basics.data.jdbc.PersonInfoJPA;

//@SpringBootApplication
public class SpringDataJPAApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonInfoJPA personInfoJPA;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("Getting preson by ID {}", personInfoJPA.findPersonById(10001));

		LOGGER.info("Add a person {}",personInfoJPA.UpdatePersonById(new Person(10001," Ramana Reddy","India",new Date())));
		LOGGER.info("Add a person {}",personInfoJPA.CreatePersonById(new Person(23,"Ramana Reddy1","India",new Date())));
		personInfoJPA.deletePersonById(10003);
		LOGGER.info("Add a person {}",personInfoJPA.findAll());
	}

}
