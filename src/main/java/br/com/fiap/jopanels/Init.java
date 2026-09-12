package br.com.fiap.jopanels;

import br.com.fiap.utils.Jopt;
import java.sql.SQLException;

public class Init {
    public static void mainPanel() throws SQLException, ClassNotFoundException {
        boolean run = true;
        Jopt.showMessage("Bem vindo a simulação de api TOTVS", "Sistema TOTVS");

        String[] optJOp = {"Logar", "Cadastrar Usuario", "Encerrar"};

        while (run) {
            int opt = Jopt.showOption(optJOp);

            if (opt == 0) {
                Jopt.showMessage("Funcionalidade de Login em desenvolvimento...", "Sistema TOTVS");

            } else if (opt == 1) {
                Register registro = new Register();
                int id = registro.registrar();

                String jsonSucesso = "Resultado Api TOTVS:\n{\n  \"Success\": true,\n  \"Id\": %d\n}".formatted(id);
                Jopt.showMessage(jsonSucesso, "Sistema TOTVS");

            } else if (opt == 2 || opt == -1) {
                Jopt.showMessage("Sistema encerrado", "Sistema TOTVS");
                run = false;
            }
        }
    }
}