package com.kitchenApp;

import com.kitchenApp.database.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/14/2015
 */
@WebServlet(
       name = "loginRedirect",
       urlPatterns = {"/login"}
)

public class LoginRedirect extends HttpServlet {

    private DatabaseConnection databaseConnection;
    private Search search;
    private Employee employee = new Employee();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        search = new Search();

        // get database connection from servlet context
        databaseConnection = (DatabaseConnection) servletContext.getAttribute(
                "dataBaseConnection");

        placeLogInSession(request, search);

        forwardToDashboard(request, response);
    }

    /**
     *  Places Search object into session
     * @param request HttpServletRequest objuect
     * @param search Search object
     */
    private void placeLogInSession(HttpServletRequest request, Search search) {

        HttpSession loginSession = request.getSession();
        loginSession.setAttribute("loginSession", search);
    }

    public void forwardToDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String url = "";
       // RequestDispatcher dispatcher;

        if (employee.getUserRole() == "chef") {
            url = "/chef/chef.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        /*
        PSUEDO CODE
        if SQL user_role value is chef {
            url = "/chef/chef.jsp";
            redirect to chef/chef.jsp
        }

        if SQL user_role value is line_cook {
            url = "/lineCook/lineCook.jsp";
           redirect to lineCook/lineCook.jsp
        }

        if SQL user_role value is general_manager {
            url = "gm/generalManager.jsp";
            redirect to gm/generalManager.jsp
        }

        if SQL user_role value is dishwasher {
            url = "/dish/dish.jsp";
            redirect to dish/dish.jsp
        }
         */
    }
}
