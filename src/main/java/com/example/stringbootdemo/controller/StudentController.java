package com.example.stringbootdemo.controller;

import com.example.stringbootdemo.entity.Student;
import com.example.stringbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage(Model model) {
        model.addAttribute("student", new Student());
        return "student/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String createAccount(Model model) {
        model.addAttribute("student", new Student());
        return "student/register";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDetail(@PathVariable int studentId, Model model) {
        model.addAttribute("student", studentService.getDetail(studentId));
        return "student/detail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String storeStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/register";
        }
        studentService.register(student);
        return "redirect:/student/login";
    }
}
