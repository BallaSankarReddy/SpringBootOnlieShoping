package com.online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.StudentRegisterDAO;
import com.online.entity.StudentRegistration;

@Service("studentRegisterService")
public class StudentRegisterService {

	@Autowired
	private StudentRegisterDAO studentRegisterDAO;

	
	public void setStudentRegisterDAO(StudentRegisterDAO studentRegisterDAO) {
		this.studentRegisterDAO = studentRegisterDAO;
	}


	/**
	 * @param studentRegistration
	 * @return
	 */
	public StudentRegistration studentRegistration(
			StudentRegistration studentRegistration) {

		return studentRegisterDAO.save(studentRegistration);
	}

	public StudentRegistration getByStudentName(String studentName){
		return studentRegisterDAO.getByName(studentName);
	}

	
}
