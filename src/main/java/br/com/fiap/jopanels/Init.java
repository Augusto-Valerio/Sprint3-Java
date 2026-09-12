package br.com.fiap.jopanels;

import br.com.fiap.entities.User;
import br.com.fiap.utils.ApiResponse;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;

public class Init {
    public static void mainPanel() throws SQLException, ClassNotFoundException {
        boolean run = true;
        Jopt.showMessage("Bem vindo a simulação de api TOTVS", "Sistema TOTVS");

        String[] optJOp = {"Logar", "Cadastrar Usuario", "Encerrar"};

        while (run) {
            int opt = Jopt.showOption(optJOp);

            try {
                if (opt == 0) {
                    Login login = new Login();
                    User userLogged = login.logar();

                    Jopt.showMessage(ApiResponse.loginSuccess(userLogged), "Sistema TOTVS");

                } else if (opt == 1) {
                    Register registro = new Register();
                    int id = registro.registrar();

                    Jopt.showMessage(ApiResponse.registerSuccess(id), "Sistema TOTVS");

                } else if (opt == 2 || opt == -1) {
                    Jopt.showMessage("Sistema encerrado", "Sistema TOTVS");
                    run = false;
                }
            } catch (Exception e) {
                Jopt.showError(ApiResponse.error(e.getMessage()));
            }
        }
    }
}