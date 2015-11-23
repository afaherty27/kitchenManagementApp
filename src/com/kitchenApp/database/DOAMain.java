package com.kitchenApp.database;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.entity.User;

/**
 * @author afaherty
 * 11/2/2015
 */

public class DOAMain {

    /**
     * main processing method of this test
     * @param args
     */
    public static void main(String[] args) {

        UserDao dao = new UserDao();
        User user = new User(0, "gfaherty", "gpassword", "123 Some St.", "1234567890", "gfaherty@domain.com", "1234567890");
        dao.addUser(user);
    }
}
