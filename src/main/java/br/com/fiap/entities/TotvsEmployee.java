package br.com.fiap.entities;

public class TotvsEmployee {

    private int employeeId;
    private String name;
    private String email;
    private String role;

    public TotvsEmployee() {
    }

    public TotvsEmployee(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public TotvsEmployee(int employeeId, String name, String email, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public boolean validateEmail() {
        return email != null && email.contains("@");
    }

    public boolean validateName() {
        return name != null && !name.isBlank();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
