package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    public ResponseEntity<?> getZooByName(@PathVariable String name) throws EntityNotFoundException
    {
        Zoo zoo = zooService.findZooByName(name);

        if (zoo == null) {
            throw new EntityNotFoundException("Couldn't find zoo with name: " + name);
        }

        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }
}
