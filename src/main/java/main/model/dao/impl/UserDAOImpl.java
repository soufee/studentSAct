package main.model.dao.impl;

import org.springframework.stereotype.Repository;

import java.util.Collection;

import main.model.dao.UserDAO;
import main.model.entity.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public Long insert(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void update(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        throw new NotImplementedException();
    }
}
