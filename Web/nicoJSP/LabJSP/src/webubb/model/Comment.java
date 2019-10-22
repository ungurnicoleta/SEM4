package webubb.model;

public class Comment {
    private int id;
    private int topicID;
    private String author;
    private String text;

    public Comment(int topicID, String author, String text) {
        this.topicID = topicID;
        this.author = author;
        this.text = text;
    }

    public Comment(int id, int topicID, String author, String text) {
        this.id = id;
        this.topicID = topicID;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
