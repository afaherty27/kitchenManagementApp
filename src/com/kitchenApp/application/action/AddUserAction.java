package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Adds user data to the database
 * @author afaherty
 * @version 3.0 on 12/17/2015
 */
public class AddUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * adds user data to kitchenapp database user table
     * @param userName ref to user name received from jsp
     * @param password ref to user password received from jsp
     * @param address ref to user address received from jsp
     * @param phone ref to user phone received from jsp
     * @param email ref to user email received from jsp
     * @param userDao UserDao object
     * @param roleDao UserRoleDao object
     * @return user
     */
    public User addUserData(String userName, String password, String address, String phone,
                           String email, String roleType, UserDao userDao, UserRoleDao roleDao) {

        UserRole role = new UserRole(0, roleType, userName);
        roleDao.addUserRole(role);

        User user = new User(0, userName, password, address, phone, email, role);
        userDao.addUser(user);

        log.info(user.toString());

        emailUser(email, user);

        return user;
    }

    /**
     * Sends new user an email to confirm new user data
     * @param email address email will be sent too
     * @param user User object
     */
    public void emailUser(String email, User user) {
        String subject = "KMA: New User Confirmation";

        EmailUser emailUser = new EmailUser();

        emailUser.sendMessage(subject, user.welcomeMessage(), email);
    }
}
