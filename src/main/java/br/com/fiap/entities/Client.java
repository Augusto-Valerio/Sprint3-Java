package br.com.fiap.entities;

public class Client {
    private int clientId;
    private int companyId;
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

    public Client(int companyId, String name, String email, String phone, String role, String department) {
        this.companyId = companyId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
    }

    public Client(int clientId, int companyId, String name, String email, String phone, String role, String department) {
        this.clientId = clientId;
        this.companyId = companyId;
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
                "\nID Empresa: " + companyId +
                "\nNome: " + name +
                "\nEmail: " + email +
                "\nTelefone: " + phone +
                "\nCargo: " + role +
                "\nDepartamento: " + department;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
