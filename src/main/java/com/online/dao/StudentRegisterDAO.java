package com.online.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.entity.StudentRegistration;

@Repository
public interface StudentRegisterDAO extends JpaRepository<StudentRegistration, Integer>{
 
	public StudentRegistration getByName(String name);
}
