package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import org.apache.log4j.Logger;

/**
 * deletes user data from kitchenapp database
 * @author afaherty
 * @version 2.0 on 12/17/2015
 */
public class DeleteUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * updates user data to kitchenapp database user table
     * @param userId reference to user id being deleted
     * @param userDao UserDao object
     * @return userDao
     */
    public UserDao deleteUserData(String userId, UserDao userDao) {

        int idInt = Integer.parseInt(userId);

        userDao.deleteUser(idInt);

        log.info("deleting" + userDao.getUser(idInt));

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param userId reference to the user role id being deleted
     * @param userDao UserDao object
     * @param roleDao UserRoleDao object
     * @return userRoleDao
     */
    public UserRoleDao deleteUserRoleData(String userId, UserDao userDao, UserRoleDao roleDao)  {

        int idInt = Integer.parseInt(userId);

        //receive user data from users table

        User user = userDao.getUser(idInt);

        //fetch user_role table data via the PK/FK relationship
        //convert User object data into String object
        String stringRoleId = String.valueOf(user.getRole().getRoleId());

        // convert String to int
        int intRoleId = Integer.parseInt(stringRoleId);

        roleDao.deleteUserRole(intRoleId);

        log.info("deleting" + user.getUserName() + " roles from DB");

        return roleDao;
    }
}