package com.kitchenApp;

import com.kitchenApp.database.dataAccess.RecipeDao;
import com.kitchenApp.database.dataAccess.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(
        name = "cookHome",
        urlPatterns = {"/lineCook"}
)

/**
 * redirect class for lineCook.jsp page
 * @author afaherty
 * Date: 10/16/2015
 */
public class LineCookHomeJSPRedirect extends HttpServlet {

    private final Logger log = Logger.getLogger(LineCookHomeJSPRedirect.class);

    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        displayRecipeList(context, session);
        displayUserList(context, session);
        redirectUser(response);
    }

    /**
     * Redirects user to chef.jsp
     * @param response HttpServletResponse object
     * @throws IOException if there is an input/output error
     */
    public void redirectUser(HttpServletResponse response) throws IOException {

        String url = "/lineCook/lineCook.jsp";

        log.debug("Accessing: " + url);

        response.sendRedirect(url);
    }

    /** Retrieves recipe list to display to the web page
     * @param context ServletContext object
     * @param session HttpSession object
     */
    public void displayRecipeList(ServletContext context, HttpSession session) {

        RecipeDao recipeDao = (RecipeDao)context.getAttribute("recipeDao");

        session.setAttribute("displayRecipes", recipeDao.getRecipeList());

        log.debug("loading recipe list");
    }

    /** Retrieves user list to display to the web page
     * @param context ServletContext object
     * @param session HttpSession object
     */
    public void displayUserList(ServletContext context, HttpSession session) {

        UserDao userDao = (UserDao)context.getAttribute("userDao");

        session.setAttribute("displayUsers", userDao.getUserList());

        log.debug("loading user list");
    }
}