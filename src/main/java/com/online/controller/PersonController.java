package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.entity.Person;
import com.online.exception.PersonDataNotFoundException;
import com.online.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	/* @RequestMapping("/home")
	 @ResponseBody
	 public String home() {
	  return "index";
	 }*/
	 
	 @RequestMapping(value = "/", method = RequestMethod.GET)
		public String showWelcomePage(ModelMap model) {
			model.put("name", "Hi Sankar");
			return "index";
		}
	 
	@RequestMapping("/person/create")
	public Person cratePerson(ModelMap model,@RequestBody Person person){
		
		model.put("person", person);
		
		return personService.createPerson(person);
	}
	
	@RequestMapping("/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@GetMapping("/name")
	public Person getByFirstName(@RequestParam("firstName") String firstName) throws PersonDataNotFoundException {
		
		if(!firstName.endsWith("!")){
			throw new PersonDataNotFoundException("firstName :: "+firstName);
			
		}
		return personService.findByFirstName(firstName);
	}
	
	
	@GetMapping("/age")
	public List<Person> findByAge(int age){
		return personService.findByAge(age);
	}
@GetMapping("/getById/{id}")
public Person getById(@PathVariable int id){
	
	return personService.findById(id);
}
	
}
