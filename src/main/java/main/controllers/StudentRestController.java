package main.controllers;

import main.model.entity.Student;
import main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 25.05.2017.
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {
 private StudentService studentService;
@Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public List<Student> getAllStudents() throws IOException {
        return studentService.getAllStudents();
    }
}
