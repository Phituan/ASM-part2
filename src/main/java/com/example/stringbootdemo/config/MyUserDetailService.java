package com.example.stringbootdemo.config;

import com.example.stringbootdemo.entity.Student;
import com.example.stringbootdemo.repository.StudentRepository;
import com.example.stringbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyUserDetailService implements UserDetailsService {
    private static Logger LOGGER = Logger.getLogger(MyUserDetailService.class.getSimpleName());

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.log(Level.INFO, String.format("Try to login with username: %s", email));
        Student student = studentService.findByEmail(email);
        if (student != null) {

            UserDetails userDetails = User.builder()
                    .username(student.getEmail())
                    .password(student.getPassword())
                    .roles("USER")
                    .build();

            return userDetails;
        } else {
            System.out.println("login failure");
            throw new UsernameNotFoundException("User not found");
        }
    }
}
