package br.com.fiap.jopanels;

import br.com.fiap.dao.UserDao;
import br.com.fiap.utils.Jopt;
import java.sql.SQLException;

public class Register {

    private String user;
    private String pass;

    public int registrar() throws SQLException, ClassNotFoundException {
        boolean dadosValidos = false;

        while (!dadosValidos) {
            String usuario = Jopt.input("Informe seu usuário:");
            String senha = Jopt.input("Informe sua nova senha:");

            if (usuario == null || senha == null) {
                Jopt.showError("Cadastro cancelado pelo usuário.");
                return -1;
            }



            if (!usuario.isBlank() && !senha.isBlank() && senha.length() >= 6) {
                dadosValidos = true;
                this.user = usuario; // Usando 'this' para diferenciar do objeto DAO
                this.pass = senha;
            } else {
                Jopt.showError("Erro:\n- Todos os campos devem ser preenchidos;\n- A senha deve ter no mínimo 6 caracteres;");
            }
        }

        UserDao userDao = new UserDao();
        return userDao.createUser(this.user, this.pass);
    }
}
