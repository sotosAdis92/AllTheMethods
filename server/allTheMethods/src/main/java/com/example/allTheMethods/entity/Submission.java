package com.example.allTheMethods.entity;

import com.example.allTheMethods.dto.SubmissionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

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

    public Submission() {
    }

    public Submission(Long id, String date, String valid, Users user, Problem problem) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public SubmissionDto getSubmissionDto(){
        SubmissionDto submissionDto = new SubmissionDto();
        submissionDto.setSubmissionId(id);
        submissionDto.setUserId(user.getId());
        submissionDto.setProblemId(problem.getId());
        submissionDto.setSubmittedAt(date);
        return submissionDto;
    }
}
