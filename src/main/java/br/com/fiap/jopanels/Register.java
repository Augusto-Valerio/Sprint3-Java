package br.com.fiap.jopanels;

import br.com.fiap.dao.TotvsEmployeeDao;
import br.com.fiap.dao.UserDao;
import br.com.fiap.entities.TotvsEmployee;
import br.com.fiap.entities.User;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;

public class Register {
    public int registrar() throws SQLException, ClassNotFoundException {
        String userType = "FUNCIONARIO";

        String userName = Jopt.input("Digite um nome de usuário:");
        String userEmail = Jopt.input("Digite seu email:");
        String password = Jopt.input("Digite uma senha (mínimo 6 caracteres):");

        if (password.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 caracteres");
        }

        User user = new User(userName, userEmail, password, userType);

        if (!user.validateEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }

        UserDao userDao = new UserDao();
        int userId = userDao.createUser(user);

        String role = Jopt.input("Digite seu cargo na TOTVS:");

        TotvsEmployee employee = new TotvsEmployee(userId, userName, userEmail, role);

        TotvsEmployeeDao employeeDao = new TotvsEmployeeDao();
        employeeDao.createEmployee(employee);

        return userId;
    }
}
