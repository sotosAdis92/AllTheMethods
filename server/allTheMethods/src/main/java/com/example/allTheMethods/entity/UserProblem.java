package com.example.allTheMethods.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_problem")
public class UserProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "problemId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Problem problem;


    public UserProblem() {
    }

    public UserProblem(Long id, Users user, Problem problem) {
        this.id = id;
        this.user = user;
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
