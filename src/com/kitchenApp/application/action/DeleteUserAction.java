package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import org.apache.log4j.Logger;

/**
 * deletes user data from kitchenapp database
 * @author afaherty
 * @version 1.0 on 11/23/2015
 */
public class DeleteUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * updates user data to kitchenapp database user table
     * @param userId reference to user id being deleted
     */
    public UserDao deleteUserData(String userId) {

        int idInt = Integer.parseInt(userId);

        UserDao userDao = new UserDao();
        userDao.deleteUser(idInt);

        log.info("deleting user");

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param userId reference to the user role id being deleted
     */
    public UserRoleDao deleteUserRoleData(String userId )  {

        int idInt = Integer.parseInt(userId);

        UserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.deleteUserRole(idInt);

        log.info("deleting userrole");

        return userRoleDao;
    }
}