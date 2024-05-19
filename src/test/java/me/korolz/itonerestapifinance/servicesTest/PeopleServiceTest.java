//package me.korolz.itonerestapifinance.servicesTest;
//import me.korolz.itonerestapifinance.models.Person;
//import me.korolz.itonerestapifinance.repositories.PeopleRepository;
//import me.korolz.itonerestapifinance.services.PeopleService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class PeopleServiceTest {
//
//    @Mock
//    private PeopleRepository userRepository;
//
//    @InjectMocks
//    private PeopleService userService;
//
//    @Test
//    public void whenFindByUserId_thenUserReturned() {
//        int userId = 1;
//        String password = "password";
//        Person mockUser = new Person(userId, "Test User", password, "user");
//        when(userRepository.findByUserId(userId)).thenReturn(Optional.of(mockUser).orElse(null));
//
//        Person result = userService.findByUserId(userId);
//
//        assertNotNull(result);
//        assertEquals(mockUser, result);
//    }
//
//    @Test
//    public void whenFindByUserName_thenUserReturned() {
//        int userId = 2;
//        String name = "Test User";
//        String password = "password2";
//        Person mockUser = new Person(userId, name, password, "user");
//        when(userRepository.findByUserName(name)).thenReturn(Optional.of(mockUser).orElse(null));
//
//        Person result = userService.findByUserName(name);
//
//        assertNotNull(result);
//        assertEquals(mockUser, result);
//    }
//}