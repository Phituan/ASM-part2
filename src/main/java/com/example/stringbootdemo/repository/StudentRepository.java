package com.example.stringbootdemo.repository;

import com.example.stringbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findFirstByEmail(String email);
}
