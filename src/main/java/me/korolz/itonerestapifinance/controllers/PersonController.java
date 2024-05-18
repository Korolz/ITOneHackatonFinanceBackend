package me.korolz.itonerestapifinance.controllers;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.services.IncomeService;
import me.korolz.itonerestapifinance.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PeopleService peopleService;
    private final IncomeService incomeService;

    @Autowired
    public PersonController(PeopleService peopleService, IncomeService incomeService) {
        this.peopleService = peopleService;
        this.incomeService = incomeService;
    }

    @GetMapping("/{id}/incomes")
    public List<Income> getPersonIncomes(@PathVariable("id") int userId) {
        List<Income> incomes = incomeService.findIncomesByUserId(userId);
        System.out.println(incomes.toString());
        return incomes;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        Person person = peopleService.findByUserId(id);
        System.out.println(person.toString());
        return person;
    }

    @PostMapping("/create/{name}/{password}/{role}")
    public void setPerson(@PathVariable("name") String name, @PathVariable("password") String password, @PathVariable("role") String role) {
        Person person = new Person(name, password, role);
        peopleService.save(person);
        System.out.println("Person created: " + person.toString());
    }
}
