package com.spring.basics.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.basics.data.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonInfoRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setDateOfBirth((rs.getTimestamp("birth_date")));
			return person;
		}
	}
	
	public List<Person> findAllPersons() {

		return jdbcTemplate.query("select * from person", new PersonInfoRowMapper());
	}

	public Person findPersonById(int id) {

		return (Person) jdbcTemplate.queryForObject("select * from person where id=?",
				new BeanPropertyRowMapper(Person.class), new Object[] { id });

	}

	public List<Person> findPersonByNames(String Name) {

		return jdbcTemplate.query("select * from person where name=?", new BeanPropertyRowMapper(Person.class),
				new Object[] { "Ramana" });

	}

	public int deletebyID(int id) {

		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}
	
	public int insertInPerson(Person person) {
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) \r\n" + 
				"VALUES(?,  ?, ?,?);", person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getDateOfBirth().getTime()));
		
	}
	
	
	public int updatePerson(Person person) {
		return jdbcTemplate.update("update person set NAME=?,Location=?,birth_date=? " +
				" where id=? ; ", person.getName(),person.getLocation(),new Timestamp(person.getDateOfBirth().getTime()),person.getId());
		
	}
}
