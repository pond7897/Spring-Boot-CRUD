package com.ngopitit.crudapp.repository;

import com.ngopitit.crudapp.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);

    void delete(Integer id);

    Person get(Integer id);

    List<Person> getAll();

    void update(Person person);
}
