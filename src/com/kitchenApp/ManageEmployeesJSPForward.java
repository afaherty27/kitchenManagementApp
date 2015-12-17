package com.kitchenApp;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
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
        name = "manageEmployees",
        urlPatterns = {"/chef/manageEmployees"}
)

/**
 * forwarding class for manageEmployees.jsp
 * @author afaherty
 * @version 1.0 on 11/23/2015
 */
public class ManageEmployeesJSPForward extends HttpServlet {

    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private HttpSession session;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Retrieves list of users to display to page.
     * @param request HttpServletRequest object
     * @param response HttpServlerResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayUserList(request);

        forwardResults(request, response);
    }


    /** Retrieves user list to display to the web page
     * @param request HttpServletRequest object
     */
    public void displayUserList(HttpServletRequest request) {

       // ServletContext context = getServletContext();
        userDao = new UserDao();

        session = request.getSession();

        session.setAttribute("displayUsers", userDao.getUserList());

        log.info("loading user list");
    }

    /**
     * forwards user to chef/manageEmployees.jsp
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void forwardResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/manageEmployees.jsp";

        log.info("Accessing: " + url);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
