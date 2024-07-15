package model;

import java.sql.Timestamp;

public class Log {

    Provider provider;

    String message;

    String timestamp;

    public Log(Provider provider, String message, String timestamp) {
        this.provider = provider;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
