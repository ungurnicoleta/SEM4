package controller;
import model.*;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProfileController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ((action != null) && action.equals("getAll")) {
            response.setContentType("application/json");
            Authenticator authenticator = new Authenticator();
            List<Content> profiles = authenticator.getAllContent();
            System.out.println("aci" + profiles.size());
            JSONArray jsonAssets = new JSONArray();
            for (int i = 0; i < profiles.size(); i++) {
                JSONObject jObj = new JSONObject();
                jObj.put("id", profiles.get(i).getId());
                jObj.put("date", profiles.get(i).getDate());
                jObj.put("title", profiles.get(i).getTitle());
                jObj.put("description", profiles.get(i).getDescription());
                jObj.put("url", profiles.get(i).getUrl());
                jObj.put("userid", profiles.get(i).getUserid());
                jsonAssets.put(jObj);
            }
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(jsonAssets.toString());
            out.flush();
        } else if ((action != null) && action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            Authenticator authenticator = new Authenticator();
            Boolean result = authenticator.deleteContentById(id, user.getId());
            PrintWriter out = new PrintWriter(response.getOutputStream());
            if (result == true) {
                out.println("Created profile successfully.");
            } else {
                out.println("Error creating profile!");
            }
            out.flush();
        } else if ((action != null) && action.equals("recentContent")) {
            Authenticator authenticator = new Authenticator();
            List<Content> profiles = authenticator.getRecentContent();
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            String s = "<tr style='background-color: mediumseagreen'><td>ID</td><td>Date</td>" +
                    "<td>Title</td><td>Description</td><td>URL</td><td>UserID</td></tr>";
            for (int i = 0; i < profiles.size(); i++)
                s += "<tr id='tr" + i + "'><td>" + profiles.get(i).getId() + "</td>" +
                        "<td>" + profiles.get(i).getDate() + "</td>" +
                        "<td>" + profiles.get(i).getTitle() + "</td>" +
                        "<td>" + profiles.get(i).getDescription() + "</td>" +
                        "<td>" + profiles.get(i).getUrl() + "</td>" +
                        "<td>" + profiles.get(i).getUserid() + "</td></tr>";
            PrintWriter out = new PrintWriter(response.getOutputStream());
            if (user.getRole() == 0)
                out.println(s);
            else
                out.println("");
            out.flush();
        } else if ((action != null) && action.equals("get")) {
            Authenticator authenticator = new Authenticator();
            List<Content> profiles = authenticator.getAllContent();
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(profiles.size());
            out.flush();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = request.getParameter("date");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Authenticator authenticator = new Authenticator();
        PrintWriter out = new PrintWriter(response.getOutputStream());
        if(user.getRole() == 0)
            out.println("Error creating content!");
        else {
            Boolean result = authenticator.addContent(date, title, description, url, user.getId());
            if (result == true) {
                out.println("Created content successfully.");
            } else {
                out.println("Error creating content!");
            }
        }
        out.flush();

//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String address = request.getParameter("address");
//        String imgSrc = request.getParameter("imgSrc");
//        String homeTown = request.getParameter("homeTown");
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        Authenticator authenticator = new Authenticator();
//        Boolean result = authenticator.addProfile(name, email, address, imgSrc, age, homeTown, user.getId());
//        PrintWriter out = new PrintWriter(response.getOutputStream());
//        if (result == true) {
//            out.println("Created profile successfully.");
//        } else {
//            out.println("Error creating profile!");
//        }
//        out.flush();
    }
}
