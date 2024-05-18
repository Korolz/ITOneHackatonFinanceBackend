package me.korolz.itonerestapifinance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "outcome")
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
    @Column(name = "user_bank_name")
    public String userBankName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    public Person person;

    public Outcome() {}

    public Outcome(double amount, int mcc, String userBankName) {
        this.amount = amount;
        this.mcc = mcc;
        this.userBankName = userBankName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amount: " + amount + "\n");
        sb.append("MCC: " + mcc + "\n");
        sb.append("User Bank Name: " + userBankName + "\n");
        return sb.toString();
    }
}
