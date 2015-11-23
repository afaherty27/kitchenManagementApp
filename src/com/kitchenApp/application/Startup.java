package com.kitchenApp.application;

/**
 * @author afaherty
 * @version 1.0 11/19/2015
 */

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "startup",
        urlPatterns = {"/kitchenApp-startup"},
        loadOnStartup = 1
)

/**
 * Initializes data for application
 */
public class Startup extends HttpServlet {

    private Properties properties;
    private final Logger log = Logger.getLogger(Startup.class);

    /**
     * Loads properties file into servlets
     * @throws ServletException if there is a servlet error
     */
    public void init() throws ServletException {

        loadProperties();

        ServletContext servletContext = getServletContext();

        // properties into servlet context
        servletContext.setAttribute("kitchenProperties", properties);
    }

    /**
     * instantiates Properties object to refer to properties files
     */
    public void loadProperties() {

        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("/kitchenApp.properties"));
        } catch (IOException ioException) {
            log.info("ERROR: Cannot load kitchenApp.properties");
            ioException.printStackTrace();
        } catch (Exception e) {
            log.info("Problem: " + e);
            e.printStackTrace();
        }
    }
}
