package com.spring.basics.data.entity;

import java.util.Date;

public class Person {

	private long id;
	private String name;
	private String location;
	private Date dateOfBirth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person() {
	}

	public Person(long id, String name, String location, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [\nid=" + id + ", name=" + name + ", location=" + location + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
