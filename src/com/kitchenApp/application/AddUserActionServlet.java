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

/**
 * @author afaherty
 * 11/5/2015
 */

@WebServlet(
        name = "addEmployeeServlet",
        urlPatterns = "/chef/addAction"
)

/**
 *  Extracts HTML form data to be added to the database regarding new users
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

        AddUserAction addUser = new AddUserAction();
        addUser.addUserData(request);
        addUser.addUserRoleData(request);

        redirectOnSubmit(response);
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

    public void createSession(HttpServletRequest request) {

        HttpSession session = request.getSession();
        log.debug("requesting Session");
        writeSessionMessage(session);

    }

    public void writeSessionMessage(HttpSession session) {

        String message = (String) session.getAttribute("entryString");

        message = "<h4 style=\"color: red; font-variant: small-caps\""
                + ">Success</h4>";
        session.setAttribute("entryString", message);
        log.info("User added successfully");
    }
}
