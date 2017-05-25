package main.services;

import java.io.IOException;
import java.util.List;

import main.model.dto.StudentDTO;
import main.model.entity.Student;


/**
 *
 */
public interface StudentService {

   List<Student> getAllStudents() throws IOException;

   void saveStudent(Student student);

   void updateStudent(Student student);

   void deleteStudent(long id);

   Student getById(long studentId);

}
