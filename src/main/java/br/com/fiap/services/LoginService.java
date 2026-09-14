package br.com.fiap.services;

import br.com.fiap.dao.LoginDao;
import br.com.fiap.entities.User;

import java.sql.SQLException;

public class LoginService {

    public User login(String userEmail, String password) throws SQLException, ClassNotFoundException {
        LoginDao loginDao = new LoginDao();

        // Busca o usuario no banco de dados
        User user = loginDao.findUserByEmail(userEmail);

        if (user == null) {
            throw new IllegalArgumentException("Usuario não encontrado");
        }

        if (!user.passwordMatches(password)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        return user;
    }
}
