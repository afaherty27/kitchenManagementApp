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
 * @version 1.0 on 11/30/2015
 */
public class AddUserAction {

    private static final int ID_PLACEHOLDER = 0; //for hibernate auto increment

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * adds user data to kitchenapp database user table
     * @param userName ref to user name received from jsp
     * @param password ref to user password received from jsp
     * @param address ref to user address received from jsp
     * @param phone ref to user phone received from jsp
     * @param email ref to user email received from jsp
     * @return user
     */
    public User addUserData(String userName, String password, String address, String phone,
                            String email, String roleType) {

        UserRole userRole = new UserRole(ID_PLACEHOLDER, userName, roleType);
        User user = new User(ID_PLACEHOLDER, userName, password, address, phone, email, userRole);

        log.info(user.toString());
        log.info(userRole.toString());

        Set<User> roles = new HashSet<User>();
        roles.add(user);

        userRole.setUser(roles);
        UserRoleDao dao = new UserRoleDao();

        dao.addUserRole(userRole);

        return user;
    }

    /**
     * add user role data to kitchenapp database user_role table
     * @param userName ref to user name received from jsp
     * @param roleType ref to role received from jsp
     * @return userRole
     */
    public UserRole addUserRoleData(String userName, String roleType) {

        UserRoleDao userRoleDao = new UserRoleDao();
        UserRole userRole = new UserRole(ID_PLACEHOLDER, userName, roleType);
        userRoleDao.addUserRole(userRole);

        log.info(userRole.toString());

        return userRole;
    }
}
