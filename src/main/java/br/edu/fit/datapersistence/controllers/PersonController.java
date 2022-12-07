package br.edu.fit.datapersistence.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fit.datapersistence.models.Person;
import br.edu.fit.datapersistence.repositories.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @GetMapping("/")
    public List<Person> all() {
        return repository.findAll();
    }

    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        person.setId(UUID.randomUUID());
        repository.save(person);

        return person;
    }
}
