package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repos.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "animalService")
public class AnimalServiceImp implements AnimalService
{
    @Autowired
    private AnimalRepo animalrepo;


}
