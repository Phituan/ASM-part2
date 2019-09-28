package com.example.stringbootdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
public class AptechClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Không được bỏ trống trường này")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "aptech_class_student", joinColumns = @JoinColumn(name = "aptech_class_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> studentSet;
    private int status;


    public AptechClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AptechClass(int id, String name, Set<Student> studentSet, int status) {
        this.id = id;
        this.name = name;
        this.studentSet = studentSet;
        this.status = status;
    }
}
