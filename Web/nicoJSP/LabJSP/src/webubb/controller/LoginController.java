package webubb.controller;

/**
 * Created by forest.
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webubb.model.DBManager;
import webubb.model.User;



public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        DBManager dbmanager = new DBManager();
        User user = dbmanager.authenticate(username, password);
        if (user != null) {
            rd = request.getRequestDispatcher("/topics.jsp");
            // Here we should set the "user" attribute on the session like this:
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // .. and then, in all JSP/Servlet pages we should check if the "user" attribute exists in the session
            // and if not, we should return/exit the method:
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

}