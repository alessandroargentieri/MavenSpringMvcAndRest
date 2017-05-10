package it.euris.example.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.euris.example.dao.UserDAO;
import it.euris.example.models.User;



@RestController
public class SpringRestController {

	
	@Autowired
	private UserDAO userDAO;
	
	//usato solo per /esempio e non perchè sto usando userDAO
	@Autowired
	private User luciaUser;
	
	
	@RequestMapping(value="/esempio", method=RequestMethod.GET)
	@ResponseBody
	public String esempio(){
		String esempioJSON = "[{";
		esempioJSON = esempioJSON + "'name' : '" + luciaUser.getName() + "', ";
		esempioJSON = esempioJSON + "'surname' : '" + luciaUser.getSurname() + "'}]";
		return esempioJSON;
	}
	
	@GetMapping("/users")
	public List getUsers() {
		return userDAO.list();
	}

	
	@GetMapping("/users/{name}")
	public ResponseEntity getCustomer(@PathVariable("name") String name) {
		User user = userDAO.get(name);
		if (user == null) {
			return new ResponseEntity("No User found for name " + name, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	
	@PostMapping(value = "/users")
	public ResponseEntity createCustomer(@RequestBody User user) {
		userDAO.create(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	
	@DeleteMapping("/users/{name}")
	public ResponseEntity deleteUser(@PathVariable String name) {
		if (null == userDAO.delete(name)) {
			return new ResponseEntity("No User found for name " + name, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(name, HttpStatus.OK);
	}

	
	@PutMapping("/users/{name}")
	public ResponseEntity updateUser(@PathVariable String name, @RequestBody User user) {
		user = userDAO.update(name, user);
		if (null == user) {
			return new ResponseEntity("No User found for name " + name, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	
}