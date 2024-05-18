package me.korolz.itonerestapifinance.services;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Outcome;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.repositories.IncomeRepository;
import me.korolz.itonerestapifinance.repositories.OutcomeRepository;
import me.korolz.itonerestapifinance.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OutcomeService {

    private final OutcomeRepository outcomeRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public OutcomeService(OutcomeRepository outcomeRepository, PeopleRepository peopleRepository) {
        this.outcomeRepository = outcomeRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Outcome> findOutcomesByUserId(int userId) {
        Person person = peopleRepository.findByUserId(userId);
        return outcomeRepository.findOutcomesByPerson(person);
    }

    public double calculateTotalOutcomes(int userId){
        List<Outcome> outcomes = findOutcomesByUserId(userId);
        double total = 0;
        for(Outcome outcome : outcomes) {
            total+=outcome.getAmount();
        }
        return total;
    }
}

