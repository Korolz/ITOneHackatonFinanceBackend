package me.korolz.itonerestapifinance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "income")
@Getter
@Setter
public class Income {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "amount")
    public double amount;
    @Column(name = "user_bank_name")
    public String userBankName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    public Person person;

    public Income() {}

    public Income(double amount, String userBankName) {
        this.amount = amount;
        this.userBankName = userBankName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amount: " + amount + "\n");
        sb.append("User Bank Name: " + userBankName + "\n");
        return sb.toString();
    }
}
