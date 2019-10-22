package webubb.model;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Statement stmt;

    public DBManager() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_JSP", "nicoletaungur", "test");
            stmt = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Eroare la connect: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public User authenticate(String username, String password) {
        ResultSet rs;
        User u = null;
        System.out.println(username + " " + password);
        try {
            rs = stmt.executeQuery("select * from users where username='" + username + "' and password='" + password + "'");
            if (rs.next()) {
                u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public ArrayList<Image> getAllImages() {
        ArrayList<Image> images = new ArrayList<Image>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from images");
            while (rs.next()) {
                images.add(new Image(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("url")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    public boolean addImage(Image image) {
        int r = 0;
        try {
            r = stmt.executeUpdate("insert into image(name, url) values('" + image.getName() + "', '" + image.getUrl()  + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r > 0;
    }

    public ArrayList<Comment> getCommentsOfTopic(int topicID) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from comments where topicID=" + topicID);
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("id"),
                        topicID,
                        rs.getString("author"),
                        rs.getString("text")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public Image getImageWithId(int id) {
        ResultSet rs;
        Image img = null;
        try {
            rs = stmt.executeQuery("select * from images where id=" + id);
            rs.next();
            img = new Image(id, rs.getString("name"), rs.getString("url"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return img;
    }



}