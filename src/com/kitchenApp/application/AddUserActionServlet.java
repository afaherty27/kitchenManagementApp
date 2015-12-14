package com.kitchenApp.application;

import com.kitchenApp.application.action.AddUserAction;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "addEmployeeServlet",
        urlPatterns = "/chef/addAction"
)

/**
 *  Extracts HTML form data to be added to the database regarding new users
 *  @author afaherty
 * 11/5/2015
 */
public class AddUserActionServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Handles HTTP post request
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        createSession(request);

        receiveUserParameters(request);

        redirectOnSubmit(response);
    }

    /**
     * Receives values from addUser.jsp form
     * @param request HttpServletRequest object
     */
    public void receiveUserParameters(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String address  = request.getParameter("userAddress");
        String phone    = request.getParameter("userPhone");
        String email    = request.getParameter("userEmail");
        String roleType = request.getParameter("selectRole");

        addUser(userName, password, address, phone, email, roleType);
    }

    /**
     * Passes values from form to action servlet
     * @param userName ref to form user name input
     * @param password ref to form password input
     * @param address ref to form address input
     * @param phone ref to form phone input
     * @param email ref to form email input
     * @param roleType ref to form role input
     */
    public void addUser(String userName, String password, String address, String phone,
                        String email, String roleType) {

        AddUserAction addUser = new AddUserAction();
        addUser.addUserData(userName, password, address, phone, email);
        addUser.addUserRoleData(userName, roleType);
    }

    /**
     * Redirects user to clean form after submit. posts message for successful add
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void redirectOnSubmit(HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/addEmployee";
        response.sendRedirect(url);
    }

    /**
     * Retrieve this session
     * @param request HttpServletRequest object
     */
    public void createSession(HttpServletRequest request) {

        HttpSession session = request.getSession();
        log.debug("requesting Session");
        writeSessionMessage(session);

    }

    /**
     * output a message to the jsp for a succesfull add
     * @param session HttpSession object
     */
    public void writeSessionMessage(HttpSession session) {

        String message = (String) session.getAttribute("entryString");

        message = "<h4 style=\"color: red; font-variant: small-caps\""
                + ">Success</h4>";
        session.setAttribute("entryString", message);
        log.info("User added successfully");
    }
}
