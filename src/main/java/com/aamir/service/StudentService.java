package com.aamir.service;

import com.aamir.entity.Student;
import com.aamir.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {

        if (StringUtils.hasLength(student.getEmailOrPhoneNo()) && student.getEmailOrPhoneNo().contains("@")) {

            studentRepository.save(student);

        } else if (StringUtils.hasLength(student.getEmailOrPhoneNo()) && !student.getEmailOrPhoneNo().contains("@")) {

            studentRepository.save(student);

        }


        return null;
    }
}
