package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepo extends CrudRepository<Telephone, Long>
{
}
