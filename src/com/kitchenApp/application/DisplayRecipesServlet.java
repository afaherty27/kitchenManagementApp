package com.kitchenApp.application;

import com.kitchenApp.database.dataAccess.RecipeDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "displayRecipeList",
        urlPatterns = "/chef/displayRecipeList"
)

/**
 * Sets modal attribute to display a list of saved recipes to the user
 * @author afaherty
 * @version 1.0 on 12/10/2015
 */
public class DisplayRecipesServlet extends HttpServlet {

    private RecipeDao recipeDao;
    private HttpSession session;
    private final Logger log = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayRecipeList(request);
    }


    /** Retrieves user list to display to the web page
     * @param request HttpServletRequest object
     */
    public void displayRecipeList(HttpServletRequest request) {

        ServletContext context = getServletContext();
        recipeDao = new RecipeDao();

        session = request.getSession();

        session.setAttribute("displayRecipes", "helloWorld");

        log.info("loading recipe list");
    }
}
