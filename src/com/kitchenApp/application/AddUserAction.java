package com.kitchenApp.application;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Adds user data to the database
 * @author afaherty
 * @version 1.0 on 11/30/2015
 */
public class AddUserAction extends HttpServlet {

    private static final int ID_PLACEHOLDER = 0; //for hibernate auto increment

    private final Logger log = Logger.getLogger(this.getClass());

    private User user;
    private UserDao userDao;
    private UserRole userRole;
    private UserRoleDao userRoleDao;

    /**
     * adds user data to kitchenapp database user table
     * @param request HttpServletRequest object
     */
    public User addUserData(HttpServletRequest request) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String address  = request.getParameter("userAddress");
        String phone    = request.getParameter("userPhone");
        String email    = request.getParameter("userEmail");
        String social   = request.getParameter("userSocial");

        userDao = new UserDao();
        user = new User(ID_PLACEHOLDER, userName, password, address, phone, email, social);
        userDao.addUser(user);

        log.info(user.toString());

        return user;

    }

    /**
     * add user role data to kitchenapp database user_role table
     * @param request HttpServletRequest object
     */
    public UserRole addUserRoleData(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String roleType = request.getParameter("selectRole");

        userRoleDao = new UserRoleDao();
        userRole = new UserRole(ID_PLACEHOLDER, userName, roleType);
        userRoleDao.addUserRole(userRole);

        log.info(userRole.toString());

        return userRole;
    }
}
