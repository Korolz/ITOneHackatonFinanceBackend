package me.korolz.itonerestapifinance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_password")
    public String userPassword;

    @Column(name = "user_role")
    public String userRole;

    @OneToMany
    @JsonIgnore
    public List<Income> incomes;

    @OneToMany
    @JsonIgnore
    public List<Outcome> outcomes;

    public Person(int userId, String userName, String userPassword, String userRole) {
        this.userId = userId;
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
