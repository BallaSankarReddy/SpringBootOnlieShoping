package com.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.PersonDao;
import com.online.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	// creating the person data
	public Person createPerson(Person person) {

		return personDao.save(person);
	}

	public List<Person> getAll() {
		return personDao.findAll();
	}

	public Person findByFirstName(String firstName) {
		return personDao.findByFirstName(firstName);
	}
	
	public Person findById(int id){
		Person p = personDao.findById(id);
		return p;
		
	}

	public Person upadatePerson(String firstName, String lastName, int age) {

		Person p = personDao.findByFirstName(firstName);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personDao.save(p);

	}

	public void deletAllPersonData() {
		personDao.deleteAll();
	}

	public void deletParticularPersondata(String firstName) {
		Person p = personDao.findByFirstName(firstName);
		personDao.delete(p);
	}
	
	public List<Person> findByAge(int age){
		return personDao.findByAge(age);
	}

}
