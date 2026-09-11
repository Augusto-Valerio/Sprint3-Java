package br.com.fiap.dao;

import br.com.fiap.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends FactoryDao {

    public LoginDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public User findUserByName(String userName) throws SQLException {
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
