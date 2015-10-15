package com.kitchenApp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author afaherty
 * Date: 10/14/2015
 */
@WebServlet(
       name = "loginRedirect",
       urlPatterns = {"/login"}
)

public class LoginRedirect extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String url = "";

        /*
        PSUEDO CODE
        if SQL user_role value is chef {
            redirect to chef/chef.jsp
        }

        if SQL user_role value is line_cook {
           redirect to lineCook/lineCook.jsp
        }

        if SQL user_role value is general_manager {
            redirect to gm/generalManager.jsp
        }

        if SQL user_role value is dishwasher {
            redirect to dish/dish.jsp
        }
         */

    }
}
