package main.services;

import java.util.List;

import main.model.dto.StudentDTO;


/**
 *
 */
public interface StudentService {

   List<StudentDTO> getAllStudents();

   long saveStudent(StudentDTO student);

   void updateStudent(StudentDTO student);

   void deleteStudent(long id);

   StudentDTO getById(long studentId);

}
