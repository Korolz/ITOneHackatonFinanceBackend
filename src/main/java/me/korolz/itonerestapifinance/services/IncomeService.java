package me.korolz.itonerestapifinance.services;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.repositories.IncomeRepository;
import me.korolz.itonerestapifinance.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository, PeopleRepository peopleRepository) {
        this.incomeRepository = incomeRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Income> findIncomesByUserId(int userId) {
        Person person = peopleRepository.findByUserId(userId);
        return incomeRepository.findIncomesByPerson(person);
    }
}
