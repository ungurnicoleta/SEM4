package servlets;

import models.User;
import repositories.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/servlets/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserRepository repo = new UserRepository();
        User user = repo.getUser(username);

        boolean isValid = false;

        if (user != null && user.Password.equals(password))
        {
            isValid = true;
        }

        RequestDispatcher rd = null;

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            rd = request.getRequestDispatcher("/mainPage.jsp");
        } else {
            rd = request.getRequestDispatcher("/loginFailed.jsp");
        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
