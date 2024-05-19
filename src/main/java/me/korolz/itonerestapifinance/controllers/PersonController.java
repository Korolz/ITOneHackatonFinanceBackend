package me.korolz.itonerestapifinance.controllers;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Outcome;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.services.IncomeService;
import me.korolz.itonerestapifinance.services.OutcomeService;
import me.korolz.itonerestapifinance.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PeopleService peopleService;
    private final IncomeService incomeService;
    private final OutcomeService outcomeService;

    @Autowired
    public PersonController(PeopleService peopleService, IncomeService incomeService, OutcomeService outcomeService) {
        this.peopleService = peopleService;
        this.incomeService = incomeService;
        this.outcomeService = outcomeService;
    }

    @GetMapping("/{id}/incomes")
    public List<Income> getPersonIncomes(@PathVariable("id") int userId) {
        List<Income> incomes = incomeService.findIncomesByUserId(userId);
        System.out.println(incomes.toString());
        return incomes;
    }

    @GetMapping("/{id}/outcomes")
    public List<Outcome> getPersonOutcomes(@PathVariable("id") int userId) {
        List<Outcome> outcomes = outcomeService.findOutcomesByUserId(userId);
        System.out.println(outcomes.toString());
        return outcomes;
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        Person person = peopleService.findByUserId(id);
        System.out.println(person.toString());
        return person;
    }

    @GetMapping("/{id}/delta")
    public double getPersonDelta(@PathVariable("id") int id) {
        double incomes = incomeService.calculateTotalIncomes(id);
        double outcomes = outcomeService.calculateTotalOutcomes(id);
        return incomes - outcomes;
    }

    @PostMapping("/create")
    public boolean createPerson(@RequestBody Person person) {
        try{
            peopleService.addUser(person);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
