package main.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import main.model.dao.StudentDAO;
import main.model.entity.Student;

import javax.persistence.*;


/**
 *
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;
    private EntityManagerFactory emf =
            Persistence.
                    createEntityManagerFactory("mnf-pu");

    @PersistenceContext
    @Qualifier("entityManagerFactory")
    private EntityManager manager;

    @Override
    public Collection<Student> getAll() {

        return emf.createEntityManager().
                createQuery("from Student").getResultList();


//        Session session = sessionFactory.openSession();
//
//        List<Student> students = session.createQuery("from Student", Student.class).list();
//
//        session.close();
//        return students;
    }


    @Override
    public Student getById(Long id) {

//        Session session = sessionFactory.openSession();
//        return session.load(Student.class, id);
        return null;
    }

    @Override
    public Long insert(Student entity) {

        manager.persist(entity);

//        Session session = sessionFactory.openSession();
//        session.save(entity);
//
//        session.close();

        return entity.getId();
    }

    @Override
    public void update(Student entity) {
    }

    @Override
    public void delete(Student entity) {
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
