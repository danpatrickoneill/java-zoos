package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();

    Zoo findZooByName(String name);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long id);
}
