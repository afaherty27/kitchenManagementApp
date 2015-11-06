package com.kitchenApp.servlet;

import org.apache.log4j.Logger;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/16/2015
 */
@WebServlet(
        name = "generalManagerHome",
        urlPatterns = {"/generalManager"}
)
/**
 * redirect class for generalManager.jsp page
 */
public class GMHomeJSPRedirect extends HttpServlet {

    private final Logger log = Logger.getLogger(GMHomeJSPRedirect.class);

    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/gm/generalManager.jsp";

        log.info("Accessing: " + url);

        response.sendRedirect(url);
    }
}
