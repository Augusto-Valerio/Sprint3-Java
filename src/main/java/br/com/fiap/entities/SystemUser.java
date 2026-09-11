package br.com.fiap.entities;

public class SystemUser {
    private int idUser;
    private String name;
    private String email;
    private String password;
    private String profile;

    public SystemUser() {
    }

    public SystemUser(int idUser, String name, String email, String password, String profile, String active) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public boolean passwordMatches(String typedPassword) {
        return password != null && password.equals((typedPassword));
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile() {
        return profile;
    }

}
