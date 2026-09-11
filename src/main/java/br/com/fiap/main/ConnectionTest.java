package br.com.fiap.main;

import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection cn = new ConexaoFactory().conexao();

        System.out.println("Conectado ao Banco de Dados com sucesso!");

        cn.close();
    }
}
