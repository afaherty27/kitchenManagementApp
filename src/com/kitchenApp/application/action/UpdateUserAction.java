package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

/**
 * Performs user updates
 * @author afaherty
 * @version 2.0 on 11/30/2015
 */
public class UpdateUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * updates user data to kitchenapp database user table
     * @param userId ref to user id
     * @param address ref to address
     * @param phone ref to phone
     * @param email ref to email
     * @param userDao UserDao object
     * @return userDao
     */
    public UserDao updateUserData(String userId, String address, String phone, String email, UserDao userDao) {

        int idInt = Integer.parseInt(userId);

        userDao.updateUser(idInt, address, phone, email, idInt);

        log.info("updated " +  userDao.getUser(idInt) + " in database");

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param userId reference to user role id
     * @param userRole reference to user role
     * @param userDao UserDao object
     * @param roleDao UserRoleDao object
     * @return userRoleDao
     */
    public UserRoleDao updateUserRoleData(String userId, String userRole, UserDao userDao, UserRoleDao roleDao) {

        int idInt = Integer.parseInt(userId);

        //receive user data from users table
        User user = userDao.getUser(idInt);

        //fetch user_role table data via the PK/FK relationship
        //convert User object data into String object
        String stringRoleId = String.valueOf(user.getRole().getRoleId());

        // convert String to int
        int intRoleId = Integer.parseInt(stringRoleId);

        roleDao.updateUserRole(intRoleId, userRole);

        log.info("updated " + user.getUserName() + " roles in database");

        return roleDao;
    }
}
