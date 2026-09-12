package br.com.fiap.services;

import br.com.fiap.dao.LoginDao;
import br.com.fiap.entities.User;

import java.sql.SQLException;

public class LoginService {

    public User Login(String userName, String password) throws SQLException, ClassNotFoundException {
        LoginDao loginDao = new LoginDao();

        // Busca o usuario no banco de dados
        User user = loginDao.findUserByName(userName);

        if (user == null) {
            throw new IllegalArgumentException("Usuario não encontrado");
        }

        if (!user.getUserPassword().equals(password)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        return user;
    }
}
