//package me.korolz.itonerestapifinance.servicesTest;
//import me.korolz.itonerestapifinance.models.Income;
//import me.korolz.itonerestapifinance.models.Person;
//import me.korolz.itonerestapifinance.repositories.IncomeRepository;
//import me.korolz.itonerestapifinance.repositories.PeopleRepository;
//import me.korolz.itonerestapifinance.services.IncomeService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class IncomeServiceTest {
//
//    @Mock
//    private IncomeRepository incomeRepository;
//    @Mock
//    private PeopleRepository peopleRepository;
//
//    @InjectMocks
//    private IncomeService incomeService;
//
//    //Проверяется правильный вывод всех доходов пользователя
//    @Test
//    public void FindIncomesByUserIdTest() {
//        int userId = 1;
//        String password = "password";
//        Person mockUser = new Person(userId, "Test User1", password, "user");
//        when(peopleRepository.findByUserId(userId)).thenReturn(Optional.of(mockUser).orElse(null));
//
//        List<Income> result = incomeRepository.findIncomesByPerson(mockUser);
//
//        assertNotNull(result);
//        assertEquals(); //TODO
//    }
//
//    //Тест проверяет подсчет общего дохода
//    @Test
//    public void calculateTotalIncomesTest() {    List<Income> incomes = new ArrayList<>(Arrays.asList(new Income(50, "Сбербанк"),
//            new Income(100, "Сбербанк")));
//        int result = 150;
//        int userId = 1;    when(incomeService.findIncomesByUserId(userId)).thenReturn(incomes);
//        assertEquals(result, incomeService.calculateTotalIncomes(userId));}
//}
