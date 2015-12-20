package com.kitchenApp;

import com.kitchenApp.database.dataAccess.RecipeDao;
import org.apache.log4j.Logger;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(
        name = "chefHome",
        urlPatterns = {"/chef"}
)

/**
 * redirect class for chef.jsp page
 * @author afaherty
 * Date: 10/14/2015
 */
public class ChefHomeJSPRedirect extends HttpServlet {

    private final Logger log = Logger.getLogger(ChefHomeJSPRedirect.class);
    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayRecipeList(request);
        redirectUser(response);
    }

    /**
     * Redirects user to chef.jsp
     * @param response HttpServletResponse object
     * @throws IOException if there is an input/output error
     */
    public void redirectUser(HttpServletResponse response) throws IOException {

        String url = "/chef/chef.jsp";

        log.debug("Accessing: " + url);

        response.sendRedirect(url);
    }

    /** Retrieves recipe list to display to the web page
     * @param request HttpServletRequest object
     */
    public void displayRecipeList(HttpServletRequest request) {

        RecipeDao recipeDao = new RecipeDao();

        HttpSession session = request.getSession();

        session.setAttribute("displayRecipes", recipeDao.getRecipeList());

        log.debug("loading recipe list");
    }
}
