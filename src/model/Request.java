package model;

public class Request {


    String senderId;

    String receiverId;

    String message;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return String.format(
                "{\"senderId\": \"%s\", \"receiverId\": \"%s\", \"message\": \"%s\"}",
                senderId, receiverId, message
        );
    }
}
