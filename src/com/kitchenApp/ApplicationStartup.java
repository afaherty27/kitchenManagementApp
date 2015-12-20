package com.kitchenApp;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import org.apache.log4j.Logger;

import javax.servlet.Servlet;
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
 * @version 10 on 12/19/2015
 */
public class ApplicationStartup extends HttpServlet {

    private Properties properties;
    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private final Logger log = Logger.getLogger(this.getClass());

    public void init() throws ServletException {

        loadProperties();

        ServletContext context = getServletContext();

        context.setAttribute("kitchenAppProperties", properties);

    }

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
    }


}
