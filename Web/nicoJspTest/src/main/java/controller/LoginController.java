package controller;

import model.Authenticator;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
        Users user = null;

        Authenticator authenticator = new Authenticator();
        user = authenticator.authenticate(username, password);
        if(user != null)
        {
            rd = request.getRequestDispatcher("/success.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        else
        {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        Users user = (Users) session.getAttribute("user");
        if(user != null)
        {
            rd = request.getRequestDispatcher("/success.jsp");
            Authenticator authenticator = new Authenticator();
            authenticator.authenticate(user.getUsername(), user.getPassword());
        }
        else
        {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);

    }
}
