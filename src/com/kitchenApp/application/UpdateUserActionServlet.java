package com.kitchenApp.application;

import com.kitchenApp.application.action.UpdateUserAction;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
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
 * Performs webapp database update action
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

        HttpSession session = request.getSession();

        receiveUserParameters(request);

        redirectOnSubmit(response);
    }

    /**
     * Receives values from manageUser.jsp update modal
     * * @param request HttpServletRequest object
     */
    public void receiveUserParameters(HttpServletRequest request) {

        String userId = request.getParameter("selectUser");
        String address  = request.getParameter("userAddress");
        String phone    = request.getParameter("userPhone");
        String email    = request.getParameter("userEmail");
        String userRole  = request.getParameter("selectRole");

        updateUser(userId, address, phone, email, userRole);

    }

    /**
     * passes values into update action
     * @param userId ref to user id
     * @param address ref to user address
     * @param phone ref to user phone
     * @param email ref to user email
     * @param userRole ref to user role
     */
    public void updateUser(String userId, String address, String phone, String email, String userRole) {

        UpdateUserAction update = new UpdateUserAction();
        update.updateUserRoleData(userId, userRole);
        update.updateUserData(userId, address, phone, email);

    }

    /**
     * Redirects user to clean form after submit. posts message for successful add
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
        * @throws IOException      if there is an input/output error
        */
        public void redirectOnSubmit(HttpServletResponse response) throws ServletException, IOException {

            log.info("accessed user update");
        String url = "/chef/manageEmployees";
        response.sendRedirect(url);
    }
}
