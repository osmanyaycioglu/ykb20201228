package com.training.ykb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.rest.Person;
import com.training.ykb.services.dao.IPersonDao;

@Service
public class PersonManager {

    @Autowired
    private IPersonDao pDao;

    public String addOrUpdate(final Person person) {
        this.pDao.save(person);
        return "OK";
    }

    public String remove(final Long personId) {
        this.pDao.deleteById(personId);
        return "OK";
    }

    public Person get(final Long personIdParam) {
        return this.pDao.findById(personIdParam)
                        .orElse(null);
    }

    public List<Person> getAll() {
        Iterable<Person> findAllLoc = this.pDao.findAll();
        List<Person> perList = new ArrayList<>();
        for (Person personLoc : findAllLoc) {
            perList.add(personLoc);
        }
        return perList;
    }

    public List<Person> searchByName(final String name) {
        return this.pDao.findByName(name);
    }

}
