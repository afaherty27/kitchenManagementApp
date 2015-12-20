package com.kitchenApp;

import com.kitchenApp.database.dataAccess.RecipeDao;
import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import org.apache.log4j.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "appStartup",
        urlPatterns = "/kitchenAppStartup",
        loadOnStartup = 1
)
/**
 * Initializes data for  application
 * @author afaherty
 * @version 1.0 on 12/19/2015
 */
public class ApplicationStartup extends HttpServlet {

    private Properties properties;
    private RecipeDao recipeDao;
    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Loads properties and daos into application at startup
     * @throws ServletException if there is a servlet error
     */
    public void init() throws ServletException {

        loadProperties();
        loadRecipeDao();
        loadUserDao();
        loadUserDao();

        ServletContext context = getServletContext();

        context.setAttribute("kitchenAppProperties", properties);
        context.setAttribute("recipeDao", recipeDao);
        context.setAttribute("userDao", userDao);
        context.setAttribute("userRoleDao", userRoleDao);
    }

    /**
     * Loads properties file into application
     */
    public void loadProperties() {

        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("/kitchenApp.properties"));

        } catch (IOException io) {

            io.printStackTrace();
            log.error("ERROR LOADING PROPERTIES FILE");
        } catch (Exception e) {

            e.printStackTrace();
            log.error("Exception Caught");
        }

        log.debug("kitchenApp.properties file loaded");
    }

    /**
     * Instantiates a new RecipeDao object
     */
    public void loadRecipeDao() {

        recipeDao = new RecipeDao();
    }

    /**
     * Instantiates a new UserDao object
     */
    public void loadUserDao() {

        userDao = new UserDao();
    }

    /**
     * Instantiates a new UserRoleDao object
     */
    public void loadUserRoleDao() {

        userRoleDao = new UserRoleDao();
    }
}
