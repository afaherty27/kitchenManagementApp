package com.kitchenApp;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
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
        name = "manageEmployees",
        urlPatterns = {"/chef/manageEmployees"}
)

/**
 * forwarding class for manageEmployees.jsp
 */
public class ManageEmployeesJSPForward extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * forwards user to chef/manageEmployees.jsp
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/manageEmployees.jsp";

        log.info("Accessing: " + url);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
