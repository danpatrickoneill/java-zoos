package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany(mappedBy = "zoos")
    @JsonIgnoreProperties("zoos")
    private List<Animal> animals = new ArrayList<>();

    public Zoo()
    {
    }

    public Zoo(String zooname, List<Telephone> telephones, List<Animal> animals)
    {
        this.zooname = zooname;
        this.telephones = telephones;
        this.animals = animals;
    }

    public Zoo(Zoo zoo)
    {
        this.zooname = zoo.getZooname();
        this.telephones = zoo.getTelephones();
        this.animals = zoo.getAnimals();
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }
}
