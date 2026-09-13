package br.com.fiap.jopanels;

import br.com.fiap.entities.User;
import br.com.fiap.services.LoginService;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;

public class Login {

    public User logar() throws SQLException, ClassNotFoundException {
        String userName = Jopt.input("Digite o seu usuario");
        String password = Jopt.input("Digite sua senha");

        LoginService loginService = new LoginService();

        return loginService.Login(userName, password);
    }
}
