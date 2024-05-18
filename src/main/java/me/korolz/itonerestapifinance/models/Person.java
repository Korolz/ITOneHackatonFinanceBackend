package me.korolz.itonerestapifinance.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;

    @Column(name = "userName")
    public String userName;

    @Column(name = "userPassword")
    public String userPassword;

    @Column(name = "userRole")
    public String userRole;

    @OneToMany
    public List<Income> incomes;

    @OneToMany
    public List<Outcome> outcomes;

    public Person(String userName, String userPassword, String userRole) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public Person() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("userId: " + userId + "\n");
        sb.append("userName: " + userName + "\n");
        sb.append("userRole: " + userRole + "\n");
        return sb.toString();
    }
}
