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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(

)
/**
 * Performs update and delete actions on database from UI
 * @author afaherty
 * @version 1.0 on 11/26/15
 */
public class ManageEmployeesAction extends HttpServlet {

    private UserDao userDao;
    private HttpSession session;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Performs get actions
     * @param request HttpServletRequest object
     * @param response HttpServlerResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*
            List all employees information, sans password.
            use C tag lib foreach, call java bean data on page.
         */
        ServletContext context = getServletContext();
        userDao = (UserDao)context.getAttribute("dao");

        session = request.getSession();

        List userList = userDao.getUserList();
        session.setAttribute("displayUsers", userList);
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
