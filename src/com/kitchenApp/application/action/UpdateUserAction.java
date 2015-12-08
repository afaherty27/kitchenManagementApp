package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

/**
 * Performs user updates
 * @author afaherty
 * @version 1.0 on 11/30/2015
 */
public class UpdateUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * updates user data to kitchenapp database user table
     * @param userId ref to user id
     * @param address ref to address
     * @param phone ref to phone
     * @param email ref to email
     * @return userDao
     */
    public UserDao updateUserData(String userId, String address, String phone, String email) {

        int idInt = Integer.parseInt(userId);

        UserDao userDao = new UserDao();

        userDao.updateUser(idInt, address, phone, email);

        log.info("updating user");

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param userId reference to user role id
     * @param userRole reference to user role
     * @return userRoleDao
     */
    public UserRoleDao updateUserRoleData(String userId, String userRole) {


        int idInt = Integer.parseInt(userId);

        UserRoleDao userRoleDao = new UserRoleDao();

        userRoleDao.updateUserRole(idInt, userRole);

        log.info("updating userrrole");

        return userRoleDao;
    }
}
