package main.model.dao;


import main.model.entity.Student;

/**
 *
 */
public interface StudentDAO extends DAO<Long, Student> {


    String getStudentLogin(Student student);
}
