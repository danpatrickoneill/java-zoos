package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private ZooService zooService;

    // @PutMapping(value = "/zoos/{id}", produces = "application/json")
    // public ResponseEntity<?> updateZoo(@PathVariable long id)
    // {
    //     return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    // }

    @PostMapping(value = "/zoos/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addZoo(@Valid
                                    @RequestBody Zoo zoo) throws URISyntaxException
    {
        Zoo newZoo = zooService.save(zoo);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
