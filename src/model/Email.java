package model;

public class Email extends Request{

    String subject;

    public Email(String to, String from, String message, String subject) {
        this.subject = subject;
        this.message = message;
        this.receiverId = from;
        this.senderId = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"senderId\": \"%s\", \"receiverId\": \"%s\", \"message\": \"%s\", \"subject\": \"%s\"}",
                senderId, receiverId, message, subject
        );
    }
}
