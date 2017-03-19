
public class Message {

    private int id;
    private String author;
    private String message;

    /* Constructor */

    public Message(int id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }


    /* Getters - Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
