package com.online.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, String>{

	public Person findByFirstName(String firstName);
	public List<Person> findByAge(int age);
	public Person  findById(int Id);
}
