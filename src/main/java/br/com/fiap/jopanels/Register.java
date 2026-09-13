package br.com.fiap.jopanels;

import br.com.fiap.dao.ClientDao;
import br.com.fiap.dao.TotvsEmployeeDao;
import br.com.fiap.dao.UserDao;
import br.com.fiap.entities.Client;
import br.com.fiap.entities.TotvsEmployee;
import br.com.fiap.entities.User;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;

public class Register {
    public int registrar() throws SQLException, ClassNotFoundException {
        String[] userTypes = {"CLIENTE", "FUNCIONARIO"};
        int selectedType = Jopt.showOption(userTypes);

        if (selectedType == -1) {
            throw new IllegalArgumentException("Tipo de usuário não informado.");
        }

        String userType = userTypes[selectedType];

        String userName = Jopt.input("Digite um nome de usuário:");
        String userEmail = Jopt.input("Digite seu email:");
        String password = Jopt.input("Digite uma senha (mínimo 6 caracteres):");

        if (password.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 carácteres");
        }

        User user = new User(userName, userEmail, password, userType);

        if (!user.validateEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }

        UserDao userDao = new UserDao();
         int userId = userDao.createUser(user);

        if (userType.equals("CLIENTE")) {
            String phone = Jopt.input("Digite seu número de telefone:");
            String role = Jopt.input("Digite seu cargo:");
            String department = Jopt.input("Digite seu departamento:");

            Client client = new Client(userName, userEmail, phone, role, department);

            ClientDao clientDao = new ClientDao();
            clientDao.createClient(client);
        } else if (userType.equals("FUNCIONARIO")) {
            String role = Jopt.input("Digite seu cargo na TOTVS:");

            TotvsEmployee employee = new TotvsEmployee(userName, userEmail, role);

            TotvsEmployeeDao employeeDao = new TotvsEmployeeDao();
            employeeDao.createEmployee(employee);
        }

        return userId;
    }
}
