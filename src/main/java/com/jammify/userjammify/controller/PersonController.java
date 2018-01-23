package com.jammify.userjammify.controller;

import com.jammify.userjammify.model.Person;
import com.jammify.userjammify.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Person> createUser(@RequestBody Person person){
        Person newPerson = personService.createPerson(person);
        return new ResponseEntity<Person>(newPerson, HttpStatus.CREATED);
    }

}
