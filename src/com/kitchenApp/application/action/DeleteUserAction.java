package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @author afaherty
 * @version 1.0 on 11/23/2015
 */
public class DeleteUserAction extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private UserDao userDao;
    private UserRoleDao userRoleDao;

    /**
     * updates user data to kitchenapp database user table
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public UserDao deleteUserData(HttpServletRequest request) throws ServletException, IOException {

        String userId = request.getParameter("selectDelete");
        int idInt = Integer.parseInt(userId);

        userDao = new UserDao();
        userDao.deleteUser(idInt);

        log.info("deleting user");

        return userDao;
    }

    /**
     * update user role data to kitchenapp database user_role table
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public UserRoleDao deleteUserRoleData(HttpServletRequest request) throws ServletException, IOException {

        String userId = request.getParameter("selectDelete");
        int idInt = Integer.parseInt(userId);

        userRoleDao = new UserRoleDao();
        userRoleDao.deleteUserRole(idInt);

        log.info("deleting userrole");

        return userRoleDao;
    }
}