package me.korolz.itonerestapifinance.controllersTest;

import me.korolz.itonerestapifinance.controllers.PersonController;
import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.services.IncomeService;
import me.korolz.itonerestapifinance.services.OutcomeService;
import me.korolz.itonerestapifinance.services.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonControllerTest {

    //Заглушки сервисов
    @Mock
    private final PeopleService peopleService;
    @Mock
    private final IncomeService incomeService;
    @Mock
    private final OutcomeService outcomeService;

    private MockMvc mvc;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    //Тест проверяет корректность вывода доходов. Проверяется, что метод вызывается 1 раз.
    @Test
    public void getPersonIncomesTest() {
        int id = 3;
        Person user = new Person(id, "qwertyf", "123", "user");
        when(incomeService.findIncomesByUserId(id)).thenReturn(user);
        mvc.perform(get("/person/{id}/incomes", id)).andExpect(""); //дописать ответ //TODO

        verify(incomeService, times(1)).getPersonIncomes(user.getUserId());
    }

    //Проверяется, что метод возвращает пользователя по id
    @Test
    public void getPersonTest() {
        int id = 4;
        Person user = new Person(id, "qwerty", "123", "user");
        when(peopleService.findByUserId(id)).thenReturn(user);
        mvc.perform(get("/person/{id}", id)).andExpect(""); //дописать ответ   //TODO
    }

    //Тест проверяет корректность вывода расходов. Проверяется, что метод вызывается 1 раз.
    @Test
    public void getPersonOutcomesTest() {
        int id = 5;
        Person user = new Person(id, "qwe", "12345", "user");
        when(outcomeService.findOutcomesByUserId(id)).thenReturn(user);
        mvc.perform(get("/person/{id}/outcomes", id)).andExpect(""); //дописать ответ //TODO

        verify(incomeService, times(1)).getPersonIncomes(user.getUserId());
    }

    //Тест проверяет корректность вывода разницы между доходами и расходами, Проверяется. что метод вызывается 1 раз.
    @Test
    public void getPersonDeltaTest() {
        int id = 6;
        Person user = new Person(id, "ksu", "ksu", "user");
        when(incomeService.findOutcomesByUserId(id)).thenReturn(user);
        mvc.perform(get("/person/{id}/outcomes", id)).andExpect(""); //дописать ответ //TODO

        verify(incomeService, times(1)).getPersonIncomes(user.getUserId());
    }

}
