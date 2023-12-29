package com.aamir.controller;

import com.aamir.entity.Student;
import com.aamir.repo.StudentRepository;
import com.aamir.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/form")
    public String openForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        Student savedStudent = studentService.saveStudent(student);
        System.out.println(savedStudent);
        return "form";
    }

    @PostMapping("/getStudent/{id}/{name}")
    @ResponseBody
    public List<Student> getStudent(@PathVariable(value = "id", required = false) Long id,
    		@PathVariable(value = "name", required = false) String name) {
        List<Student> students = new ArrayList<>();
        System.out.println("id is" + id + " and name is" + name);
        if (null != id) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceAccessException("User not found"));
            students.add(student);
            return students;
        }
        List<Student> allStudents = studentRepository.findAll();
        students.addAll(allStudents);
        return students;
    }
}
