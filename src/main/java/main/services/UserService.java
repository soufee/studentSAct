package main.services;


import main.model.entity.User;

/**
 *
 */
@Deprecated
public interface UserService {

    User auth(String login, String password);
}
