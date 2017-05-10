package main.model.dao;


import main.model.entity.User;

/**
 *
 */
public interface UserDAO extends DAO<Long, User> {

    User findUserByLoginAndPassword(String login, String password);
}
