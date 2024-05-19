package me.korolz.itonerestapifinance.servicesTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IncomeServiceTest {

    @Mock
    private IncomeRepository incomeRepository;
    @Mock
    private PeopleRepository peopleRepository;

    @InjectMocks
    private IncomeService incomeService;

    //Проверяется правильный вывод всех доходов пользователя
    @Test
    public void FindIncomesByUserIdTest() {
        int userId = 1;
        String password = "password";
        Person mockUser = new Person(userId, "Test User1", password, "user");
        when(peopleRepository.findByUserId(userId)).thenReturn(Optional.of(mockUser).orElse(null));

        List<Income> result = incomeRepository.findIncomesByPerson(mockUser);

        assertNotNull(result);
        assertEquals(); //TODO
    }
}
