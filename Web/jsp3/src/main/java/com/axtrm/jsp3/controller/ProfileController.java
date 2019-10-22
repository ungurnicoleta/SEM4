package com.axtrm.jsp3.controller;
import com.axtrm.jsp3.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            List<Planets> planets = authenticator.getAllPlanets();
            System.out.println("aci" + planets.size());
            JSONArray jsonAssets = new JSONArray();
            for (int i = 0; i < planets.size(); i++) {
                JSONObject jObj = new JSONObject();
                try {
                    jObj.put("id", planets.get(i).getId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jObj.put("name", planets.get(i).getName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jObj.put("color", planets.get(i).getColor());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jObj.put("description", planets.get(i).getDescription());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jsonAssets.put(jObj);
            }
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(jsonAssets.toString());
            out.flush();
        } else if ((action != null) && action.equals("getDetails")) {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            Astronauts user = (Astronauts) session.getAttribute("user");
            Authenticator authenticator = new Authenticator();
            Planets result = authenticator.getPlanetById(id);
            String s = null;
                s += "<p>" + result.getId() + " , "+ result.getName() + " " + result.getDescription() + "</p>";
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.flush();
        } else if ((action != null) && action.equals("getPlanet")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Authenticator authenticator = new Authenticator();
            Planets planet = authenticator.getPlanetById(id);
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(planet);
            out.flush();
        }

        else if ((action != null) && action.equals("getExpeditions")) {
            Authenticator authenticator = new Authenticator();
            List<Expeditions> exp = authenticator.getExpeditions();
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println(exp);
            out.flush();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = request.getParameter("date");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        HttpSession session = request.getSession();
        Astronauts user = (Astronauts) session.getAttribute("user");
        Authenticator authenticator = new Authenticator();
        PrintWriter out = new PrintWriter(response.getOutputStream());
        out.flush();

    }
}
