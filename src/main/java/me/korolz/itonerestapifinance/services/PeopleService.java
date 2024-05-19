package me.korolz.itonerestapifinance.services;

import me.korolz.itonerestapifinance.models.Person;
import me.korolz.itonerestapifinance.models.Role;
import me.korolz.itonerestapifinance.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class PeopleService implements UserDetailsService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder=passwordEncoder;
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Person myUser = peopleRepository.findByUserName(username);
        return new User(myUser.getUserName(),
                myUser.getUserPassword(), mapRolesToAthorities(myUser.getUserRole()));
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles)
    {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" +
                r.name())).collect(Collectors.toList());
    }

    public void addUser(Person user) throws Exception
    {
//        Person userFromDb = peopleRepository.findByUserName(user.getUserName());
//        if (userFromDb != null)
//        {
//            throw new Exception("user exists");
//        }
//        user.setUserRole(Collections.singleton(Role.SINGLE_USER));
//        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
//        System.out.println(user);
        peopleRepository.save(user);
    }

    public Person findByUserName(String username){
        return peopleRepository.findByUserName(username);
    }

    public Person findByUserId(int userId){
        return peopleRepository.findByUserId(userId);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setUserId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(Person user) throws Exception {
        Person userFromDb = peopleRepository.findByUserName(user.getUserName());
        if (userFromDb == null) {
            throw new Exception("user doesn't exist");
        }
        peopleRepository.delete(user);
    }
}
