package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repos.TelephoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telephoneService")
public class TelephoneServiceImp implements TelephoneService
{
    @Autowired
    private TelephoneRepo telephonerepo;
}
