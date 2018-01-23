package com.jammify.userjammify.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIl")
    private String email;

    public Person(){};

    private Person(PersonBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email);
    }

    public static class PersonBuilder{

        private Long id;

        private String name;

        private String email;

        public PersonBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
