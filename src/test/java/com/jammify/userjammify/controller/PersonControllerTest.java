package com.jammify.userjammify.controller;

import com.jammify.userjammify.model.Person;
import com.jammify.userjammify.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonControllerTest {

    @Mock
    PersonService personService;

    @Autowired
    PersonController personController;


    @Test
    public void shouldCreatePerson(){
        Person expected = new Person.PersonBuilder().setId(1L).setName("Pepe").setEmail("pepe@somehost.com").build();

        when(personService.createPerson(expected)).thenReturn(expected);

        ResponseEntity<Person> actual =  personController.createUser(expected);

        assertEquals(expected, actual.getBody());
    }

}
