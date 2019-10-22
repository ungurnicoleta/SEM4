package webubb.model;

public class Image {
    private int id;
    private String name;
    private String url;

    public Image(int ID, String name, String url) {
        this.id = ID;
        this.name = name;
        this.url = url;
    }

    public Image(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
