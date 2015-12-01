package com.kitchenApp.application;

import com.kitchenApp.application.action.UpdateUserAction;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "updateUser",
        urlPatterns = {"/chef/updateUser"}
)
/**
 * Handles user data updates
 * @author afaherty
 * @version 1.0 on 11/27/2015
 */
public class UpdateUserActionServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Handles HTTP post request
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UpdateUserAction update = new UpdateUserAction();
        update.updateUserData(request);
        update.updateUserRoleData(request);

        HttpSession session = request.getSession();

        redirectOnSubmit(response);
    }

    /**
     * Redirects user to clean form after submit. posts message for successful add
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException      if there is an input/output error
     */
    public void redirectOnSubmit(HttpServletResponse response) throws ServletException, IOException {

        log.info("accessed user delete");
        String url = "/chef/manageEmployees";
        response.sendRedirect(url);
    }
}
