package main.model.dao.impl;

import main.model.dao.mappers.StudentMapper;
import main.model.dao.StudentRepo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import main.model.dao.StudentDAO;
import main.model.entity.Student;

import javax.persistence.*;


/**
 *
 */
@Repository
public class StudentDAOImpl implements StudentDAO {
@Autowired
    private StudentRepo studentRepo;
    private SessionFactory sessionFactory;
    @Autowired
    private EntityManagerFactory emf =
            Persistence.
                    createEntityManagerFactory("mnf-pu");
    @Autowired
    private StudentMapper studentMapper;


    @PersistenceContext
    @Qualifier("entityManagerFactory")
    private EntityManager manager;

    @Override
    public Collection<Student> getAll() throws IOException {
//List<Student> students = (List<Student>) studentRepo.findAll();
//       return students;
//        try {
//        Reader reader = Resources.getResourceAsReader("mybatis.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
//        StudentMapper mapper = factory.openSession().getMapper(StudentMapper.class);
//        return mapper.getAllStudents();}
//        catch (IOException e){e.printStackTrace();}
//        return null;
        return studentMapper.getAllStudents();
    }


    @Override
    public Student getById(Long id) {
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
//            StudentMapper mapper = factory.openSession().getMapper(StudentMapper.class);
//            return mapper.getStudentById(Integer.parseInt(id.toString()));}
//        catch (IOException e){e.printStackTrace();}
        return studentMapper.getStudentById(Integer.parseInt(id.toString()));

//        return studentRepo.findById(id);
    }

    @Override
    public void insert(Student entity) {
studentMapper.insertStudent(entity);
//studentRepo.save(entity);
    }

    @Override
    public void update(Student entity) {
        studentMapper.updateStudent(entity);
//        studentRepo.save(entity);
    }

    @Override
    public void delete(Student entity) {
        studentMapper.deleteStudent(Integer.parseInt(String.valueOf(entity.getId())));
       // studentRepo.delete(entity);

    }


    @Override
    public String getStudentLogin(Student student) {
        String login = null;

        return login;
    }

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
