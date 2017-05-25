package main.services.impl;

import main.model.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import main.model.dao.StudentDAO;
import main.model.dto.StudentDTO;
import main.model.entity.Student;
import main.services.StudentService;

/**
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Student> getAllStudents() throws IOException {

        List<Student> students = (List<Student>) studentDAO.getAll();
//        students.sort(Comparator.comparingLong(Student::getId));
//
//        List<Student> studentDTOs = new ArrayList<>();
//
//        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//
//        BoundMapperFacade<Student, Student>
//                boundMapper = mapperFactory.getMapperFacade(Student.class, Student.class);
//
//        students.forEach(student -> {
//            studentDTOs.add(boundMapper.map(student));
//        });

        return students;
    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public void saveStudent(Student student) {
    studentDAO.insert(student);

    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public void updateStudent(Student student) {
       studentDAO.update(student);
    }

    @Override
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public void deleteStudent(long id) {
      Student student =   studentDAO.getById(id);
studentDAO.delete(student);
    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Student getById(long studentId) {
        Student student =   studentDAO.getById(studentId);
        return student;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
