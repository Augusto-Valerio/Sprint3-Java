package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDao {

    public Connection connection;

    public FactoryDao() throws SQLException, ClassNotFoundException {
        this.connection = ConexaoFactory.conexao();
    }

    //Classes CRUD
    //Precisei colocar Object ... para poder aceitar mais valores exemplo

    //classe produto tem 3 valores pam:(sql, 1,2,3) o 1 2 e 3 podem mudar a quantidade dependendo do sql e de que vai utilizar

    public ResultSet insert(String sql, Object... valores) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(sql);

        for (int i = 0; i < valores.length; i++) {
            stmt.setObject(i + 1, valores[i]);
        }

        stmt.executeUpdate();
        stmt.close();

        return select(
                "SELECT USER_ID FROM USUARIO WHERE USER_NAME = ?",
                valores[0]
        );
    }

    public void update(String sql, Object... valores) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);

        for (int i = 0; i < valores.length; i++) {
            stmt.setObject(i + 1, valores[i]);
        }

        stmt.executeUpdate();
        stmt.close();
    }

    public void delete(String sql, Object... valores) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);

        for (int i = 0; i < valores.length; i++) {
            stmt.setObject(i + 1, valores[i]);
        }

        stmt.executeUpdate();
        stmt.close();
    }

    public ResultSet select(String sql, Object... valores) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(sql);

        for (int i = 0; i < valores.length; i++) {
            stmt.setObject(i + 1, valores[i]);
        }

        return stmt.executeQuery();
    }
}



