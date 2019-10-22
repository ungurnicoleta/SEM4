package webubb.controller;


//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import webubb.model.Comment;
//import webubb.model.DBManager;
//import webubb.model.Topic;
//import webubb.model.User;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
public class CommentsController extends HttpServlet {
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (user==null || user.getUsername().equals("")) {
//            //return;
//            RequestDispatcher rd = null;
//            rd = request.getRequestDispatcher("/error.jsp");
//            rd.forward(request, response);
//        }
//
//        int topicID = Integer.parseInt(request.getParameter("topicID"));
//        DBManager dbmanager = new DBManager();
//        Topic topic = dbmanager.getTopicWithId(topicID);
//        session.setAttribute("selectedTopic", topic);
//
//        RequestDispatcher rd = null;
//        rd = request.getRequestDispatcher("/comments.jsp");
//        rd.forward(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (user==null || user.getUsername().equals("")) {
//            //return;
//            RequestDispatcher rd = null;
//            rd = request.getRequestDispatcher("/error.jsp");
//            rd.forward(request, response);
//        }
//
//        String action = request.getParameter("action");
//
//        if ((action != null) && action.equals("get")) {
//            response.setContentType("application/json");
//            DBManager dbmanager = new DBManager();
//            ArrayList<Comment> comments = dbmanager.getCommentsOfTopic(Integer.parseInt(request.getParameter("topicID")));
//            JSONArray jsonComments = new JSONArray();
//            for (int i = 0; i < comments.size(); i++) {
//                JSONObject jObj = new JSONObject();
//                jObj.put("id", comments.get(i).getId());
//                jObj.put("topicID", comments.get(i).getTopicID());
//                jObj.put("author", comments.get(i).getAuthor());
//                jObj.put("text", comments.get(i).getText());
//                jsonComments.add(jObj);
//            }
//            PrintWriter out = new PrintWriter(response.getOutputStream());
//            out.println(jsonComments.toJSONString());
//            out.flush();
//        } else if ((action != null) && action.equals("add")) {
//            Comment comment = new Comment(
//                    Integer.parseInt(request.getParameter("topicID")),
//                    request.getParameter("author"),
//                    request.getParameter("text"));
//            DBManager dbmanager = new DBManager();
//            Boolean result = dbmanager.addComment(comment);
//            PrintWriter out = new PrintWriter(response.getOutputStream());
//            if (result == true) {
//                out.println("Added comment successfully.");
//            } else {
//                out.println("Error adding comment!");
//            }
//            out.flush();
//        } else if ((action != null) && action.equals("delete")) {
//            int commentID = Integer.parseInt(request.getParameter("commentID"));
//            String username = request.getParameter("username");
//            DBManager dbmanager = new DBManager();
//            Boolean result = dbmanager.deleteComment(username, commentID);
//            PrintWriter out = new PrintWriter(response.getOutputStream());
//            if (result == true) {
//                out.println("Deleted comment successfully.");
//            } else {
//                out.println("Error deleting comment!");
//            }
//            out.flush();
//        } else if((action != null) && action.equals("searchComments")) {
//            response.setContentType("application/json");
//            DBManager dbmanager = new DBManager();
//            ArrayList<Topic> topics = dbmanager.searchAllComments(request.getParameter("wantedString"));
//            JSONArray jsonTopics = new JSONArray();
//            for (int i = 0; i < topics.size(); i++) {
//                JSONObject jObj = new JSONObject();
//                jObj.put("id", topics.get(i).getId());
//                jObj.put("name", topics.get(i).getName());
//                jObj.put("description", topics.get(i).getDescription());
//                jObj.put("username", topics.get(i).getUsername());
//                jsonTopics.add(jObj);
//            }
//            PrintWriter out = new PrintWriter(response.getOutputStream());
//            out.println(jsonTopics.toJSONString());
//            out.flush();
//        }
//    }
}
