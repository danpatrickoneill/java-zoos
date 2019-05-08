package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repos.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImp implements ZooService
{
    @Autowired
    private ZooRepo zoorepo;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Zoo findZooByName(String name)
    {
        return zoorepo.findZooByZoonameContains(name);
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo)
    {
        Zoo newZoo = new Zoo(zoo);

        // ArrayList<Animal> animals = new ArrayList<>();
        // for (Animal a : zoo.getAnimals())
        // {
        //     animals.add(a);
        // }
        // newZoo.setAnimals(animals);
        //
        // ArrayList<Telephone> phones = new ArrayList<>();
        // for (Telephone t : zoo.getTelephones())
        // {
        //     phones.add(t);
        // }
        // newZoo.setTelephones(phones);

        return newZoo;
    }

    @Override
    public Zoo update(Zoo zoo, long id)
    {
        return null;
    }
}
