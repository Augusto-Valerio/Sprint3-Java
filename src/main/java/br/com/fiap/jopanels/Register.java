package br.com.fiap.jopanels;

import br.com.fiap.dao.UserDao;
import br.com.fiap.entities.User;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;

public class Register {
    public int registrar() throws SQLException, ClassNotFoundException {
        String userName = Jopt.input("Digite seu usuário:");
        String password = Jopt.input("Digite a sua nova senha:");

        if (password.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 carácteres");
        }

        User user = new User(userName, password);

        UserDao userDao = new UserDao();
        return userDao.createUser(user);
    }
}
