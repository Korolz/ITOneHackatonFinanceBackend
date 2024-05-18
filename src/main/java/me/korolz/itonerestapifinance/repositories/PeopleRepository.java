package me.korolz.itonerestapifinance.repositories;

import me.korolz.itonerestapifinance.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>
{
    Person findByUserId(int id);
    Person findByUserName(String username);
}

