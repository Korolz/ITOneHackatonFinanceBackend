package me.korolz.itonerestapifinance.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Outcome")
@Getter
@Setter
public class Outcome {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "amount")
    public double amount;
    @Column(name = "mcc")
    public int mcc;
    @Column(name = "userBankName")
    public String userBankName;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public Person person;

    public Outcome() {}

    public Outcome(double amount, int mcc, String userBankName) {
        this.amount = amount;
        this.mcc = mcc;
        this.userBankName = userBankName;
    }
}
