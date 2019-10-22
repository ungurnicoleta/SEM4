package webubb.model;

public class Topic {
    private int id;
    private String username;
    private String description;
    private String name;

    public Topic(int topicID, String name, String description, String username) {
        this.id = topicID;
        this.username = username;
        this.description = description;
        this.name = name;
    }

    public Topic(String name, String description, String username) {
        this.username = username;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
