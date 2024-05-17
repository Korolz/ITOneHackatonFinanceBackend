package me.korolz.itonerestapifinance.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class Person {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    @Column(name = "userName")
    public String userName;
    @Column(name = "userPassword")
    public String userPassword;

    @OneToMany
    public List<Income> incomes;
    @OneToMany
    public List<Outcome> outcomes;
}
