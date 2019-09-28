package com.example.stringbootdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @NotNull(message = "Không để trống trường này")
    private String name;
    @Email(message = "Email không đúng định dạng.")
    private String email;
    @NotNull(message = "Không để trống trường này")
    private String password;
    @ManyToMany(mappedBy = "studentSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<AptechClass> aptechClassSet;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AptechClass> getAptechClassSet() {
        return aptechClassSet;
    }

    public void setAptechClassSet(Set<AptechClass> aptechClassSet) {
        this.aptechClassSet = aptechClassSet;
    }

}
