package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepo extends CrudRepository<Zoo, Long>
{
    Zoo findZooByZoonameContains(String name);
}
