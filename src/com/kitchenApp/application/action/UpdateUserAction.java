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
     * @return userDao
     */
    public UserDao updateUserData(String userId, String address, String phone, String email) {

        int idInt = Integer.parseInt(userId);

        UserDao userDao = new UserDao();
        userDao.updateUser(idInt, address, phone, email, idInt);

        log.info("updated " +  userDao.getUser(idInt) + " in database");

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

        //receive user data from users table
        UserDao dao = new UserDao();
        User user = dao.getUser(idInt);

        //fetch user_role table data via the PK/FK relationship
        user.getRole().getRoleId();

        //convert User object data into String object
        String stringRoleId = String.valueOf(user.getRole().getRoleId());

        // convert String to int
        int intRoleId = Integer.parseInt(stringRoleId);

        UserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.updateUserRole(intRoleId, userRole);

        log.info("updated " + user.getUserName() + " roles in database");

        return userRoleDao;
    }
}
