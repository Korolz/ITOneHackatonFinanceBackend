package me.korolz.itonerestapifinance.repositories;

import me.korolz.itonerestapifinance.models.Outcome;
import me.korolz.itonerestapifinance.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
    List<Outcome> findOutcomesByPerson(Person person);
}
