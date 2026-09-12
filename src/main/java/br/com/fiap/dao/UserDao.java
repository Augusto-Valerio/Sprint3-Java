package br.com.fiap.dao;

import br.com.fiap.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends FactoryDao {
    public UserDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createUser(User user) throws SQLException {
        ResultSet rs = insert(
                "INSERT INTO USUARIO (USER_NAME, USER_PASSWORD) VALUES (?, ?)",
                user.getUserName(),
                user.getUserPassword()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("USER_ID");
        }

        rs.close();

        return id;
    }
}
