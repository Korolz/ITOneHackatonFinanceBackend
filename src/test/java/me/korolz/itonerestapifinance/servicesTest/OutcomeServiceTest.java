//package me.korolz.itonerestapifinance.servicesTest;
//import me.korolz.itonerestapifinance.models.Income;
//import me.korolz.itonerestapifinance.models.Outcome;
//import me.korolz.itonerestapifinance.models.Person;
//import me.korolz.itonerestapifinance.repositories.OutcomeRepository;
//import me.korolz.itonerestapifinance.repositories.PeopleRepository;
//import me.korolz.itonerestapifinance.services.OutcomeService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class OutcomeServiceTest {
//
//    @Mock
//    private OutcomeRepository outcomeRepository;
//    @Mock
//    private PeopleRepository peopleRepository;
//
//    @InjectMocks
//    private OutcomeService outcomeService;
//
//    //Проверяется правильный вывод всех расходов пользователя
//    @Test
//    public void FindOutcomesByUserIdTest() {
//        int userId = 1;
//        String password = "password";
//        Person mockUser = new Person(userId, "Test User1", password, "user");
//        when(peopleRepository.findByUserId(userId)).thenReturn(Optional.of(mockUser).orElse(null));
//
//        List<Outcome> result = outcomeRepository.findOutcomesByPerson(mockUser);
//
//        assertNotNull(result);
//        assertEquals(); //TODO
//    }
//}