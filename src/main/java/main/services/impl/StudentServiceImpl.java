package main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

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
    public List<StudentDTO> getAllStudents() {

        List<Student> students = (List<Student>) studentDAO.getAll();
        students.sort(Comparator.comparingLong(Student::getId));

        List<StudentDTO> studentDTOs = new ArrayList<>();

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BoundMapperFacade<Student, StudentDTO>
                boundMapper = mapperFactory.getMapperFacade(Student.class, StudentDTO.class);

        students.forEach(student -> {
            studentDTOs.add(boundMapper.map(student));
        });

        return studentDTOs;
    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public long saveStudent(StudentDTO student) {
        //return studentDAO.insert(student);
        return 0;
    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public void updateStudent(StudentDTO student) {
        //studentDAO.update(student);
    }

    @Override
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public void deleteStudent(long id) {
     /*   Student student = new Student();
        student.setId(id);
        studentDAO.delete(student);
        */
    }

    @Override
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public StudentDTO getById(long studentId) {
       // return studentDAO.getById(studentId);
        return null;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
