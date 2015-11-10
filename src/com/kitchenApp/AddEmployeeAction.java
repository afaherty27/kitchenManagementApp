package com.kitchenApp;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;

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
        urlPatterns = "/addAction"
)

/**
 *  Extracts HTML form data to be added to the database
 */
public class AddEmployeeAction extends HttpServlet {

    private UserDao userDoa;
    private UserRoleDao userRoleDoa;


    /**
     * Handles HTTP post request
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse objet
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    /**
     *  Recieves User object related data from form to submit to database
     * @param request the HttpServletRequest object
     */
    public void addUserData(HttpServletRequest request) {

        // create a new userDoa object reference
        //userDao = new userDao();

        //  TODO vars that refer to each form field refering to a User object constructor

        // TODO User user = newUser(param, param, param, param, param, param, param);
        // TODO userDoa.addUser(user);
    }

    public void addUserRoleData(HttpServletRequest request) {

        // create a new UserRoleDoa object reference
        //userRoleDao = new userRoleDao();

        // TODO vars that refer to each form field refering to a UserRole object constructor

        // TODO UserRole userRole = new UserRole(param, param, param);
        // TODO userRoleDoa.addUserRole(userRole);
    }
}
