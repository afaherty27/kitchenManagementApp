package com.kitchenApp.application;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import org.apache.log4j.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

)
/**
 * Performs update and delete actions on database from UI
 * @author afaherty
 * @version 1.0 on 11/26/15
 */
public class ManageEmployeesAction extends HttpServlet {

    private UserDao user;
    private UserRoleDao userRole;
    private final Logger log = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        forwardToResults(request, response);
    }

    /**
     * Forwards user to results page
     * @param request HttpServletRequest object
     * @param response HttpServlerResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void forwardToResults(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        log.info("Retrieving Results");

        // jsp forwarding code
    }

}
