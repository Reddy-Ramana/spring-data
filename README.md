# spring-data

Spring JDBC

	1. With Spring JDBC we would not need any boiler plate code to make JDBC connection 
	2. We Can use JDBCTemplate with auto wiring to do all the transactions with  the database, all the infrastrusture things like getting connection , opening connection, closing connection .etc with be handled by spring Data
	3. We can use Spring Data by this dependency
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-data-jdbc</artifactId>
				</dependency>
	4. The DAO class should be annotated with @Repository annotation
	5. JdbcTemplate should be auto wired.
	6. There are various methods in JdbcTemplate use the according few of the basic CURD operations are shown in PersonJdbcDao.java
	7. We have a class BeanPropertyRowMapper which will allow us to map the response of the result set to an entity (Bean or Pojo) but the column Names in DB should match with member variables
	8. We can create a custom Row Mapper by implementing RowMapper interface.