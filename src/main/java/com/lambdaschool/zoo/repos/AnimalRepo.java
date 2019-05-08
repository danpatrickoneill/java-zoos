package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.CountAnimalsInZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepo extends CrudRepository<Animal, Long>
{
    Animal findAnimalByAnimaltypeContains(String type);

    @Query(value = "SELECT a.animalid, count(animalid) as countanimals\n" +
            "FROM zooanimals a\n" +
            "INNER JOIN zoo z on a.zooid=z.zooid\n" +
            "GROUP BY animalid\n", nativeQuery = true)
    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();
}
