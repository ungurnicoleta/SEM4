package model;

public class Profile {
    private int id;
    private String name;
    private String email;
    private String address;
    private String imgSrc;
    private int age;
    private String homeTown;
    private int userid;

    public Profile(int id, String name, String email, String address, String imgSrc, int age, String homeTown, int userid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.imgSrc = imgSrc;
        this.age = age;
        this.homeTown = homeTown;
        this.userid = userid;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
