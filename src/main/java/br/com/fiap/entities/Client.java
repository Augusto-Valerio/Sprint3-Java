package br.com.fiap.entities;

public class Client {
    private int clientId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String department;

    public Client() {
    }

    public Client(String name, String email, String phone, String role, String department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
    }

    public Client(int clientId, String name, String email, String phone, String role, String department) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
    }

    public boolean validateEmail() {
        return email != null && email.contains("@");
    }

    public boolean validatePhone() {
        return phone != null && !phone.isBlank();
    }

    public boolean validateName() {
        return name != null && !name.isBlank();
    }

    public String showData() {
        return "ID: " + clientId +
                "\nNome: " + name +
                "\nEmail: " + email +
                "\nTelefone: " + phone +
                "\nCargo: " + role +
                "\nDepartamento: " + department;
    }


    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }
}
