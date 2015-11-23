package com.kitchenApp;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afaherty
 * @version 1.0 on 11/23/2015
 */

public class RemoveEmployeeJSPForward extends HttpServlet {

    private final Logger log = Logger.getLogger(AddEmployeeJSPForward.class);

    /**
     * forwards user to chef/removeEmployee.jsp
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/removeEmployee.jsp";

        log.info("Accessing: " + url);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
