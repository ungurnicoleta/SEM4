package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private Statement stmt;
    private Connection con;

    public Authenticator() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam", "root", "test");
            stmt = con.createStatement();
        } catch(Exception ex) {
            System.out.println("Connection error:" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Users authenticate(String username, String password) {
        ResultSet rs;
        Users u = null;
        System.out.println(username + " " + password);
        try {
            rs = stmt.executeQuery("select * from Users where User =" + username + " and Password=" + password + ";");
            if (rs.next())
                u = new Users(rs.getInt("ID"), rs.getString("User"), rs.getString("Password"),
                        rs.getInt("Role"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public List<Content> getAllContent() {
        List<Content> profiles = new ArrayList<Content>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from Content");
            while (rs.next()) {
                profiles.add(new Content(
                        rs.getInt("ID"),
                        rs.getString("date"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getInt("userID")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public List<Content> getRecentContent() {
        List<Content> profiles = new ArrayList<Content>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from Content order by id desc limit 4");
            while (rs.next()) {
                profiles.add(new Content(
                        rs.getInt("id"),
                        rs.getString("date"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getInt("userid")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public boolean addContent(String date, String title, String description, String url, int userid)
    {
        ResultSet res;
        try{
            String query = "INSERT INTO Content (`date`, `title`, `description`, `url`, `userid`) " +
                    "VALUES ('"+ date + "' , '" + title +  "' , '" + description +  "' , '"+ url +   "' , " + userid + ")";
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            res = pstmt.getGeneratedKeys();
            if(res != null && res.next())
                return true;
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Content getContentById(int id) {
        ResultSet rs;
        Content c = null;
        try {
            rs = stmt.executeQuery("select * from Content where id =" + id);
            if (rs.next())
                c = new Content(
                        rs.getInt("id"),
                        rs.getString("date"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getInt("userid"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Boolean deleteContentById(int id, int userid) {
        Content c = getContentById(id);
        if(c != null) {
            if(c.getUserid() != userid)
                return false;
            else
                try {
                    String query = "delete from Content where id= "+ id;
                    int r = stmt.executeUpdate(query);
                    if(r > 0)
                        return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<Profile>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from Profile");
            while (rs.next()) {
                profiles.add(new Profile(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("imgSrc"),
                        rs.getInt("age"),
                        rs.getString("homeTown"),
                        rs.getInt("userid")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public Profile getUserProfile(int userid) {
        ResultSet rs;
        Profile p = null;
        try {
            rs = stmt.executeQuery("select * from Profile where userid = " + userid);
            rs.next();
            p = new Profile(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("imgSrc"),
                    rs.getInt("age"),
                    rs.getString("homeTown"),
                    rs.getInt("userid"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean updateProfile(int userId, String name, String email,  String address, String imgSrc, int age, String homeTown) {
        int r = 0;
        try {
            String query = "update Profile set name = '"+ name + "', email = '" + email +
                    "', address = '" + address + "', age = " + age +
                    ", homeTown = '"+ homeTown + "'";
            if(imgSrc != "")
                query = query + ", imgSrc = '" + imgSrc + "'";
            query = query + " where userid = " + userId;
            r = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (r>0) return true;
        else return false;
    }

    public List<Profile> getProfiles(int userid, String name, String email, String address, String age, String homeTown) {
        String query = "select * from Profile where id is not null ";// + userid;
        if(name != "")
            query = query + "AND name LIKE '%" + name + "%' ";
        if(email != "")
            query = query + "AND email LIKE '%" + email + "%' ";
        if(address != "")
            query = query + "AND address LIKE '%" + address + "%' ";
        if(age != "")
            query = query + "AND age = " + Integer.parseInt(age);
        if(homeTown != "")
            query = query + "AND homeTown LIKE '%" + homeTown + "%' ";
        List<Profile> profiles = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                profiles.add(new Profile(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("imgSrc"),
                        rs.getInt("age"),
                        rs.getString("homeTown"),
                        rs.getInt("userid")
                ));
            }
        }catch ( SQLException e ) {
            e.printStackTrace();
        }
        return profiles;
    }

    public boolean addUser(String username, String password)
    {
        ResultSet rs;
        try{
            String query = "INSERT INTO User (`username`, `password`) VALUES ('"+ username + "' , '" + password + "')";
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next())
                return true;
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addProfile(String name, String email, String address, String imgSrc, int age, String homeTown, int userid)
    {
        ResultSet res;
        try{
            String query = "INSERT INTO Profile (`name`, `email`, `address`, `imgSrc`, `age`, `homeTown`, `userid`) " +
                    "VALUES ('"+ name + "' , '" + email +  "' , '" + address +  "' , '"+ imgSrc +  "' , " + age +  " , '" + homeTown +  "' , " + userid + ")";
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            res = pstmt.getGeneratedKeys();
            if(res != null && res.next())
                return true;
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
