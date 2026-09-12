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

    public User findByUserName(String userName) throws SQLException {
        ResultSet rs = select(
                "SELECT USER_ID, USER_NAME, USER_PASSWORD FROM USUARIO WHERE USER_NAME = ?",
                userName
        );

        if (rs.next()) {
            User user = new User(
                    rs.getString("USER_NAME"),
                    rs.getString("USER_PASSWORD")
            );

            user.setUserId(rs.getInt("USER_ID"));

            rs.close();

            return user;
        }

        rs.close();

        return null;
    }
}
