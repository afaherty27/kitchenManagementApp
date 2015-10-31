package com.kitchenApp.com.kitchenApp.database;


import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Implements UserDoa Interface
 * @author afaherty
 */

public class UserDoaImp implements UserDoa {

    private final Logger logger = Logger.getLogger(UserDoaImp.class);

    public void addUser(User user) {

        // refer to a DB connection
        //PreparedStatement object refering to sql statements
        logger.info("in addUser method");
    }

    public User getUser(int userId) {
        logger.info("in getUser method");
        return null; //TEST STUB
    }

    public List<User> getAllUsers() {

        logger.info("in getAllUsers method");
        return null; //TEST STUB
    }

    public void updateUser(User user) {

        logger.info("in updateUser method");
    }

    public void deleteUser(User user) {

        logger.info("in deleteUser method");
    }
    /*List<User> getAllUsers();
    User getUser(int userId);
    void updateUser(User user);
    void deleteUser(User user);*/

}
