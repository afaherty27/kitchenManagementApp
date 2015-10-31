package com.kitchenApp;

import org.apache.log4j.Logger;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/14/2015
 */
@WebServlet(
        name = "chefHome",
        urlPatterns = {"/chef"}
)
public class ChefHomeJSPRedirect extends HttpServlet {

    //private final Logger logger = Logger.getLogger(ChefHomeJSPRedirect.class);

    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef/chef.jsp";

        response.sendRedirect(url);

        //logger.info("Directing to " + url);

    }
}
