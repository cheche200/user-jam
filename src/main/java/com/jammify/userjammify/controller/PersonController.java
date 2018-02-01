package com.jammify.userjammify.controller;

import com.jammify.userjammify.model.Person;
import com.jammify.userjammify.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Person createUser(@RequestBody Person person){
        Person newPerson = personService.createPerson(person);
        return newPerson;
    }

}
