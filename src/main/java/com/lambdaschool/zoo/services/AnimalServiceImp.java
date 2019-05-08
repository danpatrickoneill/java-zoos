package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.repos.AnimalRepo;
import com.lambdaschool.zoo.views.CountAnimalsInZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImp implements AnimalService
{
    @Autowired
    private AnimalRepo animalrepo;

    @Override
    public ArrayList<Animal> findAll()
    {
        ArrayList<Animal> list = new ArrayList<>();
        animalrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Animal findAnimalByType(String type)
    {
        return animalrepo.findAnimalByAnimaltypeContains(type);
    }

    @Override
    public ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos()
    {
        return animalrepo.getCountAnimalsInZoos();
    }
}
