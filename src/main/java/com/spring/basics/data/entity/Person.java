package com.spring.basics.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date birthDate;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateOfBirth() {
		return birthDate;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.birthDate = dateOfBirth;
	}

	public Person() {
	}

	public Person(int id, String name, String location, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = dateOfBirth;
	}
	
	public Person(String name, String location, Date dateOfBirth) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [\nid=" + id + ", name=" + name + ", location=" + location + ", dateOfBirth=" + birthDate + "]";
	}

}
