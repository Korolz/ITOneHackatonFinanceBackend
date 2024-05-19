package me.korolz.itonerestapifinance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int userId;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_password")
    public String userPassword;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "users", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    public Set<Role> userRole;

    @OneToMany
    @JsonIgnore
    public List<Income> incomes;

    @OneToMany
    @JsonIgnore
    public List<Outcome> outcomes;

    public Person(int userId, String userName, String userPassword, Set<Role> userRole) {
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
