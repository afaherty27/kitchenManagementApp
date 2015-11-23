package com.kitchenApp;

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

@WebServlet(
        name = "removeEmployeeServlet",
        urlPatterns = "/chef/removeUser"
)

public class RemoveEmployeeAction extends HttpServlet {

    private final Logger log = Logger.getLogger(RemoveEmployeeAction.class)
    /**
     * Handles HTTP post request
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //TODO recieve value entered in text box. parse to Int.

        // TODO display list of employees on button click

        // TODO remove employee from database. Confirm before delete?????

        // TODO display successful deletion message.

        redirectOnSubmit(response);

    }
    /**
     * Redirects user to clean form after submit. posts message for successful add
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void redirectOnSubmit(HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/removeEmployee";
        response.sendRedirect(url);
    }
}