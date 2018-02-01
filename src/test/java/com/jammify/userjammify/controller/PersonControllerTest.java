package com.jammify.userjammify.controller;

import com.jammify.userjammify.model.Person;
import com.jammify.userjammify.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("h2")
public class PersonControllerTest {

    @Mock
    PersonService personService;

    @Autowired
    PersonController personController;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void shouldCreatePerson(){
        Person expected = new Person.PersonBuilder().setId(1L).setName("Pepe")
                .setEmail("user@somehost.com").build();
        HttpEntity<Person> request = new HttpEntity<>(expected);

        when(personService.createPerson(expected)).thenReturn(expected);
        Person actual =  this.restTemplate.postForObject("/user", request, Person.class);

        assertEquals(expected, actual);
    }

}
