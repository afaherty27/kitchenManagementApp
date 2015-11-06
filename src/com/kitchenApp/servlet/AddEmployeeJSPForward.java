package com.kitchenApp.servlet;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 11/5/2015
 */
@WebServlet(
        name = "addEmployeeForm",
        urlPatterns = {"/chef/addEmployee"}
)

/**
 * forwarding class for addEmployee.jsp page
 */
public class AddEmployeeJSPForward extends HttpServlet {

    private final Logger log = Logger.getLogger(AddEmployeeJSPForward.class);

    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/addEmployee.jsp";

        log.info("Accessing: " + url);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
