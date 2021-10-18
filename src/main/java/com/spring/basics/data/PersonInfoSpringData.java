package com.spring.basics.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.basics.data.entity.Person;

public interface PersonInfoSpringData extends JpaRepository<Person, Integer> {

}
