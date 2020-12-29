package com.training.ykb.services.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.ykb.rest.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameOrderByNameAsc(String name);

    List<Person> findByNameIn(List<String> names);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    @Query("select p from Person p where p.name = :xyz")
    List<Person> searchName(@Param("xyz") String name);

    @Query(value = "select * from kisi p where p.name = :xyz", nativeQuery = true)
    List<Person> searchNativeName(@Param("xyz") String name);

}
