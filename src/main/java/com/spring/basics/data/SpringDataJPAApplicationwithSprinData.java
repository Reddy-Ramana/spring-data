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

@SpringBootApplication
public class SpringDataJPAApplicationwithSprinData implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonInfoSpringData personInfoJPA;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPAApplicationwithSprinData.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("Getting preson by ID {}", personInfoJPA.findById(10001));

		LOGGER.info("Add a person {}",personInfoJPA.save(new Person(1001," Ramana Reddy","India",new Date())));
		LOGGER.info("Add a person {}",personInfoJPA.save(new Person(23,"Ramana Reddy1","India",new Date())));
			personInfoJPA.deleteById(1001);
		/*LOGGER.info("Add a person {}",personInfoJPA.findAll());*/
	}

}
