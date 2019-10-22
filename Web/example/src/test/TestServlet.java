package test;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "TestServlet", urlPatterns = {"/servlet/test"})
public class TestServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        pr.println("<h1>Hello world</h1>");
        pr.flush();
    }
}
