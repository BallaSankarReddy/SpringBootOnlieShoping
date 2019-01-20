package com.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.entity.StudentRegistration;
import com.online.entity.StudentRegistrationReply;
import com.online.service.StudentRegisterService;

@Controller
public class StudentRegisterController {

	@Autowired
	StudentRegisterService studentRegisterService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/student")
	@ResponseBody
	StudentRegistrationReply registerStudent(
			@RequestBody StudentRegistration studentregd) {
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		stdregreply.setName(studentregd.getName());
		stdregreply.setAge(studentregd.getAge());
		StudentRegistration studentRegistration = studentRegisterService.studentRegistration(studentregd);
		stdregreply.setRegistrationNumber(studentRegistration.getId().toString());
		System.out.println(stdregreply.getAge());
		stdregreply.setRegistrationStatus("Successful");
		System.out.println(studentRegisterService.studentRegistration(studentregd).toString());
		return stdregreply;
	}
	
	@GetMapping(value="/studentID/{studentname}")
	public StudentRegistration getEMPID(@PathVariable String studentname){
		
		return studentRegisterService.getByStudentName(studentname)	;
	}
	
}