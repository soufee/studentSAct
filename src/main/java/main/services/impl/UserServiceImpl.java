package main.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.dao.UserDAO;
import main.model.entity.User;
import main.services.UserService;
import main.util.Profiling;

/**
 *
 */
@Profiling
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);
        logger.debug("user: " + user);

        if (user != null && user.isBlocked()) {
            return null;
        }
        logger.debug("user not blocked");

        return user;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
