package mvcExample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import mvcExample.model.Authenticator;
import mvcExample.model.User;
 

 
public class LoginController extends HttpServlet {
 
    public LoginController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
 
        Authenticator authenticator = new Authenticator();
        String result = authenticator.authenticate(username, password);
        if (result.equals("success")) {
            rd = request.getRequestDispatcher("/success.jsp");
            User user = new User(username, password);
            request.setAttribute("user", user);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }
 
}