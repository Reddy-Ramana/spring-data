package com.spring.basics.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.basics.data.entity.Person;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("List of presons {}",personJdbcDao.findAllPersons());
		LOGGER.info("Getting preson by ID {}",personJdbcDao.findPersonById(10001));
		LOGGER.info("Getting preson by Name {}",personJdbcDao.findPersonByNames("Ramana"));
		LOGGER.info("Getting preson by Name {}",personJdbcDao.deletebyID(10003));
		LOGGER.info("List of presons {}",personJdbcDao.findAllPersons());
		LOGGER.info("Add a person {}",personJdbcDao.insertInPerson(new Person(10005,"Dude","India",new Date())));
		LOGGER.info("List of presons {} \n ",personJdbcDao.findAllPersons());
		LOGGER.info("Add a person {}",personJdbcDao.updatePerson(new Person(10002,"James","Colombus",new Date())));
		LOGGER.info("List of presons {} \n ",personJdbcDao.findAllPersons());
		
	}

}
