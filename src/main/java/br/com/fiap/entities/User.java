package br.com.fiap.entities;

public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userType;

    public User() {
    }

    public User(String userName, String email, String userPassword, String userType) {
        this.userName = userName;
        this.userEmail = email;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public User(int userId, String userName, String email, String userPassword, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = email;
        this.userPassword = userPassword;
        this.userType = userType;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean passwordMatches(String password) {
        return userPassword != null && userPassword.equals(password);
    }

    public boolean validateEmail() {
        return userEmail != null && userEmail.contains("@");
    }
}


