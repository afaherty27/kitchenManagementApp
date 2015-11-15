package com.kitchenApp;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afaherty
 * 11/5/2015
 */

@WebServlet(
        name = "addEmployeeServlet",
        urlPatterns = "/chef/addAction"
)

/**
 *  Extracts HTML form data to be added to the database
 */
public class EmployeeAddActionServlet extends HttpServlet {

    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private User user;
    private UserRole userRole;
    private final Logger log = Logger.getLogger(EmployeeAddActionServlet.class);


    /**
     * Handles HTTP post request
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse objet
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        addUserData(request);
        addUserRoleData(request);

        response.sendRedirect("/chef/addEmployee.jsp");
    }

    /**
     *  Recieves User object related data from form to submit to database
     * @param request the HttpServletRequest object
     */
    public void addUserData(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String address  = request.getParameter("userAddress");
        String phone    = request.getParameter("userPhone");
        String email    = request.getParameter("userEmail");
        String social   = request.getParameter("userSocial");

        userDao = new UserDao();
        user = new User(0, userName, password, address, phone, email, social);
        userDao.addUser(user);

        log.info("user.toString() for logging purposes");
    }

    public void addUserRoleData(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String roleType = request.getParameter("selectRole");

        userRoleDao = new UserRoleDao();
        userRole = new UserRole(0, userName, roleType);
        userRoleDao.addUserRole(userRole);

        log.info("userRole.toString() for logging purposes");
    }
}
