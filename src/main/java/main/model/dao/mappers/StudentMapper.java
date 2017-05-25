package main.model.dao.mappers;

import main.model.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 17.05.2017.
 */
@Component
public interface StudentMapper {
    List getAllStudents();
    Student getStudentById(int id);
    void deleteStudent(int id);
    void insertStudent(Student student);
    void updateStudent(Student student);
}
