package com.kitchenApp;

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

        String url = "/lineCook/lineCook.jsp";

        log.info("Accessing: " + url);

        response.sendRedirect(url);
    }
}