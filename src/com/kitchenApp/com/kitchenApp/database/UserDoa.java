package com.kitchenApp.com.kitchenApp.database;


import java.util.List;

/**
 * DOA interface for User objects
 *
 * @author afaherty
 * 10/30/2015
 */

public interface UserDoa {

    List<User> getAllUsers();
    User getUser(int userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
