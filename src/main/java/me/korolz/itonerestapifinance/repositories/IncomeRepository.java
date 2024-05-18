package me.korolz.itonerestapifinance.repositories;

import me.korolz.itonerestapifinance.models.Income;
import me.korolz.itonerestapifinance.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    List<Income> findIncomesByPerson(Person person);
}
