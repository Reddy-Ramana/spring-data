package com.spring.basics.data.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.basics.data.entity.Person;

@Repository
@Transactional
public class PersonInfoJPA {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findPersonById(int id) {
		return entityManager.find(Person.class, id) ;
	}

	public Person UpdatePersonById(Person person) {
		return entityManager.merge(person) ;
	}
	
	
	public Person CreatePersonById(Person person) {
		return entityManager.merge(person) ;
	}

	public void deletePersonById(int id) {
		Person person = findPersonById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		
		  TypedQuery<Person> named_query = entityManager.createNamedQuery("find_all_persons", Person.class);
		 return named_query.getResultList();
		
	}
}

