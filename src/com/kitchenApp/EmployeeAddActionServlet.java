package com.kitchenApp;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
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


        // i believe I need to create a session for hibernate to be integrated here

        addUserData(request);
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

       UserDao dao = new UserDao();
        User user = new User(0, "gfaherty", "gpassword", "123 Some St.", "1234567890", "gfaherty@domain.com", "1234567890");
        dao.addUser(user);
     //User user = new User(0, userName, password, address, phone, email, social);

    }

    public void addUserRoleData(HttpServletRequest request) {

        // create a new UserRoleDoa object reference
        //userRoleDao = new userRoleDao();

        // TODO vars that refer to each form field refering to a UserRole object constructor
        String userName = request.getParameter("userName");
        String userRole = request.getParameter("selectRole");

        log.info("input recieved: " + userName + " " + userRole);

        // TODO UserRole userRole = new UserRole(param, param, param);
        // TODO userRoleDoa.addUserRole(userRole);
    }
}
