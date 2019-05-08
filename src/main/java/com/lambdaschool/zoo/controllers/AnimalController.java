package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/animals", produces = "application/json")
    ResponseEntity<?> getAllAnimals()
    {
        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    ResponseEntity<?> getAnimalByType(@PathVariable String name) throws EntityNotFoundException
    {
        Animal animal = animalService.findAnimalByType(name);

        if (animal == null) {
            throw new EntityNotFoundException("Couldn't find animal of type: " + name);
        }

        return new ResponseEntity(animal, HttpStatus.OK);
    }

    @GetMapping(value = "/count", produces = "application/json")
    ResponseEntity<?> getCountAnimalsInZoos()
    {
        return new ResponseEntity<>(animalService.getCountAnimalsInZoos(), HttpStatus.OK);
    }
}

