package model;

import contants.MessageType;

import java.util.List;

public class Account {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    String username;

    String password;

    String token;

    //String accessType;

    List<MessageType> accessTypes;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    String providerId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<MessageType> getAccessTypes() {
        return accessTypes;
    }

    public void setAccessTypes(List<MessageType> accessTypes) {
        this.accessTypes = accessTypes;
    }
}
