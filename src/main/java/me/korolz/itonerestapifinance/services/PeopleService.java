package me.korolz.itonerestapifinance.services;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository)
    {
        this.peopleRepository = peopleRepository;
    }

    public Person findByUserName(String username){
        return peopleRepository.findByUserName(username);
    }

    public Person findByUserId(int userId){
        return peopleRepository.findByUserId(userId);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setUserId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
