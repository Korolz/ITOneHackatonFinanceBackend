package me.korolz.itonerestapifinance.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Income")
public class Income {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "userId")
    public int userId;
    @Column(name = "amount")
    public double amount;
    @Column(name = "userBankName")
    public String userBankName;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public Person person;
}
