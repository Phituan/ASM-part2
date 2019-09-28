package com.example.stringbootdemo.service;

import com.example.stringbootdemo.entity.Student;
import com.example.stringbootdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement  implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student getDetail(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public Student findByEmail(String email) {
        return studentRepository.findFirstByEmail(email).orElse(null);
    }

    @Override
    public Student register(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }


}
