package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Performs user updates
 * @author afaherty
 * @version 1.0 on 11/30/2015
 */
public class UpdateUserAction {

    private final Logger log = Logger.getLogger(this.getClass());

    private UserDao userDao;
    private UserRoleDao userRoleDao;

    /**
     * updates user data to kitchenapp database user table
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public UserDao updateUserData(HttpServletRequest request) throws ServletException, IOException {

        String userId = request.getParameter("selectUser");

        int idInt = Integer.parseInt(userId);
        log.info(idInt);

        String address  = request.getParameter("userAddress");
        String phone    = request.getParameter("userPhone");
        String email    = request.getParameter("userEmail");

        userDao = new UserDao();

        userDao.updateUser(idInt, address, phone, email);

        log.info("updating user");

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public UserRoleDao updateUserRoleData(HttpServletRequest request) throws ServletException, IOException {

        String userId = request.getParameter("selectUser");
        int idInt = Integer.parseInt(userId);

        userRoleDao = new UserRoleDao();

        String userRole  = request.getParameter("selectRole");

        userRoleDao.updateUserRole(idInt, userRole);

        log.info("updating userrrole");

        return userRoleDao;
    }
}
