package br.com.fiap.entities;

public class User {
    private int userId;
    private String userName;
    private String UserPassWord;

    public User(String userName, String userPassWord) {
        this.userName = userName;
        UserPassWord = userPassWord;
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

    public String getUserPassWord() {
        return UserPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        UserPassWord = userPassWord;
    }
}


