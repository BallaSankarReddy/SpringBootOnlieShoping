package com.online.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person_Address")
public class Address {
 
    @Id
    @GeneratedValue
    private long id;
 
    @Column(nullable = false)
    private String location;
 
    @OneToOne(mappedBy = "address")
    private Person person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
 
    // standard constructor, getters, setters
    
    
    
}