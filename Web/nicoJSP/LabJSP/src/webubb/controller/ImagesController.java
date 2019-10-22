package webubb.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import webubb.model.DBManager;
import webubb.model.Image;
import webubb.model.Topic;
import webubb.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ImagesController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null || user.getUsername().equals("")) {
            //return;
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }

        String action = request.getParameter("action");

        if ((action != null) && action.equals("add")) {
            // We add a topic
            Image img = new Image(
                    request.getParameter("name"),
                    request.getParameter("url"));
            DBManager dbmanager = new DBManager();
            Boolean result = dbmanager.addImage(img);
            PrintWriter out = new PrintWriter(response.getOutputStream());
            if (result) {
                out.println("Added image successfully.");
            } else {
                out.println("Error adding image!");
            }
            out.flush();
        } else if ((action != null) && action.equals("getAll")) {
            response.setContentType("application/json");
            DBManager dbmanager = new DBManager();
            ArrayList<Image> images = dbmanager.getAllImages();
            JSONArray jsonAssets = new JSONArray();
            for (int i = 0; i < images.size(); i++) {
                JSONObject jObj = new JSONObject();
                jObj.put("id", images.get(i).getId());
                jObj.put("username", images.get(i).getName());
                jObj.put("url", images.get(i).getUrl());
                jsonAssets.add(jObj);
            }
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(jsonAssets.toJSONString());
            out.flush();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null || user.getUsername().equals("")) {
            //return;
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
