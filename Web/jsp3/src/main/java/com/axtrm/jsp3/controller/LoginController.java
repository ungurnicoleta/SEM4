package com.axtrm.jsp3.controller;
import com.axtrm.jsp3.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        RequestDispatcher rd = null;
        Astronauts user = null;

        Authenticator authenticator = new Authenticator();
        user = authenticator.authenticate(username);
        List<Planets> planets = new ArrayList<>();
        planets = authenticator.getAllPlanets();
        if(user != null)
        {
            rd = request.getRequestDispatcher("/success.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("planet1", planets.get(0));
            session.setAttribute("planet2", planets.get(1));
            session.setAttribute("planet3", planets.get(2));
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
        Astronauts user = (Astronauts) session.getAttribute("user");
        Planets planet1 = (Planets) session.getAttribute("planet1");
        Planets planet2= (Planets) session.getAttribute("planet2");
        Planets planet3 = (Planets) session.getAttribute("planet3");
        if(user != null)
        {
            rd = request.getRequestDispatcher("/success.jsp");
            Authenticator authenticator = new Authenticator();
            authenticator.authenticate(user.getUsername());
            authenticator.getAllPlanets();
        }
        else
        {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);

    }
}
