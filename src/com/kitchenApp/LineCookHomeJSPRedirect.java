package com.kitchenApp;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/16/2015
 */
@WebServlet(
        name = "cookHome",
        urlPatterns = {"/lineCook"}
)

public class LineCookHomeJSPRedirect extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/lineCook/lineCook.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}