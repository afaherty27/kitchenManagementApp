package com.kitchenApp.application.action;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "deleteUser",
        urlPatterns = "/chef/deleteUser"
)

/**
 * @author afaherty
 * @version 1.0 on 11/23/2015
 */
public class DeleteUserAction extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Handles HTTP post request
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO access userId
        //TODO access userRoleId
        //TODO call deleteUser from userdao
        //TODO call deleteUserRole from userroledao

        redirectOnSubmit(response);
    }

    /**
    /**
     * Redirects user to clean form after submit. posts message for successful add
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void redirectOnSubmit(HttpServletResponse response) throws ServletException, IOException {

        log.info("accessed user delete");
        String url = "/chef/manageEmployees";
        response.sendRedirect(url);
    }
}