package com.example.stringbootdemo.service;

import com.example.stringbootdemo.entity.Student;


public interface StudentService {

    Student getDetail(int studentId);
    Student findByEmail(String email);
    Student register(Student student);

}
