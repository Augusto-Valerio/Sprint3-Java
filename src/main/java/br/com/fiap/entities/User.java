package br.com.fiap.entities;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        userPassword = userPassword;
    }

    public boolean passwordMatches(String password) {
        return userPassword != null && userPassword.equals(password);
    }
}


