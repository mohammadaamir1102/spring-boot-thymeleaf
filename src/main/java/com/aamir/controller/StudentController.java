package com.aamir.controller;

import com.aamir.entity.Student;
import com.aamir.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/form")
    public String openForm(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        Student savedStudent = studentService.saveStudent(student);
        System.out.println(savedStudent);
        return "form";
    }
}
