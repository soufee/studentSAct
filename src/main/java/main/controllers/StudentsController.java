package main.controllers;

import main.model.entity.Student;
import main.services.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@Controller
public class StudentsController {

    private static final Logger logger = Logger.getLogger(StudentsController.class);

    private StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showStudentsList(Model model) throws IOException {

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        return "listStudents";
    }

    @RequestMapping(value = "/list/edit")
    public ModelAndView editStudent(@RequestParam(value = "id") long studentId) {
        ModelAndView mnv = new ModelAndView();
        Student student = studentService.getById(studentId);
        mnv.addObject("student", student);
        mnv.setViewName("addStudent");
        return mnv;
    }

    @RequestMapping(value = "/list/delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam(value = "id") long studentId) {

        studentService.deleteStudent(studentId);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list/add", method = RequestMethod.GET)
    public String addStudent() {
        return  "addStudent";
    }

    @RequestMapping(value = "/list/update", method = RequestMethod.POST)
    public String saveStudent(@RequestParam(value = "id", required = false) Long id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("groupId") long groupId) {


        logger.debug("student id: " + id);

        Student student;
        if (id != null && id > 0) {
            student = studentService.getById(id);
        } else {
            student = new Student();
        }

        student.setName(name);
        student.setAge(age);


        long studentId;
        if (id != null && id > 0) {
            studentService.updateStudent(student);
        } else {
            studentService.saveStudent(student);
        }

        return  "redirect:/list";

    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
